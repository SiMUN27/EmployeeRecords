package com.hivetech.EmployeeRecords.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import org.springframework.lang.Nullable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TimeSheet {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Nullable
    private String description;
    private Double hourlyRateHRK;
    private Instant createdDate;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @JsonProperty("paidOff")
    private boolean paidOff;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId")
    private Employee employee;
}
