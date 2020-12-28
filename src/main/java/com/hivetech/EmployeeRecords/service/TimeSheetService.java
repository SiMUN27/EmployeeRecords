package com.hivetech.EmployeeRecords.service;

import com.hivetech.EmployeeRecords.dto.TimeSheetDto;
import com.hivetech.EmployeeRecords.exceptions.EmployeeNotFoundException;
import com.hivetech.EmployeeRecords.exceptions.TimeSheetNotFoundException;
import com.hivetech.EmployeeRecords.mapper.TimeSheetMapper;
import com.hivetech.EmployeeRecords.models.Employee;
import com.hivetech.EmployeeRecords.models.TimeSheet;
import com.hivetech.EmployeeRecords.repository.EmployeeRepository;
import com.hivetech.EmployeeRecords.repository.TimeSheetRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
public class TimeSheetService {

    private final TimeSheetRepository timeSheetRepository;
    private final TimeSheetMapper timeSheetMapper;
    private final EmployeeRepository employeeRepository;

    @Transactional
    public TimeSheetDto save(TimeSheetDto timeSheetDto){
        Employee employee = employeeRepository.findById(timeSheetDto.getEmployeeId()).orElseThrow(() ->
                new EmployeeNotFoundException(timeSheetDto.getEmployeeId().toString()));
        TimeSheet timeSheet = timeSheetMapper.map(timeSheetDto, employee);
        timeSheetDto.setId(timeSheet.getId());
        timeSheetRepository.save(timeSheet);
        return timeSheetDto;
    }

    @Transactional(readOnly = true)
    public TimeSheetDto getTimeSheet(Long id) {
        TimeSheet timeSheet = timeSheetRepository.findById(id)
                .orElseThrow(() -> new TimeSheetNotFoundException(id.toString()));
        return timeSheetMapper.mapToDto(timeSheet);
    }

    public List<TimeSheetDto> getAllTimeSheetsForEmployee(Long employeeId) {
/*        TimeSheet timeSheet = timeSheetRepository.findById(employeeId).orElseThrow(() -> new TimeSheetNotFoundException(employeeId.toString()));
        return timeSheetRepository.findByEmployee(timeSheet.getEmployee())
                .stream()
                .map(timeSheetMapper::mapToDto).collect(toList());*/
        Employee employee = employeeRepository.findById(employeeId).
                orElseThrow(() -> new EmployeeNotFoundException(employeeId.toString()));
        List<TimeSheet> timeSheets = timeSheetRepository.findByEmployee(employee);
        return timeSheets.stream().map(timeSheetMapper::mapToDto).collect(toList());
    }

    @Transactional(readOnly = true)
    public List<TimeSheetDto> getAll() {
        return timeSheetRepository.findAll()
                .stream()
                .map(timeSheetMapper::mapToDto)
                .collect(toList());
    }

}
