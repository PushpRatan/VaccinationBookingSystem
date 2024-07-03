package com.example.cowinibooti.repository;

import com.example.cowinibooti.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByEmailId(String oldEmail);
}
