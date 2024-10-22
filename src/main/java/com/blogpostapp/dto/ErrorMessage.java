package com.blogpostapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorMessage {
    private String errorMessage;
   // private Object object;
    private String errorCode;
    private LocalDateTime timestamp;
    private String contact;

}
