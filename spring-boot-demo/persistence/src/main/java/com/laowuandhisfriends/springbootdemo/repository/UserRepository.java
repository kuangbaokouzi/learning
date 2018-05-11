package com.laowuandhisfriends.springbootdemo.repository;

import com.laowuandhisfriends.springbootdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link User} {@link Repository}
 */
@Repository
public class UserRepository {

    /**
     * In-memory storage
     */
    private ConcurrentMap<Integer, User> repository = new ConcurrentHashMap<>();

    /**
     * ID Generator
     */
    private final static AtomicInteger idGenerator = new AtomicInteger();

    /**
     * save user model
     *
     * @param user {@link User}
     * @return if saved successfully, return<code>true</code>, else return<code>false</code>
     */
    public boolean save(User user) {
        // ID begins with 1
        Integer id = idGenerator.incrementAndGet();
        user.setId(id);
        return repository.put(id, user) == null;
    }

    public Collection<User> getAll() {
        Collection<User> users = new ArrayList<>();
        repository.forEach((k, v) -> users.add(v));
        return users;
    }
}
