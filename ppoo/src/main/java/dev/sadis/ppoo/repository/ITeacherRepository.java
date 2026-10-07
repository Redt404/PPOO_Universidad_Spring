package dev.sadis.ppoo.repository;

import dev.sadis.ppoo.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeacherRepository extends JpaRepository<Teacher, Long> {
    boolean existsByEmail(String email);
    boolean existsById(Long id);
    Page<Teacher> findAll(Pageable pageable);
}
