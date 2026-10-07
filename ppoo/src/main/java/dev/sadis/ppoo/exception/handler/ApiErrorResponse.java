package dev.sadis.ppoo.exception.handler;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

public record ApiErrorResponse(
        LocalDateTime timestamp,
        int status,
        String error,
        String message,
        String path,
        Map<String, String> errors
) {

    public ApiErrorResponse(
            HttpStatus http,
            String message,
            String path,
            Map<String, String> errors
    ) {
        this(
                LocalDateTime.now(),
                http.value(),
                http.getReasonPhrase(),
                message,
                path,
                errors
        );
    }
}
