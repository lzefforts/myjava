package org.study.rmi;

import org.study.rmi.impl.HelloServiceImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Created by ArnoldLee on 16/12/4.
 */
public class RmiServer {

    public static void main(String[] args) throws Exception{
        int port = 1099;
        String url = "rmi://localhost:1099/rmi.helloImpl";
        LocateRegistry.createRegistry(port);
        Naming.rebind(url,new HelloServiceImpl());

    }
}
