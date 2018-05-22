package com.entor.mybatisdemo;

import com.entor.mybatisdemo.mapper.NoticeMapper;
import com.entor.mybatisdemo.po.Notice;
import com.entor.mybatisdemo.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.InputStream;

@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class NoticeTest {

    @Resource
    private NoticeMapper noticeMapper;

    @Test
    public void testGetById() {
        System.out.println(noticeMapper.getById(1).getContent());
    }

    @Test
    public void testInsertNotice() {
        Notice notice = new Notice();
        notice.setContent("1.“精忠报国”是我一生追求的目标\n" +
                "\n" +
                "从小，习近平就在英雄故事的熏陶中成长。\n" +
                "\n" +
                "他常谈起五六岁时随母亲买《岳飞传》《岳母刺字》等小人书的故事。习近平说：“买回来之后，她就给我讲精忠报国、岳母刺字的故事。我说，把字刺上去，多疼啊！我母亲说，是疼，但心里铭记住了。‘精忠报国’四个字，我从那个时候一直记到现在，它也是我一生追求的目标。”\n" +
                "\n" +
                "1966年，上初中一年级的习近平听了焦裕禄的故事“受到深深震撼”。“记得1966年2月7日，《人民日报》刊登了穆青等同志的长篇通讯《县委书记的榜样——焦裕禄》……政治课老师在念这篇通讯的过程中几度哽咽，多次泣不成声，同学们也流下眼泪。”习近平动情地说到，“我们这一代人，是深受焦裕禄同志的事迹教育成长起来的。”");

        User user = new User();
        user.setId(1);
        notice.setUser(user);

        System.out.println(noticeMapper.save(notice));
    }

    @Test
    public void testDeleteNotice() {
        System.out.println(noticeMapper.deleteById(3));
    }

    @Test
    public void testUpdateNotice() {
        Notice notice = new Notice();
        notice.setId(1);
        notice.setTitle("微信封杀抖音");

        System.out.println(noticeMapper.update(notice));
    }
}
