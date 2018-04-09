package com.laowuandhisfriends.di;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Sonnet29 implements Poem {
    private static String[] LINES = {
            "When, in disgrace with fortune and men's eyes,",
            "I all alone beweep my outcast state",
            "And trouble deaf heaven with my bootless cries"
    };

    public Sonnet29() {
    }

    @Override
    public void recite() {
        for (String line : LINES) {
            System.out.println(line);
        }
    }
}
