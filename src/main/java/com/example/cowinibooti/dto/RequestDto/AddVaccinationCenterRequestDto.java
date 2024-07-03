package com.example.cowinibooti.dto.RequestDto;

import com.example.cowinibooti.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddVaccinationCenterRequestDto {
    String centerName;

    CenterType centerType;

    String adrress;
}
