package com.krylov.osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Command {

    private BundleContext bundleContext;

    public Command(BundleContext bc) {
        this.bundleContext = bc;
    }

    public void hello() {
        System.out.println("Expected some name after command");
    }

    public void hello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}
