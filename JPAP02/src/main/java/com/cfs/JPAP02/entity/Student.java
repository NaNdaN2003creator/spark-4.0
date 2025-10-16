package com.cfs.JPAP02.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //for mapping -now  first creating laptop class in entity packege ,
    // agar main done classes main relationships identify karta hu , to har ek klasses ko koun uniquely ideatfy karta hain.

    // ab main mapping main laptop  klass main ka student bject ko leke likhung

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private Laptop laptop;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "teacher_id",unique = true)
    private Teacher teacher;

    @ManyToMany        /// maake sure kisi produt pe kaam kar rahe ho to many to mnay avoid karo
    @JoinTable(
            name = "student_course",
            joinColumns  = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @JsonIgnoreProperties("student")
    public Set<Course>courses = new HashSet<>();




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

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }
}




