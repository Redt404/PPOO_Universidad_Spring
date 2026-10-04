package com.example.tutoria002.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.tutoria002.models.Teacher;

@Repository 
public interface ITeacherRepository  extends CrudRepository<Teacher,Integer> {

}
