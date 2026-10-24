package com.example.tutoria002.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.tutoria002.models.Teacher;

public interface ITeacherRepository  extends CrudRepository<Teacher,Integer> {
    boolean existsByEmail(String email);
    boolean existsById(int id);
}
