package com.wza.rpc.common.compress;


import com.wza.rpc.common.extension.SPI;

/**
 * @author wangtao .
 * @createTime on 2020/10/3
 */

@SPI
public interface Compress {

    byte[] compress(byte[] bytes);


    byte[] decompress(byte[] bytes);
}
