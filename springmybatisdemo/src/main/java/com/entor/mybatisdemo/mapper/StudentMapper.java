package com.entor.mybatisdemo.mapper;

import com.entor.mybatisdemo.po.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface StudentMapper {

    @Select("select * from `student` where `id` = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id", javaType = int.class),
            @Result(column = "id", property = "courseList", javaType = List.class,
                    many = @Many(select = "com.entor.mybatisdemo.mapper.CourseMapper.getCoursesBySid"
                            , fetchType = FetchType.EAGER))
    })
    Student getById(Integer id);

    @Select("select * from `student` where `id` in (select `sid` from `sc` where `cid` = #{cid})")
    List<Student> getStudentsByCid(Integer cid);
}
