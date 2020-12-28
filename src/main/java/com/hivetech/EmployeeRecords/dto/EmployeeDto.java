package com.hivetech.EmployeeRecords.dto;

import com.hivetech.EmployeeRecords.models.TimeSheet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {
    private Long employeeId;
    private String name;
    private String surname;
    private String email;
    private String position;
    private Integer numberOfTimeSheets;
}
