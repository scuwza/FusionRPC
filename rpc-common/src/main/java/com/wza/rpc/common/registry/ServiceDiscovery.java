package com.wza.rpc.common.registry;


import com.wza.rpc.common.dto.RpcRequest;
import com.wza.rpc.common.extension.SPI;

import java.net.InetSocketAddress;

/**
 * service discovery
 *
 * @author shuang.kou
 * @createTime 2020年06月01日 15:16:00
 */
@SPI
public interface ServiceDiscovery {
    /**
     * lookup service by rpcServiceName
     *
     * @param rpcRequest rpc service pojo
     * @return service address
     */
    InetSocketAddress lookupService(RpcRequest rpcRequest);
}
