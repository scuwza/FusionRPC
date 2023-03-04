package com.wza.rpc.common.transport;

import com.wza.rpc.common.dto.RpcRequest;
import com.wza.rpc.common.extension.SPI;

@SPI
public interface RpcRequestTransport {
    /**
     * send rpc request to server and get result
     *
     * @param rpcRequest message body
     * @return data from server
     */
    Object sendRpcRequest(RpcRequest rpcRequest);
}
