package dev.sadis.ppoo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TeacherRequest(
        @NotBlank(message = "Names are required")
        @Size(max = 100, message = "Names must not exceed 100 characters")
        String names,

        @NotBlank(message = "Last names are required")
        @Size(max = 100, message = "Last names must not exceed 100 characters")
        String lastNames,

        @NotBlank(message = "Email are required")
        @Email(message = "Email format is not valid")
        @Size(max = 150, message = "Email must not exceed 150 characters")
        String email
) {
}
