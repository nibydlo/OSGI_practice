package com.osgi.service;

import org.osgi.service.component.annotations.*;

@Component
public class HelloUse {

    private Hello hello;

    @Reference(
            service = Hello.class,
            cardinality = ReferenceCardinality.MANDATORY,
            unbind = "unbinder"
    )
    protected void setGreeter(Hello hello) {
        this.hello = hello;
    }

    @Activate
    protected void onActivate() {
        System.out.println(hello.sayHello());
    }

    protected void unbinder(Hello hello) {
        this.hello = null;
    }
}
