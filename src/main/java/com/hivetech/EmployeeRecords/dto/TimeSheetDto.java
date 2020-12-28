package com.hivetech.EmployeeRecords.dto;

import com.hivetech.EmployeeRecords.models.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TimeSheetDto {

    private Long id;
    private Long employeeId;
    private String description;
    private Double hourlyRateHRK;
    private Date startTime;
    private Date endTime;
    private boolean paidOff;
}
