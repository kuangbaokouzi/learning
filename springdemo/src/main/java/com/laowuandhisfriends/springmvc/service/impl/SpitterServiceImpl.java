package com.laowuandhisfriends.springmvc.service.impl;

import com.laowuandhisfriends.springmvc.entity.Spitter;
import com.laowuandhisfriends.springmvc.entity.Spittle;
import com.laowuandhisfriends.springmvc.service.SpitterService;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.stream.Collectors.toList;

@Service("spitterService")
public class SpitterServiceImpl implements SpitterService {

    private static List<Spittle> spittleList = new LinkedList<>();
    private static List<Spitter> spitterList = new LinkedList<>();

    static {
        Spitter spitter1 = new Spitter(1L, "tomcat", "tomcat@123", "SMITH");
        Spitter spitter2 = new Spitter(2L, "java", "java@123", "TOMMY");
        Spitter spitter3 = new Spitter(3L, "oracle", "oracle@123", "Lee");

        spitterList.add(spitter1);
        spitterList.add(spitter2);
        spitterList.add(spitter3);

        Spittle spittle1 = new Spittle(spitter1, "tomcat,tomcat@123,SMITH", new Date(System.currentTimeMillis() + 50000000000L));
        Spittle spittle2 = new Spittle(spitter2, "java,java@123,TOMMY", new Date(System.currentTimeMillis() + 20000000000L));
        Spittle spittle3 = new Spittle(spitter3, "oracle,oracle@123,Lee", new Date(System.currentTimeMillis() + 40000000000L));
        Spittle spittle4 = new Spittle(spitter1, "tomcat,tomcat@123,SMITH,tomcat,tomcat@123,SMITH", new Date(System.currentTimeMillis() + 30000000000L));
        Spittle spittle5 = new Spittle(spitter2, "java,java@123,TOMMY,java,java@123,TOMMY", new Date(System.currentTimeMillis() + 10000000000L));

        spittleList.add(spittle1);
        spittleList.add(spittle2);
        spittleList.add(spittle3);
        spittleList.add(spittle4);
        spittleList.add(spittle5);
    }

    @Override
    public Object getRecentSpittles(int pagesize) {
        return spittleList.stream().sorted(Comparator.comparing(Spittle::getWhen)).limit(3)
                .collect(toList());
    }

    @Override
    public Spitter getSpitter(String username) {
        for (Spitter spitter : spitterList) {
            if (username.equals(spitter.getUsername()))
                return spitter;
        }
        return null;
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
