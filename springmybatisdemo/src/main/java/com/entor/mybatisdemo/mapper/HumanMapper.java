package com.entor.mybatisdemo.mapper;

import com.entor.mybatisdemo.po.Human;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface HumanMapper {

    /**
     * 根据id查询人的信息
     *
     * @param id
     * @return
     */
    @Select("select * from `human` where `id` = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id", javaType = int.class),
            @Result(column = "id", property = "cars", javaType = List.class,
                    many = @Many(select = "com.entor.mybatisdemo.mapper.CarMapper.getCarsByHumanId",
                            fetchType = FetchType.LAZY))
    })
    Human getById(Integer id);
}
