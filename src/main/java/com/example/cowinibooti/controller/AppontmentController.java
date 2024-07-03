package com.example.cowinibooti.controller;

import com.example.cowinibooti.dto.RequestDto.BookAppointmentRequest;
import com.example.cowinibooti.dto.ResponseDto.BookAppointmentResponse;
import com.example.cowinibooti.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppontmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/bookAppointment")
    public ResponseEntity bookAppointment(@RequestBody BookAppointmentRequest bookAppointmentRequest){

        try {
            BookAppointmentResponse bookAppointmentResponse = appointmentService.bookAppointment(bookAppointmentRequest);
            return new ResponseEntity(bookAppointmentResponse, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
