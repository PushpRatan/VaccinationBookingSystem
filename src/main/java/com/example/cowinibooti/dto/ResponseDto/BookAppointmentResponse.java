package com.example.cowinibooti.dto.ResponseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookAppointmentResponse {
    String personName;
    String doctorName;
    String appointmentId;
    Date appointmentDate;
    AddVaccinationCenterResponseDto centerResponseDto;
}
