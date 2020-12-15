package org.acme.people;

import javax.inject.Inject;

import org.acme.people.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import io.quarkus.test.junit.QuarkusTest;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

@QuarkusTest
public class GreetingServiceTest {
    
    private static final Logger LOGGER = LoggerFactory.getLogger("GreetingServiceTest");

    @Inject
    GreetingService service;

    @Test
    public void testGreetingService() {
        LOGGER.info("greeting: " + service.greeting("Quarkus"));
        Assertions.assertTrue(service.greeting("Quarkus").startsWith("hello Quarkus"));
    }
}
