package com.course.springcoredemo.rest;

import com.course.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Struct;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public DemoController(
                        @Qualifier("cricketCoach") Coach theCoach,
                        @Qualifier("cricketCoach") Coach theAnotherCoach){
        System.out.println("In consturctor: " + getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
    @GetMapping("/check")
    public String check(){
        return "Comapring beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }
}
