package me.mezage.functionalreactive.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@Configuration
public class ApplicationConfig {

    @Bean
    public Scheduler getScheduler() {
        return Schedulers.parallel();
    }
}
