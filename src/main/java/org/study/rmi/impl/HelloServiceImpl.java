package org.study.rmi.impl;

import org.study.rmi.HelloService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by ArnoldLee on 16/12/4.
 */
public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {

    public HelloServiceImpl() throws RemoteException{}

    public String sayHello(String name) throws RemoteException {
        return String.format("Hello%s",name);
    }
}
