package com.design.pattern;

import java.util.Calendar;

/**
 * @Author: 98050
 * @Time: 2019-01-09 22:38
 * @Feature:
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Student student1 = new Student();
        student1.setName("1");
        student1.setAge(2);

        Professor professor = new Professor();
        professor.setName("a");
        professor.setAge(11);

        student1.setProfessor(professor);

        System.out.println("student1" + student1);

        Student student2 = (Student) student1.clone();
        Professor professor2 = student2.getProfessor();
        professor2.setName("b");
        professor2.setAge(22);
        student2.setProfessor(professor2);
        System.out.println(student1);
        System.out.println(student2);
    }
}
