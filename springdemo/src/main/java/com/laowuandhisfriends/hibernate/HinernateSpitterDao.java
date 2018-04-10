package com.laowuandhisfriends.hibernate;

import com.laowuandhisfriends.hibernate.Spitter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("spitterDao")
public class HinernateSpitterDao implements SpitterDao {
    private SessionFactory sessionFactory;

    @Autowired
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addSpitter(Spitter spitter) {
        currentSession().save(spitter);
    }

    @Override
    public long addSpitterAndGetAutoIncreaseId(Spitter spitter) {
        return 0;
    }

    @Override
    public void updateSpitter(Spitter spitter) {
        currentSession().update(spitter);
    }

    @Override
    public Spitter getSpitterById(long id) {
        return currentSession().get(Spitter.class, id);
    }
}
