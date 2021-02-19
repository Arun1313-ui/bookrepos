package com.example.students;





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing 
@SpringBootApplication
public class StudentsApplication {
	Logger logger=LoggerFactory.getLogger(StudentsApplication.class);
	   public static void main(String[] args) {
		   
		SpringApplication.run(StudentsApplication.class, args);
	}

}
