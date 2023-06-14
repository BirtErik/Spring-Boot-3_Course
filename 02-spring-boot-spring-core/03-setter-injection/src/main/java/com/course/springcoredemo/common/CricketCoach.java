package com.course.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component //Marks the class as a Spring bean/use for @Autowire
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice for 15 minutes!!!!";
    }
}
