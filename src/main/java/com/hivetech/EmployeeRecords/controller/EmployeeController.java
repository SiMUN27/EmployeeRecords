package com.hivetech.EmployeeRecords.controller;


import com.hivetech.EmployeeRecords.dto.EmployeeDto;
import com.hivetech.EmployeeRecords.dto.TimeSheetDto;
import com.hivetech.EmployeeRecords.models.Employee;
import com.hivetech.EmployeeRecords.models.TimeSheet;
import com.hivetech.EmployeeRecords.service.EmployeeService;
import com.hivetech.EmployeeRecords.service.TimeSheetService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;
    private final TimeSheetService timeSheetService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeeService.save(employeeDto));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(employeeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(employeeService.getEmployee(id));
    }
}
