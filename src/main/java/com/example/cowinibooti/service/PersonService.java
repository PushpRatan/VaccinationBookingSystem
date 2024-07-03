package com.example.cowinibooti.service;

import com.example.cowinibooti.Exceptions.NotPresentException;
import com.example.cowinibooti.Model.Person;
import com.example.cowinibooti.dto.RequestDto.AddPersonRequestDto;
import com.example.cowinibooti.dto.ResponseDto.AddPersonResponseDto;
import com.example.cowinibooti.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public AddPersonResponseDto addPerson(AddPersonRequestDto addPersonRequestDto) {
//      Request -> entity
        Person person = new Person();
        person.setName(addPersonRequestDto.getName());
        person.setAge(addPersonRequestDto.getAge());
        person.setGender(addPersonRequestDto.getGender());
        person.setEmailId(addPersonRequestDto.getEmailId());
        person.setDose1Taken(false);
        person.setDose2Taken(false);
        person.setCertififcate(null);


        Person savedPerson = personRepository.save(person);

//      Entity -> Response
        AddPersonResponseDto addPersonResponseDto = new AddPersonResponseDto();
        addPersonResponseDto.setName(savedPerson.getName());
        addPersonResponseDto.setMessage("Congrats! You are registered");
        return addPersonResponseDto;
    }

    public void updateEmail(String oldEmail, String newEmail) {
        Person person = personRepository.findByEmailId(oldEmail);
        if(person == null){
            throw new NotPresentException("Person doesn't exists");
        }
        person.setEmailId(newEmail);
        personRepository.save(person);
    }
}
