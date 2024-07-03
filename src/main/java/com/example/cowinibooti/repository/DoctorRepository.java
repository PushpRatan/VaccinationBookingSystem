package com.example.cowinibooti.repository;

import com.example.cowinibooti.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    @Query(value = "Select * from doctor where age > :age", nativeQuery = true)
    List<Doctor> getByAgeGreaterthan(int age);
}
