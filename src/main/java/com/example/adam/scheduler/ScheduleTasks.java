package com.example.adam.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ScheduleTasks {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleTasks.class);

    @Scheduled(fixedRate = 60000)
    public void performTask(){
        logger.info("Scheduled task running at : {}", LocalDateTime.now());
    }
}
