package com.course.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Component scanning po defaultu radi samo u main packageu
//sve ostale packagee moramo navesti u dolje navedenom kodu
@SpringBootApplication(
		scanBasePackages = {"com.course.springcoredemo",
				"com.course.util"}
)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
