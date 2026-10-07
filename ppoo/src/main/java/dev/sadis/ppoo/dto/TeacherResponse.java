package dev.sadis.ppoo.dto;

import dev.sadis.ppoo.entity.Teacher;

public record TeacherResponse(
        Long id,
        String names,
        String lastNames,
        String email
) {
    public static TeacherResponse build(Teacher teacher){
        return new TeacherResponse(
                teacher.getId(),
                teacher.getNames(),
                teacher.getLastNames(),
                teacher.getEmail()
        );
    }
}
