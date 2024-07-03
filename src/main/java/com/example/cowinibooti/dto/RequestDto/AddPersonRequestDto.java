package com.example.cowinibooti.dto.RequestDto;

import com.example.cowinibooti.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddPersonRequestDto {
    String name;
    int age;
    String emailId;
    Gender gender;
}
