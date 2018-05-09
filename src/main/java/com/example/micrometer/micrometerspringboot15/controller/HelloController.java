package com.example.micrometer.micrometerspringboot15.controller;

import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/rest")
public class HelloController {

    @Timed(
            value = "techprimers.hello.request",
            //histogram = true,
            //percentiles = {0.95, 0.99},
            extraTags = {"version", "1.0"},
            longTask = true

    )
    @GetMapping("/hello")
    public String hello(@RequestHeader(name = "caller_id") String callerId ) {
        try {
            int sleep = new Random().nextInt(5000);
            System.out.println(sleep);
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Hello Youtube " + callerId;
    }

    @Timed(
            value = "techprimers.hello2.request",
            //histogram = true,
            //percentiles = {0.95, 0.99},
            //extraTags = {"version", "1.0"},
            longTask = true

    )
    @GetMapping("/hello2")
    public String hello2() {
        return "Hello Youtube";
    }
    @Timed(
            value = "techprimers.hello2.request",
            histogram = true,
            percentiles = {0.95, 0.99},
            extraTags = {"version", "1.0"},
            longTask = true
    )
    @GetMapping("/hello3")
    public String hello3() {
        return "Hello Youtube";
    }
    @Timed(
            value = "techprimers.hello2.request",
            histogram = true,
            percentiles = {0.95, 0.99},
            extraTags = {"version", "1.0"}
    )
    @GetMapping("/hello4")
    public String hello4() {
        return "Hello Youtube";
    }
}
