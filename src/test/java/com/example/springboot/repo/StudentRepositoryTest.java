package com.example.springboot.repo;

import com.example.springboot.HibernateAndJpaWithSpringBootApplication;
import com.example.springboot.entity.Passport;
import com.example.springboot.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = HibernateAndJpaWithSpringBootApplication.class)
class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    public void retrieveStudentAndPassportDetails(){
        Student student = em.find(Student.class,10001L);
        logger.info("student -> {}", student);
        logger.info("passport ->{}", student.getPassport());
    }

    @Test
    @Transactional //Persistence Context
    public void someTest(){
        //Database Operation 1 - Retrieve student
        Student student = em.find(Student.class,10001L);
        //Persistence Context (student)

        //Database Operation 2 - Retrieve passport
        Passport passport = student.getPassport();
        //Persistence Context (student, passport)

        //Database Operation 3 - update passport
        passport.setNumber("A343434");
        //Persistence Context (student, passport++)

        //Database Operation 4 - update student
        student.setName("Ranga - updated");
        //Persistence Context (student++, passport++)
    }

    @Test
    @Transactional
    public void retrievePassportAndAssociatedStudent(){
        Passport passport = em.find(Passport.class,40001L);
        logger.info("student -> {}", passport);
        logger.info("passport ->{}", passport.getStudent());
    }

    @Test
    @Transactional
    public void retrieveStudentAndCourses(){
        Student student = studentRepository.findById(10001L);
        logger.info("student -> {}", student);
        logger.info("courses ->{}", student.getCourses());
    }

}