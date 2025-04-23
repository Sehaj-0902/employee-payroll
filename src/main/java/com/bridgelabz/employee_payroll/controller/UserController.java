package com.bridgelabz.employee_payroll.controller;

import com.bridgelabz.employee_payroll.dto.LoginDTO;
import com.bridgelabz.employee_payroll.dto.RegisterDTO;
import com.bridgelabz.employee_payroll.dto.ResponseDTO;
import com.bridgelabz.employee_payroll.dto.UserResponseDTO;
import com.bridgelabz.employee_payroll.model.User;
import com.bridgelabz.employee_payroll.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/authservice")
public class UserController {
    @Autowired
    private UserService userService;

    // Registration end-point
    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody RegisterDTO registerDTO) {
        UserResponseDTO userResponseDTO = userService.registerUser(registerDTO);
        return new ResponseEntity<>(userResponseDTO, userResponseDTO.getMessage().equals("error") ? HttpStatus.CONFLICT : HttpStatus.CREATED);
    }

    // Login end-point
    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> loginUser(@RequestBody LoginDTO loginDTO) {
        UserResponseDTO userResponseDTO = userService.loginUser(loginDTO);
        return new ResponseEntity<>(userResponseDTO, userResponseDTO.getMessage().equals("error") ? HttpStatus.UNAUTHORIZED : HttpStatus.OK);
    }
}
