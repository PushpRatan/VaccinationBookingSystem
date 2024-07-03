package com.example.cowinibooti.service;

import com.example.cowinibooti.Exceptions.NotPresentException;
import com.example.cowinibooti.Model.Doctor;
import com.example.cowinibooti.Model.VaccinationCenter;
import com.example.cowinibooti.dto.RequestDto.AddPersonRequestDto;
import com.example.cowinibooti.dto.ResponseDto.AddVaccinationCenterResponseDto;
import com.example.cowinibooti.dto.ResponseDto.DoctorResponseDto;
import com.example.cowinibooti.dto.ResponseDto.GetDoctorByAgeGreaterThanDto;
import com.example.cowinibooti.repository.DoctorRepository;
import com.example.cowinibooti.repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    VaccinationCenterRepository centerRepository;

    public DoctorResponseDto addDoctor(int centerId, AddPersonRequestDto addPersonRequestDto) {
        Optional<VaccinationCenter> optionalCenter = centerRepository.findById(centerId);
        if(!optionalCenter.isPresent()){
            throw new NotPresentException("Vaccination Center Not Present");
        }

        VaccinationCenter center = optionalCenter.get();

        Doctor doctor = new Doctor();
        doctor.setName(addPersonRequestDto.getName());
        doctor.setGender(addPersonRequestDto.getGender());
        doctor.setAge(addPersonRequestDto.getAge());
        doctor.setEmailId(addPersonRequestDto.getEmailId());
        doctor.setVaccinationCenter(center);

        center.getDoctorList().add(doctor);
        centerRepository.save(center);

        DoctorResponseDto doctorResponseDto = new DoctorResponseDto();
        doctorResponseDto.setName(doctor.getName());

        AddVaccinationCenterResponseDto centerDetail = new AddVaccinationCenterResponseDto();
        centerDetail.setCenterType(center.getCenterType());
        centerDetail.setCenterName(center.getCenterName());
        centerDetail.setAdrress(center.getAdrress());
        centerDetail.setMessage("Doctor Added Successfully");
        doctorResponseDto.setCenterResponseDto(centerDetail);
        return doctorResponseDto;
    }


    public List<GetDoctorByAgeGreaterThanDto> getByAgeGreaterthan(int age){
        List<GetDoctorByAgeGreaterThanDto> ans = new ArrayList<>();
        List<Doctor> doctors = doctorRepository.getByAgeGreaterthan(age);
        for (Doctor d : doctors) {
            GetDoctorByAgeGreaterThanDto doc = new GetDoctorByAgeGreaterThanDto();
            doc.setAge(d.getAge());
            doc.setGender(String.valueOf(d.getGender()));
            doc.setName(d.getName());
            ans.add(doc);
        }
        return ans;
    }
}
