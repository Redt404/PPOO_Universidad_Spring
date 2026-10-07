package dev.sadis.ppoo.service;

import dev.sadis.ppoo.dto.TeacherRequest;
import dev.sadis.ppoo.dto.TeacherResponse;
import dev.sadis.ppoo.entity.Teacher;
import dev.sadis.ppoo.exception.TeacherEmailTakenException;
import dev.sadis.ppoo.exception.TeacherNotFoundException;
import dev.sadis.ppoo.repository.ITeacherRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeacherService {
    private final ITeacherRepository teacherRepository;

    @Transactional
    public TeacherResponse createTeacher(TeacherRequest request){
        log.info("Creating teacher");
        validateEmail(request.email(), null);

        var teacher = Teacher.builder().names(request.names()).lastNames(request.lastNames()).email(request.email()).build();

        var savedTeacher = teacherRepository.save(teacher);
        log.info("Created teacher with id {}", savedTeacher.getId());

        return TeacherResponse.build(savedTeacher);
    }

    @Transactional(readOnly = true)
    public Page<TeacherResponse> findAll(Pageable pageable){
        log.info("Getting all teachers");
        return  teacherRepository.findAll(pageable).map(TeacherResponse::build);
    }

    @Transactional(readOnly = true)
    public TeacherResponse findById(Long id){
        log.info("Searching teacher with id {}", id);
        return TeacherResponse.build(searchTeacher(id));
    }

    @Transactional
    public TeacherResponse updateTeacher(Long id, TeacherRequest request){
        log.info("Updating teacher with id {}", id);
        var teacher = searchTeacher(id);
        validateEmail(request.email(), teacher.getEmail());

        teacher.setNames(request.names());
        teacher.setLastNames(request.lastNames());
        teacher.setEmail(request.email());

        return TeacherResponse.build(teacherRepository.save(teacher));
    }

    @Transactional
    public void deleteTeacher(Long id){
        log.info("Deleting teacher with id {}", id);
        var teacher = searchTeacher(id);
        teacherRepository.delete(teacher);
    }

    private Teacher searchTeacher(Long id){
        return teacherRepository.findById(id).orElseThrow(()-> new TeacherNotFoundException("The teacher with id " + id + " not found"));
    }

    private void validateEmail(String email, String currentEmail){
        if (Objects.equals(email, currentEmail)) return;
        if(teacherRepository.existsByEmail(email)) throw new TeacherEmailTakenException("The email " + email + " was already taken");
    }
}
