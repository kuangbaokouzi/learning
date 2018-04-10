package com.laowuandhisfriends.hibernate;

import com.laowuandhisfriends.hibernate.Spitter;

public interface SpitterDao {
    void addSpitter(Spitter spitter);

    long addSpitterAndGetAutoIncreaseId(Spitter spitter);

    void updateSpitter(Spitter spitter);

    Spitter getSpitterById(long id);
}
