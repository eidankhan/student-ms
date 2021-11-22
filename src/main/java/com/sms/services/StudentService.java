package com.sms.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sms.models.Student;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private List<Student> students = new ArrayList<>();

    public StudentService(){
        initialize();
    }

    public void initialize(){
        students.add(new Student(1, "Eidan Khan", "65"));
        students.add(new Student(2, "Vinod Bheel", "61"));
        students.add(new Student(3, "Asmat Zubair", "157"));
    }

    public List<Student> getAll(){
        return students;
    }


    public Student getById(Integer id){
        Optional<Student> student = students.stream().filter( element -> id == element.getId()).findAny();
        if(student.isPresent())
            return student.get();
        return null;
    }

    public Student add(Student student){
        this.students.add(student);
        return student;
    }

    public Student update(Student student){
        this.students.stream().filter(element -> element.getId() == student.getId());
        return null;
    }    

}
