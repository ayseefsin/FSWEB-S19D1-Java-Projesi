package com.workintech.Sp19d1.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ExceptionResponse(String message, int status, LocalDateTime dateTime) {
}
