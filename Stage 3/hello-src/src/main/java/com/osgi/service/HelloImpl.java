package com.osgi.service;
import org.osgi.service.component.annotations.*;

@Component(
        service = Hello.class,
        immediate = true
)
public class HelloImpl implements Hello {
    public String sayHello() {
        return "Hello OSGi World!";
    }
}
