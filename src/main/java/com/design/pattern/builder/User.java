package com.design.pattern.builder;

/**
 * @Author: 98050
 * @Time: 2019-01-11 15:11
 * @Feature:
 */
public class User {

    private String name;
    private Integer age;
    private String email;
    private String address;


    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
