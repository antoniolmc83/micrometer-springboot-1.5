package com.example.micrometer.micrometerspringboot15.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.spring.autoconfigure.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MicrometerConfiguration {

    @Bean
    MeterRegistryCustomizer meterRegistryCustomizer(MeterRegistry meterRegistry){

        Counter c = meterRegistry.counter("my.counter", "type", "header");


        return meterRegistry1 -> {
            meterRegistry.config()
                    .commonTags("application", "micrometer-youtube-example");
        };

     //TODO DO a class that by aspects intercepts methods and record parameters,
        // check https://www.youtube.com/watch?v=HIUoeLYWo7o second 10
    }

}
