package com.exocodelabs.workflow;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Spring Boot CI is working!";
    }

    @GetMapping("/status")
    public String getStatus() {
        return "Application is running!";
    }

    @GetMapping("/echo")
    public String echo(@RequestParam(defaultValue = "test") String input) {
        return "Echo: " + input;
    }

    @GetMapping("/version")
    public String getVersion() {
        return "v1.0.0";
    }
}
