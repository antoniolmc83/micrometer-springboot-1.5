package com.example.micrometer.micrometerspringboot15.aop;


import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Tags;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * https://github.com/micrometer-metrics/micrometer-samples-spring-boot-datadog/blob/master/build.gradle
 */
@Aspect
@Component
public class HeaderMetricsAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.example.micrometer.micrometerspringboot15.controller.HelloController.*(..) )")
    public void beforeHttoMethods(JoinPoint joinPoint){
        logger.info("Advice method: " + joinPoint.getArgs()[0]) ;
        logger.info("Advice method: " + joinPoint.getKind()) ;
        logger.info("Advice method: " + joinPoint.getSignature().getName()) ;
        logger.info("Advice method: " + joinPoint.getSignature().toShortString()) ;

        logger.info("Count before: " + Metrics.counter("headers." + joinPoint.getSignature().getName(), Tags.of("callerid", String.valueOf(joinPoint.getArgs()[0])) ).count());
        Metrics.counter("headers." + joinPoint.getSignature().getName(), Tags.of("callerid", String.valueOf(joinPoint.getArgs()[0])) ).increment();
        logger.info("Count after: " + Metrics.counter("headers." + joinPoint.getSignature().getName(), Tags.of("callerid", String.valueOf(joinPoint.getArgs()[0])) ).count());
    }

}
