package com.example.micrometer.micrometerspringboot15.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.config.MeterFilter;
import io.micrometer.core.instrument.distribution.DistributionStatisticConfig;
import io.micrometer.spring.autoconfigure.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class MicrometerConfiguration {

    @Bean
    MeterRegistryCustomizer meterRegistryCustomizer(MeterRegistry meterRegistry){

        Counter c = meterRegistry.counter("my.counter", "type", "header");


        return meterRegistry1 -> {
            meterRegistry.config()
                    .commonTags("application", "micrometer-youtube-example");
//                    .meterFilter( MeterFilter.deny( id -> {
//                        String uri = id.getTag("uri");
//                        return uri!=null && uri.startsWith("/swagger");
//                    } ) )
//                    .meterFilter(new MeterFilter() {
//                        @Override
//                        public DistributionStatisticConfig configure(Meter.Id id, DistributionStatisticConfig config) {
//                            return config.merge(DistributionStatisticConfig.builder()
//                                    .percentilesHistogram(true)
//                                    .percentiles(0.5, 0.75, 0.95)
//                                    .expiry(Duration.ofMinutes(10))
//                                    .bufferLength((int) (Duration.ofMinutes(10).toMillis() / Duration.ofSeconds(5).toMillis()))
//                                    .build());
//                        }
//                    });
        };

     //TODO DO a class that by aspects intercepts methods and record parameters,
        // check https://www.youtube.com/watch?v=HIUoeLYWo7o second 10
    }

}
