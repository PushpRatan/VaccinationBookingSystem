package com.example.cowinibooti.controller;

import com.example.cowinibooti.dto.RequestDto.AddVaccinationCenterRequestDto;
import com.example.cowinibooti.dto.ResponseDto.AddVaccinationCenterResponseDto;
import com.example.cowinibooti.service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/center")
public class VaccinationCenterController {

    @Autowired
    VaccinationCenterService vaccinationCenterService;

    @PostMapping("/add_center")
    public ResponseEntity addVaccinationCenter(@RequestBody AddVaccinationCenterRequestDto addVaccinationCenterRequestDto){
        try {
            AddVaccinationCenterResponseDto response = vaccinationCenterService.addVaccinationCenter(addVaccinationCenterRequestDto);
            return new ResponseEntity(response, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
