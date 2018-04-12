package com.laowuandhisfriends.springmvc.entity;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Spitter {
    private Long id;
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters long.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must be alphanumeric with no spaces.")
    private String username;
    @Size(min = 6, max = 20, message = "The password must be at least 6 characters long.")
    private String password;
    @Size(min = 3, max = 50, message = "FullName must be between 3 and 50 characters long.")
    private String fullName;
    @Pattern(regexp = "[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}", message = "Invalid email address.")
    private String email;
    private boolean updateByEmail;

    public Spitter() {
    }

    public Spitter(Long id, String username, String password, String fullName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isUpdateByEmail() {
        return updateByEmail;
    }

    public void setUpdateByEmail(boolean updateByEmail) {
        this.updateByEmail = updateByEmail;
    }

    @Override
    public String toString() {
        return "Spitter{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", updateByEmail=" + updateByEmail +
                '}';
    }
}
