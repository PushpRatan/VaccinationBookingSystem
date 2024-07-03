package com.example.cowinibooti.service;

import com.example.cowinibooti.Exceptions.NotPresentException;
import com.example.cowinibooti.Model.Appointment;
import com.example.cowinibooti.Model.Doctor;
import com.example.cowinibooti.Model.Person;
import com.example.cowinibooti.Model.VaccinationCenter;
import com.example.cowinibooti.dto.RequestDto.BookAppointmentRequest;
import com.example.cowinibooti.dto.ResponseDto.AddVaccinationCenterResponseDto;
import com.example.cowinibooti.dto.ResponseDto.BookAppointmentResponse;
import com.example.cowinibooti.repository.AppointmentRepository;
import com.example.cowinibooti.repository.DoctorRepository;
import com.example.cowinibooti.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    JavaMailSender javaMailSender;

    public BookAppointmentResponse bookAppointment(BookAppointmentRequest bookAppointmentRequest) {
        Optional<Person> optionalPerson = personRepository.findById(bookAppointmentRequest.getPersonId());
        if(!optionalPerson.isPresent()){
            throw new NotPresentException("Person not Registered");
        }

        Optional<Doctor> optionalDoctor = doctorRepository.findById(bookAppointmentRequest.getDoctorId());
        if(!optionalDoctor.isPresent()){
            throw new NotPresentException("Doctor not Registered");
        }

        Person person = optionalPerson.get();
        Doctor doctor = optionalDoctor.get();

        Appointment appointment = new Appointment();
        appointment.setAppointmentId(String.valueOf(UUID.randomUUID()));
        appointment.setPerson(person);
        appointment.setDoctor(doctor);

        Appointment savedAppointment = appointmentRepository.save(appointment);

        doctor.getAppointments().add(savedAppointment);
        person.getAppointment().add(savedAppointment);

        Person savedPerson = personRepository.save(person);
        Doctor savedDoctor = doctorRepository.save(doctor);
        VaccinationCenter center = savedDoctor.getVaccinationCenter();

        // Send Mail

        String text = "Congrats " + savedPerson.getName() + ", your appointment is successfully booked with "+ savedDoctor.getName() + " at " + center.getCenterName();

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("rajaryev@gmail.com");
        simpleMailMessage.setTo(savedPerson.getEmailId());
        simpleMailMessage.setSubject("Congrats!! Appointment booked for vaccine");
        simpleMailMessage.setText(text);

        javaMailSender.send(simpleMailMessage);


        AddVaccinationCenterResponseDto centerResponseDto = new AddVaccinationCenterResponseDto();
        centerResponseDto.setCenterName(center.getCenterName());
        centerResponseDto.setCenterType(center.getCenterType());
        centerResponseDto.setAdrress(center.getAdrress());

        BookAppointmentResponse bookAppointmentResponse = new BookAppointmentResponse();
        bookAppointmentResponse.setPersonName(savedPerson.getName());
        bookAppointmentResponse.setDoctorName(savedDoctor.getName());
        bookAppointmentResponse.setAppointmentId(savedAppointment.getAppointmentId());
        bookAppointmentResponse.setAppointmentDate(savedAppointment.getAppointmentDate());
        bookAppointmentResponse.setCenterResponseDto(centerResponseDto);

        return bookAppointmentResponse;
    }
}
