package com.example.cowinibooti.controller;

import com.example.cowinibooti.dto.RequestDto.BookDoseRequest;
import com.example.cowinibooti.service.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dose")
public class DoseController {

    @Autowired
    DoseService doseService;

    @PostMapping("/get_dose_1")
    public ResponseEntity getDose1(@RequestBody BookDoseRequest bookDose1Request){
        try {
            doseService.getDose1(bookDose1Request);
            return new ResponseEntity("Congrats! You are now dose 1 vaccinated", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/get_dose_2")
    public ResponseEntity getDose2(@RequestBody BookDoseRequest bookDose2Request){
        try {
            doseService.getDose2(bookDose2Request);
            return new ResponseEntity("Congrats! You are fully Vaccinated", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

