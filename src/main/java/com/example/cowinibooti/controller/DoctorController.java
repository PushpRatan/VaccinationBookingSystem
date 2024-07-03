package com.example.cowinibooti.controller;

import com.example.cowinibooti.dto.RequestDto.AddPersonRequestDto;
import com.example.cowinibooti.dto.ResponseDto.AddPersonResponseDto;
import com.example.cowinibooti.dto.ResponseDto.DoctorResponseDto;
import com.example.cowinibooti.dto.ResponseDto.GetDoctorByAgeGreaterThanDto;
import com.example.cowinibooti.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity addDoctor(@RequestParam("center") int centerId, @RequestBody AddPersonRequestDto addPersonRequestDto){
        try {
            DoctorResponseDto doctorResponseDto = doctorService.addDoctor(centerId, addPersonRequestDto);
            return new ResponseEntity(doctorResponseDto, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get_doctor_by_age_greater_than")
    public ResponseEntity getByAgeGreaterthan(@RequestParam int age){
        try {
            List<GetDoctorByAgeGreaterThanDto> Doctors = doctorService.getByAgeGreaterthan(age);
            return new ResponseEntity(Doctors, HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }
}
