package com.entor.mybatisdemo.mapper;

import com.entor.mybatisdemo.po.Car;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface CarMapper {

    /**
     * 根据id查询车辆信息
     * @param id
     * @return
     */
    @Select("select * from `car` where `id` = #{id}")
    @Results({
            @Result(column = "hid",property = "human", one=
            @One(select = "com.entor.mybatisdemo.mapper.HumanMapper.getById",fetchType = FetchType.LAZY))
    })
    Car getById(Integer id);

    /**
     * 根据hid查询车辆信息
     *
     * @param hid
     * @return
     */
    @Select("select * from `car` where `hid` = #{hid}")
    List<Car> getCarsByHumanId(@Param("id") Integer hid);
}
