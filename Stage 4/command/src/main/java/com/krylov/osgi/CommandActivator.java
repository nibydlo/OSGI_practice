package com.krylov.osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import java.util.Hashtable;

public class CommandActivator implements BundleActivator {


    public void start(BundleContext bundleContext) throws Exception {
        Hashtable props = new Hashtable();
        props.put("osgi.command.scope", "practice");
        props.put("osgi.command.function", "hello");
        bundleContext.registerService(Command.class.getName(), new Command(bundleContext), props);
    }

    public void stop(BundleContext bundleContext) throws Exception {

    }
}
