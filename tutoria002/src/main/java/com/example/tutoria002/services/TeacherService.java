package com.example.tutoria002.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tutoria002.exception.TeacherEmailTakenException;
import com.example.tutoria002.exception.TeacherNotFoundException;
import com.example.tutoria002.models.Teacher;
import com.example.tutoria002.repositories.ITeacherRepository;

@Service
public class TeacherService {
    
    @Autowired 
    private ITeacherRepository teacherRepository;

    public Teacher createTeacher(Teacher teacher){
        if(teacherRepository.existsByEmail(teacher.getEmail())) throw new TeacherEmailTakenException("The email " + " was already taken");
        return teacherRepository.save(teacher);
    }

    public ArrayList<Teacher> getAll(){
        return  (ArrayList<Teacher>) teacherRepository.findAll();
    }

    public Teacher updateTeacher(Teacher teacher){
        if(!teacherRepository.existsById(teacher.getId())) throw new TeacherNotFoundException("The teacher with id " + teacher.getId() + " not found");
        return teacherRepository.save(teacher);
    }

    // Eliminación
    public void deleteTeacher(int id){
        var teacher = searchTeacher(id);
        teacherRepository.delete(teacher);
    }

    private Teacher searchTeacher(int id){
        return teacherRepository.findById(id).orElseThrow(()-> new TeacherNotFoundException("The teacher with id " + id + " not found"));
    }

}
