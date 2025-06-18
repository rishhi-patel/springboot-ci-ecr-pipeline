package com.exocodelabs.workflow;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class HelloController {

    @GetMapping("/")
    /**
     * Say hello message
     */
    public String sayHello() {
        return "Hello, Spring Boot CI is working!";
    }
}
