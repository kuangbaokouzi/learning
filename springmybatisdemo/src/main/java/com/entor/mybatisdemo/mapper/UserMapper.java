package com.entor.mybatisdemo.mapper;

import com.entor.mybatisdemo.po.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /**
     * 根据id查询用户，并返回Map
     *
     * @param id
     * @return {@link Map<String, User>}，字段作为K，字段值作为V
     */
    Map<String, User> getByIdForMap(Integer id);

    /**
     * 根据id查询用户，返回User对象
     *
     * @param id
     * @return {@link User}，注意字段与属性名之间的对应关系，如果不能自动映射，需要将resultType替换成resultMap
     */
    User getByIdForUser(Integer id);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(Integer id);

    List<User> findUser(User user);

    List<User> findAllUser();
}
