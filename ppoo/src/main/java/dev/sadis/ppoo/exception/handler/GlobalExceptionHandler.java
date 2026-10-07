package dev.sadis.ppoo.exception.handler;

import dev.sadis.ppoo.exception.TeacherEmailTakenException;
import dev.sadis.ppoo.exception.TeacherNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(TeacherEmailTakenException.class)
    public ResponseEntity<ApiErrorResponse> emailTakenException(TeacherEmailTakenException error, HttpServletRequest request){
        return buildResponse(HttpStatus.CONFLICT, error.getMessage(), request, null);
    }

    @ExceptionHandler(TeacherNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> teacherNotFoundException(TeacherNotFoundException error, HttpServletRequest request){
        return buildResponse(HttpStatus.NOT_FOUND, error.getMessage(), request, null);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException error, HttpServletRequest request){
        Map<String, String> errors = error.getBindingResult().getFieldErrors().stream().collect(Collectors.toMap(a-> a.getField(), b->b.getDefaultMessage(), (first,second) -> first));
        return buildResponse(HttpStatus.BAD_REQUEST, "Validation failed", request, errors);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiErrorResponse> dataIntegrityViolation(DataIntegrityViolationException error, HttpServletRequest request){
        log.warn("Data integrity violation on {}", request.getRequestURI(), error);
        return buildResponse(HttpStatus.CONFLICT, "Data integrity violation", request, null);
    }

    private ResponseEntity<ApiErrorResponse> buildResponse(HttpStatus code, String messageError, HttpServletRequest request, Map<String, String> errors){
        var response = new ApiErrorResponse(code, messageError, request.getRequestURI(), errors);
        return ResponseEntity.status(code).body(response);
    }
}
