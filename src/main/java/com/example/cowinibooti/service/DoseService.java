package com.example.cowinibooti.service;

import com.example.cowinibooti.Exceptions.DoseNotTakenException;
import com.example.cowinibooti.Exceptions.NotPresentException;
import com.example.cowinibooti.Model.Dose;
import com.example.cowinibooti.Model.Person;
import com.example.cowinibooti.dto.RequestDto.BookDoseRequest;
import com.example.cowinibooti.repository.DoseRepository;
import com.example.cowinibooti.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DoseService {

    @Autowired
    DoseRepository doseRepository;

    @Autowired
    PersonRepository personRepository;

    public void getDose1(BookDoseRequest bookDose1Request) {
        //check weather person exists or not
        Optional<Person> optionalPerson = personRepository.findById(bookDose1Request.getPersonId());
        if(!optionalPerson.isPresent()){
            throw new NotPresentException("Invalid Person");
        }
        Person person = optionalPerson.get();
        //check weather dose1 taken or not
        if(person.isDose1Taken()) {
            throw new DoseNotTakenException("You have taken the Dose 1");
        }
        //create dose
        Dose dose = new Dose();
        dose.setDoseId(String.valueOf(UUID.randomUUID()));
        dose.setDoseType(bookDose1Request.getDoseType());
        dose.setPerson(person);

        person.setDose1Taken(true);
        person.getDosesTaken().add(dose);

        personRepository.save(person);
    }

    public void getDose2(BookDoseRequest bookDose2Request) {
        //check weather person exists or not
        Optional<Person> optionalPerson = personRepository.findById(bookDose2Request.getPersonId());
        if(!optionalPerson.isPresent()){
            throw new NotPresentException("Invalid Person");
        }
        Person person = optionalPerson.get();
        //check weather dose1 taken or not
        if(!person.isDose1Taken()) {
            throw new DoseNotTakenException("Take Dose 1 first");
        }

        //check weather dose2 taken or not
        if(person.isDose2Taken()) {
            throw new DoseNotTakenException("You are already vaccinated ");
        }
        //create dose
        Dose dose = new Dose();
        dose.setDoseId(String.valueOf(UUID.randomUUID()));
        dose.setDoseType(bookDose2Request.getDoseType());
        dose.setPerson(person);

        person.setDose2Taken(true);
        person.getDosesTaken().add(dose);

        personRepository.save(person);
    }

}
