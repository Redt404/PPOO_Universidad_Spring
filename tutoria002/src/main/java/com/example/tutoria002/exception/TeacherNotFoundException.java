package com.example.tutoria002.exception;

public class TeacherNotFoundException extends RuntimeException{
    public TeacherNotFoundException(String message){
        super(message);
    }
}
