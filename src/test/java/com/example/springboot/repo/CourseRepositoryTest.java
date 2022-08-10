package com.example.springboot.repo;

import com.example.springboot.HibernateAndJpaWithSpringBootApplication;
import com.example.springboot.entity.Course;
import com.example.springboot.entity.Review;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = HibernateAndJpaWithSpringBootApplication.class)
class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository repository;

    @Autowired
    EntityManager em;

    @Test
    public void findById(){
        Course course = repository.findById(10001L);
        assertEquals("JPA in 50 Steps", course.getName());
    }

    @Test
    @DirtiesContext
    public void deleteById_basic(){
        repository.deleteById(10002L);
        assertNull(repository.findById(10002L));
    }

    @Test
    @DirtiesContext
    public void saveCourse(){
        //get a course
        Course course = repository.findById(1L);
        assertEquals("Microservices", course.getName());
        //update details
        course.setName("Microservices-Updated");
        repository.save(course);
        //check the values
        Course course1 = repository.findById(1L);
        assertEquals("Microservices-Updated", course.getName());
    }

    @Test
    @Transactional
    public void retrieveReviewsForCourse(){
        Course course = repository.findById(10003L);
        logger.info("{}", course.getReviews());
    }

    @Test
    @Transactional
    public void retrieveCourseForReview(){
        Review review = em.find(Review.class,50001L);
        logger.info("{}", review.getCourse());
    }
}