package com.example.springboot.repo;

import com.example.springboot.HibernateAndJpaWithSpringBootApplication;
import com.example.springboot.entity.Course;
import com.example.springboot.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@SpringBootTest(classes = HibernateAndJpaWithSpringBootApplication.class)
class JPQLTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository repository;

    @Autowired
    EntityManager em;

    @Test
    public void jpql_where(){
        TypedQuery<Course> query = em.createQuery("Select c from Course c where c.name like '%100 Steps'", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Courses in 100 Steps -> {}", resultList);
    }

   @Test
    public void jpql_courses_without_students(){
       TypedQuery<Course> query = em.createQuery("Select c from Course c where c.students is empty ", Course.class);
       List<Course> resultList = query.getResultList();

       logger.info("Courses without students -> {}", resultList);
   }

    @Test
    public void jpql_courses_with_at_least_2_students(){
        TypedQuery<Course> query = em.createQuery("Select c from Course c where size(c.students) >=2 ", Course.class);
        List<Course> resultList = query.getResultList();

        logger.info("Courses at least 2 students -> {}", resultList);
    }

    @Test
    public void jpql_courses_order_by_students(){
        TypedQuery<Course> query = em.createQuery("Select c from Course c order by size(c.students) desc", Course.class);
        List<Course> resultList = query.getResultList();

        logger.info("Courses ordered by number of students -> {}", resultList);
    }

    @Test
    public void jpql_students_with_passports_in_a_certain_pattern(){
        TypedQuery<Student> query = em.createQuery("Select s from Student s where s.passport.number like '%1234%'", Student.class);
        List<Student> resultList = query.getResultList();

        logger.info("Results -> {}", resultList);
    }

    @Test
    public void join(){
        Query query = em.createQuery("Select c, s from Course c join c.students s");
        List<Object[]> resultList = query.getResultList();

        logger.info("Result size -> {}", resultList.size());

        for(Object[] result: resultList){
            logger.info("Course{} Student{}",result[0],result[1] );
        }
    }

    @Test
    public void left_join(){
        Query query = em.createQuery("Select c, s from Course c left join c.students s");
        List<Object[]> resultList = query.getResultList();

        logger.info("Result size -> {}", resultList.size());

        for(Object[] result: resultList){
            logger.info("Course{} Student{}",result[0],result[1] );
        }
    }

    @Test
    public void cross_join(){
        Query query = em.createQuery("Select c, s from Course c, Student s");
        List<Object[]> resultList = query.getResultList();

        logger.info("Result size -> {}", resultList.size());

        for(Object[] result: resultList){
            logger.info("Course{} Student{}",result[0],result[1] );
        }
    }
}