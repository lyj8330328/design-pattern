package com.design.pattern;

/**
 * @Author: 98050
 * @Time: 2019-01-11 17:48
 * @Feature:
 */
public class Student implements Cloneable {

    private String name;
    private Integer age;
    private Professor professor;

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

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", professor=" + professor +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student newStudent = (Student) super.clone();
        newStudent.professor = (Professor) professor.clone();
        return newStudent;
    }
}
