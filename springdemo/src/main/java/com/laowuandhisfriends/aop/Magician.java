package com.laowuandhisfriends.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Magician implements MindReader {
    private String thoughts;

    @Pointcut(value = "execution(* com.laowuandhisfriends.aop.Thinker.thinkOfSomething(String))" +
            " && args(thoughts)")
    public void thinking(String thoughts) {

    }

    @Before("thinking(thoughts)")
    @Override
    public void interceptThoughts(String thoughts) {
        System.out.println("Intercepting volunteer's thoughts!");
        this.thoughts = thoughts;
    }

    @Override
    public String getThoughts() {
        return thoughts;
    }
}
