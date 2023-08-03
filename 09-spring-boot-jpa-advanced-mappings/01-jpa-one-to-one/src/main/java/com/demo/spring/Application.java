package com.demo.spring;

import com.demo.spring.dao.AppDAO;
import com.demo.spring.entity.Instructor;
import com.demo.spring.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO){
        return runner ->{
            createInstructor(appDAO);
        };
    }

    private void createInstructor(AppDAO appDAO) {
        Instructor instructor = new Instructor("Chad", "Darby", "darby@gmail.com");

        InstructorDetail instructorDetail = new InstructorDetail("http.YouTube.com", "coding");
        instructor.setInstructorDetail(instructorDetail);
        //NOTE: This Will ALSO save the details object

        //because of CascadeType.ALL

        System.out.println("Saving instructor: " + instructor);

        appDAO.save(instructor);

        System.out.println("Done");
    }
}
