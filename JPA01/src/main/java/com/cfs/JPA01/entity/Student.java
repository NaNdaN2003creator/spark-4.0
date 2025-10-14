package com.cfs.JPA01.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
public class Student {

    //isko primery key banna hain @Id used here
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    public Student(){

    }

    public Student(/*Long id*/ String name, String email) {
        // apkp idhar long id ki joroorat nhi hain,kyu , main bataunga appko //abhi ke liye rakho isko
        // Db agar id ko sambhal raha hain to constructor mainlene ki jarrort nhi hain
        /*this.id = id;*/
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
