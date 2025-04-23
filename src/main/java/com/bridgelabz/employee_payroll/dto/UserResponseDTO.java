package com.bridgelabz.employee_payroll.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public @Data class UserResponseDTO<s1, s2> {
    private String message;
    private Object data;

    public UserResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}