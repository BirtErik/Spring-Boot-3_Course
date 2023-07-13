package com.course.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary //If this is used then there is no need for @Qualifier. NOT RECOMENDED
public class BaseballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "BaseballCoach";
    }
}
