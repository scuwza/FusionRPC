package com.wza.rpc.common.loadbalance;

import com.wza.rpc.common.dto.RpcRequest;
import com.wza.rpc.common.extension.SPI;

import java.util.List;

/**
 * Interface to the load balancing policy
 *
 * @author shuang.kou
 * @createTime 2020年06月21日 07:44:00
 */
@SPI
public interface LoadBalance {
    /**
     * Choose one from the list of existing service addresses list
     *
     * @param serviceUrlList Service address list
     * @param rpcRequest
     * @return target service address
     */
    String selectServiceAddress(List<String> serviceUrlList, RpcRequest rpcRequest);
}
