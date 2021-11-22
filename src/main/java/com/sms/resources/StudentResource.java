package com.sms.resources;

import com.sms.models.Student;
import com.sms.services.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentResource {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public Object  getAll(){
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Object getById(@PathVariable Integer id){
        Student student = studentService.getById(id);
        if(student == null)
            return "No such record found with id:"+id;
        return student;
    }

    @PostMapping
    public Object save(@RequestBody Student student){
        return studentService.add(student);
    }
}
