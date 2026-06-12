package com.example.simple_order_processor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class AsyncConfig {

    @Bean(name = "eventExecutor")
    public Executor eventExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);        // always-on threads
        executor.setMaxPoolSize(10);        // burst capacity
        executor.setQueueCapacity(100);     // back-log before rejection
        executor.setThreadNamePrefix("event-worker-");
        executor.initialize();
        return executor;
    }
}
