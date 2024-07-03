package com.example.cowinibooti.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Certififcate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String certificateNo;
    String confirmationMessage;

    @OneToOne
    @JoinColumn
    Person person;
}
