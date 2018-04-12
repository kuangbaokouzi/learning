package com.laowuandhisfriends.springmvc.service;

import com.laowuandhisfriends.springmvc.entity.Spitter;

public interface SpitterService {
    Object getRecentSpittles(int pagesize);

    Spitter getSpitter(String username);

    Object getSpittlesForSpitter(String username);

    void saveSpitter(Spitter spitter);
}
