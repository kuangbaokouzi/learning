package com.entor.mybatisdemo;

import com.entor.mybatisdemo.mapper.CourseMapper;
import com.entor.mybatisdemo.mapper.StudentMapper;
import com.entor.mybatisdemo.po.Course;
import com.entor.mybatisdemo.po.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentTest {

    @Resource
    private StudentMapper studentMapper;

    @Test
    public void testGetById(){
        for(Course course :studentMapper.getById(2).getCourseList()){
            System.out.println(course.getCname());
        }
    }

    @Test
    public void testGetStudentsByCid() {
        for (Student student : studentMapper.getStudentsByCid(4)) {
            System.out.println(student.getId());
        }
    }
}
