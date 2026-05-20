package com.re.ss6exam.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiDataResponse<T> {
    private boolean success;
    private String message;
    private T data;
    private HttpStatus httpStatus;
}
