package com.entor.mybatisdemo.mapper;

import com.entor.mybatisdemo.po.Course;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface CourseMapper {

    @Select("select * from `course` where `id` = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id", javaType = int.class),
            @Result(column = "id", property = "studentList", javaType = List.class,
                    many = @Many(select = "com.entor.mybatisdemo.mapper.StudentMapper.getStudentsByCid"
                            , fetchType = FetchType.EAGER))
    })
    Course getById(Integer id);

    @Select("select * from `course` where `id` in (select `cid` from `sc` where `sid` = #{sid})")
    List<Course> getCoursesBySid(Integer sid);
}
