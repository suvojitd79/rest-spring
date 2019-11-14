package com.example.university;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping(path = "/api/students")
public class StudentController {

    @JsonSerialize
    class Error{}


    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(path = "/{id:\\d{4,10}}")
    public ResponseEntity<Object> getStudent(@PathVariable Long id){
        Student student;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type","application/json");
        try{
            Student s = studentRepository.getOne(id);
            student = new Student(s.getId(), s.getName(),s.getRollNumber());
            return new ResponseEntity<>(student, httpHeaders, HttpStatus.OK);
        }
        catch (EntityNotFoundException e){
            return new ResponseEntity<>(new Error(), httpHeaders, HttpStatus.NOT_FOUND);
        }
    }

}
