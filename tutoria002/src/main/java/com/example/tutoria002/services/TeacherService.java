package com.example.tutoria002.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.tutoria002.models.Teacher;
import com.example.tutoria002.repositories.ITeacherRepository;

@Service
public class TeacherService {
    
    @Autowired 
    private ITeacherRepository teacherRepository;

    public Teacher createTeacher(Teacher teacher){
        // validar que no exista ya registrado un profersor
        // con ese email
        return teacherRepository.save(teacher);
    }

    public ArrayList<Teacher> getAll(){
        // Select * from teacher;
        return  (ArrayList<Teacher>) teacherRepository.findAll();
    }

    public Teacher updateTeacher(Teacher teacher){
        return existTeacher(teacher.getId()) ? teacherRepository.save(teacher) : null;
    }

    private boolean existTeacher(int id){
        return teacherRepository.findById(id) != null ? true : false;
    }

    // Crear metodo eliminacion service  -- void boolean
    // hagan del metodo de existTeacher para validacion


}
