package com.wza.rpc.common.client.config;

import com.wza.rpc.common.annotation.RpcReference;
import com.wza.rpc.common.annotation.RpcService;
import com.wza.rpc.common.client.proxy.RpcClientProxy;
import com.wza.rpc.common.config.RpcServiceConfig;
import com.wza.rpc.common.extension.ExtensionLoader;
import com.wza.rpc.common.factory.SingletonFactory;
import com.wza.rpc.common.provider.ServiceProvider;
import com.wza.rpc.common.provider.impl.ZkServiceProviderImpl;
import com.wza.rpc.common.transport.RpcRequestTransport;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Slf4j
@Component
public class SpringBeanPostProcessor implements BeanPostProcessor {


    private final RpcRequestTransport rpcClient;

    public SpringBeanPostProcessor() {
        this.rpcClient = ExtensionLoader.getExtensionLoader(RpcRequestTransport.class).getExtension("netty");
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> targetClass = bean.getClass();
        Field[] declaredFields = targetClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            RpcReference rpcReference = declaredField.getAnnotation(RpcReference.class);
            if (rpcReference != null) {
                RpcServiceConfig rpcServiceConfig = RpcServiceConfig.builder()
                        .group(rpcReference.group())
                        .version(rpcReference.version()).build();
                RpcClientProxy rpcClientProxy = new RpcClientProxy(rpcClient, rpcServiceConfig);
                Object clientProxy = rpcClientProxy.getProxy(declaredField.getType());
                declaredField.setAccessible(true);
                try {
                    declaredField.set(bean, clientProxy);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        }
        return bean;
    }
}
