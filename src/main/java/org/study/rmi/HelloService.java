package org.study.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by ArnoldLee on 16/12/4.
 */
public interface HelloService extends Remote {

    String sayHello(String name) throws RemoteException;
}
