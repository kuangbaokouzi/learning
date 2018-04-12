package com.laowuandhisfriends.springmvc.service.impl;

import com.laowuandhisfriends.springmvc.entity.Spitter;
import com.laowuandhisfriends.springmvc.entity.Spittle;
import com.laowuandhisfriends.springmvc.service.SpitterService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service("spitterService")
public class SpitterServiceImpl implements SpitterService {

    private static List<Spittle> spittleList;
    private static List<Spitter> spitterList;

    static {
        Spitter spitter1 = new Spitter(1L, "tomcat", "tomcat@123", "SMITH");
        Spitter spitter2 = new Spitter(2L, "java", "java@123", "TOMMY");
        Spitter spitter3 = new Spitter(3L, "oracle", "oracle@123", "Lee");

        spitterList = Arrays.asList(spitter1, spitter2, spitter3);

        Spittle spittle1 = new Spittle(spitter1, "tomcat,tomcat@123,SMITH", new Date(System.currentTimeMillis() + 50000000000L));
        Spittle spittle2 = new Spittle(spitter2, "java,java@123,TOMMY", new Date(System.currentTimeMillis() + 20000000000L));
        Spittle spittle3 = new Spittle(spitter3, "oracle,oracle@123,Lee", new Date(System.currentTimeMillis() + 40000000000L));
        Spittle spittle4 = new Spittle(spitter1, "tomcat,tomcat@123,SMITH,tomcat,tomcat@123,SMITH", new Date(System.currentTimeMillis() + 30000000000L));
        Spittle spittle5 = new Spittle(spitter2, "java,java@123,TOMMY,java,java@123,TOMMY", new Date(System.currentTimeMillis() + 10000000000L));

        spittleList = Arrays.asList(spittle1, spittle2, spittle3, spittle4, spittle5);
    }

    @Override
    public Object getRecentSpittles(int pagesize) {
        return spittleList.stream().sorted(Comparator.comparing(Spittle::getWhen)).limit(3)
                .collect(toList());
    }

    @Override
    public Spitter getSpitter(String username) {
        return spitterList.stream().filter(spitter -> spitter.getUsername().equals(username))
                .collect(toList()).get(0);
    }

    @Override
    public Object getSpittlesForSpitter(String username) {
        return spittleList.stream().filter(spittle -> spittle.getSpitter().getUsername().equals(username))
                .collect(toList());
    }

    @Override
    public void saveSpitter(Spitter spitter) {
        spitterList.add(spitter);
    }
}
