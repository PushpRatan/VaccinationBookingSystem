package com.example.cowinibooti.dto.ResponseDto;

import com.example.cowinibooti.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddVaccinationCenterResponseDto {
    String centerName;
    CenterType centerType;
    String adrress;
    String message;
}
