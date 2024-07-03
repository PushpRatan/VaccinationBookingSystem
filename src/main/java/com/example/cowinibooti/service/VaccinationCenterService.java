package com.example.cowinibooti.service;

import com.example.cowinibooti.Model.VaccinationCenter;
import com.example.cowinibooti.dto.RequestDto.AddVaccinationCenterRequestDto;
import com.example.cowinibooti.dto.ResponseDto.AddVaccinationCenterResponseDto;
import com.example.cowinibooti.repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationCenterService {

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    public AddVaccinationCenterResponseDto addVaccinationCenter(AddVaccinationCenterRequestDto addVaccinationCenterRequestDto) {
        VaccinationCenter vaccinationCenter = new VaccinationCenter();
        vaccinationCenter.setCenterName(addVaccinationCenterRequestDto.getCenterName());
        vaccinationCenter.setCenterType(addVaccinationCenterRequestDto.getCenterType());
        vaccinationCenter.setAdrress(addVaccinationCenterRequestDto.getAdrress());

        VaccinationCenter savedCenter = vaccinationCenterRepository.save(vaccinationCenter);

        AddVaccinationCenterResponseDto addVaccinationCenterResponseDto = new AddVaccinationCenterResponseDto();
        addVaccinationCenterResponseDto.setCenterName(savedCenter.getCenterName());
        addVaccinationCenterResponseDto.setCenterType(savedCenter.getCenterType());
        addVaccinationCenterResponseDto.setAdrress(savedCenter.getAdrress());
        addVaccinationCenterResponseDto.setMessage("Congrats!!! Vaccination center Created Successfully.");

        return addVaccinationCenterResponseDto;
    }
}
