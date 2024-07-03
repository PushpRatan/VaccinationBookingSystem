package com.example.cowinibooti.dto.RequestDto;

import com.example.cowinibooti.Enum.DoseType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookDoseRequest {
    int personId;
    DoseType doseType;
}
