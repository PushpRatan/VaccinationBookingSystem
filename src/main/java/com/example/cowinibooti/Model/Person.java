package com.example.cowinibooti.Model;

import com.example.cowinibooti.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;
    int age;

    @Column(unique = true, nullable = false)
    String emailId;

    @Enumerated(EnumType.STRING)
    Gender gender;

    boolean dose1Taken;
    boolean dose2Taken;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    List<Dose> dosesTaken = new ArrayList<>();

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    Certififcate certififcate;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    List<Appointment> appointment = new ArrayList<>();
}
