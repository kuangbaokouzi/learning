package com.entor.mybatisdemo;

import com.entor.mybatisdemo.mapper.CourseMapper;
import com.entor.mybatisdemo.mapper.HumanMapper;
import com.entor.mybatisdemo.po.Car;
import com.entor.mybatisdemo.po.Course;
import com.entor.mybatisdemo.po.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CourseTest {

    @Resource
    private CourseMapper courseMapper;

    @Test
    public void testGetById() {
        for (Student student : courseMapper.getById(5).getStudentList()) {
            System.out.println(student.getSname());
        }
    }

    @Test
    public void testGetCoursesBySid() {
        for (Course course : courseMapper.getCoursesBySid(1)) {
            System.out.println(course.getCname());
        }
    }
}
