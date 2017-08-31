package org.study.rmi;

import java.rmi.Naming;

/**
 * Created by ArnoldLee on 16/12/4.
 */
public class RmiClient {

    public static void main(String[] args) throws Exception{
        String url = "rmi://localhost:1099/rmi.helloImpl";
        HelloService helloService = (HelloService)Naming.lookup(url);
        String result = helloService.sayHello("Jack");
        System.out.println(result);
    }
}
