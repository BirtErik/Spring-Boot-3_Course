package com.course.springcoredemo.common;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component //Marks the class as a Spring bean/use for @Autowire
public class CricketCoach implements Coach {


    public CricketCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    //Define init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In doMyStartupStuff(): " +getClass().getSimpleName() );
    }

    //Define destroy methods
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("In doMyCleanupStuff(): " +getClass().getSimpleName() );
    }

    @Override
    public String getDailyWorkout() {
        return "Practice for 15 minutes :-)";
    }
}
