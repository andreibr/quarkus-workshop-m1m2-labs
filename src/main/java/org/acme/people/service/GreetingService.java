package org.acme.people.service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {
    private String hostname = System.getenv().getOrDefault("HOSTNAME", "2am note");

    public String greeting(String name) {
        return "hello " + name + " from " + hostname;
    }
}
