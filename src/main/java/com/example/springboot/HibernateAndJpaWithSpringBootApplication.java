package com.example.springboot;

import com.example.springboot.entity.*;
import com.example.springboot.repo.CourseRepository;
import com.example.springboot.repo.EmployeeRepository;
import com.example.springboot.repo.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan
public class HibernateAndJpaWithSpringBootApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(HibernateAndJpaWithSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {



//        employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));
//        employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
//
//        logger.info("All Employees -> {}", employeeRepository.retrieveAllEmployees());
//        studentRepository.insertStudentAndCourse(new Student("John"), new Course("Angular in 200 Steps"));
//        studentRepository.insertHardcodedStudentAndCourse();
//        List<Review> reviews = new ArrayList<>();
//        reviews.add(new Review("Great Hands-on Stuff","5"));
//        reviews.add(new Review("Hatsoff","5"));
//
//        courseRepository.addReviewsForCourse(10003L, reviews);

//        courseRepository.addHardcodedReviewsForCourse();

//        studentRepository.saveStudentWithPassport();
//        Course course = courseRepository.findById(10001L);
//        logger.info("Course 10001 -> {}", course);
//        courseRepository.save(new Course("Microservices"));
//        courseRepository.playWithEntityManager();
    }
}
