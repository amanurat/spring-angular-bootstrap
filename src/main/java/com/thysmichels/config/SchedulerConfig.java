package com.thysmichels.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by tmichels on 8/9/14.
 */

@Configuration
@EnableScheduling
public class SchedulerConfig {

    @Scheduled(fixedRate = 1000)
    public void task(){

    }
}
