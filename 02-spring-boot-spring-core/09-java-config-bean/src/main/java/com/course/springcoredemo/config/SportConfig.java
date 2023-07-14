package com.course.springcoredemo.config;

import com.course.springcoredemo.common.Coach;
import com.course.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aquatic") //@Bean with custom ID
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
