package com.laowuandhisfriends.di;

import java.util.Arrays;
import java.util.List;

public class SongSelector {
    private static List<String> list = Arrays.asList(
            "God's Plan", "Meant To Be", "Finesse", "Psycho", "Perfect", "Look Alive", "The Middle");

    public String selectSong() {
        return list.get((int) (Math.random() * list.size()));
    }
}
