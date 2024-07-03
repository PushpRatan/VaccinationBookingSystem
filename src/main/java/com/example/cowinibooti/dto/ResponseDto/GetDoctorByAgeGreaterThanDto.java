package com.example.cowinibooti.dto.ResponseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetDoctorByAgeGreaterThanDto {
    String name;
    int age;
    String Gender;
}
