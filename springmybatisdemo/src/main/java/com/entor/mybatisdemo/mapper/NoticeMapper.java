package com.entor.mybatisdemo.mapper;

import com.entor.mybatisdemo.mapper.provider.NoticeDynaSQLProvider;
import com.entor.mybatisdemo.po.Notice;
import org.apache.ibatis.annotations.*;

import static org.apache.ibatis.mapping.FetchType.EAGER;

public interface NoticeMapper {
    @Select("select * from `notice` where `id` = #{id}")
    @Results({
            @Result(column = "create_date", property = "createDate", javaType = java.util.Date.class),
            @Result(column = "user_id", property = "user", javaType = com.entor.mybatisdemo.po.User.class,
                    one = @One(select = "com.entor.mybatisdemo.mapper.UserMapper.getByIdForUser", fetchType = EAGER))
    })
    Notice getById(@Param("id") Integer id);

    @InsertProvider(type = NoticeDynaSQLProvider.class, method = "insertNotice")
    int save(Notice notice);

    @Delete("delete from `notice` where `id` = #{id}")
    int deleteById(Integer id);

    @UpdateProvider(type = NoticeDynaSQLProvider.class, method = "updateNotice")
    int update(Notice notice);
}
