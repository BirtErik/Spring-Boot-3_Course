package com.course.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //Marks the class as a Spring bean/use for @Autowire
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) //New instance on each injection look at REST
public class CricketCoach implements Coach {


    public CricketCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice for 15 minutes :-)";
    }
}
