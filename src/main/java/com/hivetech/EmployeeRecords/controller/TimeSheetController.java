package com.hivetech.EmployeeRecords.controller;

import com.hivetech.EmployeeRecords.dto.TimeSheetDto;
import com.hivetech.EmployeeRecords.service.TimeSheetService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/time-sheet")
@AllArgsConstructor
@Slf4j
public class TimeSheetController {

    private final TimeSheetService timeSheetService;

    @PostMapping
    public ResponseEntity<TimeSheetDto> createTimeSheet(@RequestBody TimeSheetDto timeSheetDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(timeSheetService.save(timeSheetDto));
    }

    @GetMapping
    public ResponseEntity<List<TimeSheetDto>> getAllTimeSheets() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(timeSheetService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<TimeSheetDto>> getTimeSheetsForEmployee(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(timeSheetService.getAllTimeSheetsForEmployee(id));
    }
}
