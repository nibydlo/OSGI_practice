package com.osgi.resources;

import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleActivator;

public class ResourceActivator implements BundleActivator{


    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Start bundle-hello-src");
    }

    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Stop bundle-hello-src");
    }
}
