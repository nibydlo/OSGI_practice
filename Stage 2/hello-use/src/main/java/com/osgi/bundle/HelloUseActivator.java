package com.osgi.bundle;

import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleActivator;

import com.osgi.resources.Hello;
import com.osgi.resources.HelloImpl;
public class HelloUseActivator implements BundleActivator {

    public void start(BundleContext context) throws Exception
    {
        System.out.println("start bundle-hello-use");
        Hello hello = new HelloImpl();
        System.out.println(hello.sayHello());
    }

    public void stop(BundleContext context) throws Exception
    {
        System.out.println("stop bundle-hello-use");
    }
}
