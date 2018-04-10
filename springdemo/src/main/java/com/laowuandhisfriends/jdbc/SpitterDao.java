package com.laowuandhisfriends.jdbc;

public interface SpitterDao {
    void addSpitter(Spitter spitter);

    long addSpitterAndGetAutoIncreaseId(Spitter spitter);

    void updateSpitter(Spitter spitter);

    Spitter getSpitterById(long id);
}
