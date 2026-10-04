package com.example.tutoria002.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.tutoria002.models.Teacher;
import com.example.tutoria002.services.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
//  localhost:8089/teacher
@RequestMapping("/teacher")
public class TeacherController {
    
    @Autowired 
    private TeacherService teacherService;

    @GetMapping
    public ResponseEntity<ArrayList<Teacher>> getAll(){
        return ResponseEntity.ok(teacherService.getAll());
    }

    @PostMapping
    public ResponseEntity<Teacher> save(@RequestBody Teacher teacher){
        return ResponseEntity.ok(teacherService.createTeacher(teacher));
    }

    @PutMapping
    public ResponseEntity<Teacher> update(@RequestBody Teacher teacher){
        return ResponseEntity.ok(teacherService.updateTeacher(teacher));
    }

    // Crear metodo eliminacion Controller

}
