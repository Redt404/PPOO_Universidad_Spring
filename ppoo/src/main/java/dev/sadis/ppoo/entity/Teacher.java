package dev.sadis.ppoo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "teachers")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "names", nullable = false, length = 100)
    private String names;

    @Column(name = "last_names", length = 100)
    private String lastNames;

    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;
}
