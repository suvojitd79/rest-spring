package com.example.university;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String rollNumber;

    public Student() {
        super();
    }


    public Student(Long id,String name,String rollNumber) {
        super();
        this.id  = id;
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public Student(String name, String rollNumber) {
        super();
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }


    @Override
    public String toString(){
        return String.format("Student{%s, %s, %s}", this.id,this.name,this.rollNumber);
    }

}
