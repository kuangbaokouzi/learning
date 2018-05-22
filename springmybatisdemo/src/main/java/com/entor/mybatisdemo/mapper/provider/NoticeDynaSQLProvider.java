package com.entor.mybatisdemo.mapper.provider;

import com.entor.mybatisdemo.po.Notice;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

public class NoticeDynaSQLProvider {
    /**
     * 动态插入通知
     *
     * @param notice
     * @return
     */
    public String insertNotice(Notice notice) {
        return new SQL() {{
            INSERT_INTO("notice");
            if (!StringUtils.isEmpty(notice.getTitle())) {
                VALUES("title", "#{title}");
            }
            if (!StringUtils.isEmpty(notice.getContent())) {
                VALUES("content", "#{content}");
            }
            if (notice.getUser() != null && notice.getUser().getId() != null) {
                VALUES("user_id", "#{user.id}");
            }
        }}.toString();
    }

    /**
     * 动态更新通知
     *
     * @param notice
     * @return
     */
    public String updateNotice(Notice notice) {
        return new SQL() {{
            UPDATE("notice");
            if (!StringUtils.isEmpty(notice.getTitle())) {
                SET("title = #{title}");
            }
            if (!StringUtils.isEmpty(notice.getContent())) {
                SET("content = #{content}");
            }
            if (notice.getUser() != null && notice.getUser().getId() != null) {
                SET("user_id = #{user.id}");
            }
            WHERE(" `id` = #{id} ");
        }}.toString();
    }
}
