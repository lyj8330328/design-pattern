package com.design.pattern.builder;

/**
 * @Author: 98050
 * @Time: 2019-01-11 15:16
 * @Feature:
 */
public class User2 {

    private String name;
    private Integer age;
    private String email;
    private String address;

    public static class Builder{
        private String name;
        private Integer age;
        private String email;
        private String address;


        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public User2 build(){
           User2 user2 = new User2();
           user2.name = name;
           user2.age = age;
           user2.address = address;
           user2.email = email;
           return user2;
        }
    }

    @Override
    public String toString() {
        return "User2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
