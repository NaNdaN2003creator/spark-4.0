package com.cfs.JPA01.controller;


import com.cfs.JPA01.entity.Student;
import com.cfs.JPA01.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {


    private final StudentRepo studentRepo; // here maine final nhi declare kiya to autiwired karke use kar sakta hu

    //--interview que --
    // agar apke class main ek variable hain , and u r using constructor for dependancy injection , to kya constructor pae autowire lagna jarroro hain

    // not necessatty java automatically take care

    public StudentController(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }


    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepo.save(student);// dataa save ho chukaa hain done

    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

   @PutMapping
    public Student updateStudent(@RequestParam Long id,@RequestBody Student student)
    {//System.out.println("id is ===>"+id);
       // return null;
        Student s = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
       s.setName(student.getName());
        s.setEmail(student.getEmail());
        return studentRepo.save(s);
    }

      @PatchMapping
      public Student patchedStudent(@RequestParam Long id,@RequestBody Student student)
    {

      Student s = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return studentRepo.save(student);
    }
}
