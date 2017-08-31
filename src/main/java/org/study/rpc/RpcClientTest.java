package org.study.rpc;

import cn.creditease.zma.commons.rpc.RpcResponse;
import cn.creditease.zma.commons.rpc.client.RpcClient;

import java.math.BigDecimal;

/**
 * Created by ArnoldLee on 16/12/29.
 */
public class RpcClientTest {

    final static String path= "@outPut.getResult(#param)";

    final static String remoteTradeHost = "127.0.0.1:16962";

    public static void main(String[] args) throws Exception {
        BigDecimal param = new BigDecimal("1.111");
        RpcClient rpcClient = new RpcClient();
        RpcResponse rpcResponse = rpcClient.exchange(remoteTradeHost,path,param);
        BigDecimal result = (BigDecimal) rpcResponse.getBody();
        System.out.println(result);
    }
}
