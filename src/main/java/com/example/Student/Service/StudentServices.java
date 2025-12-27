package com.example.Student.Service;

import com.example.Student.Model.Student;
import com.example.Student.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentServices {
    @Autowired
    private StudentRepository repository;
    public void saveEntry(Student student){
        repository.save(student);
    }
    public List<Student> getAll(){
        return repository.findAll();
    }
    public Optional<Student> getByID(Long Id){
        return repository.findById(Id);
    }
    public void deleteID(Long Id){
        repository.deleteById(Id);
    }
}
