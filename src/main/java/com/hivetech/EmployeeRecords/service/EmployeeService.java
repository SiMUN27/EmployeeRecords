package com.hivetech.EmployeeRecords.service;

import com.hivetech.EmployeeRecords.dto.EmployeeDto;
import com.hivetech.EmployeeRecords.exceptions.EmployeeRecordsException;
import com.hivetech.EmployeeRecords.mapper.EmployeeMapper;
import com.hivetech.EmployeeRecords.models.Employee;
import com.hivetech.EmployeeRecords.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeService {


    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Transactional
    public EmployeeDto save(EmployeeDto employeeDto){
        Employee save = employeeRepository.save(employeeMapper.mapDtoToEmployee(employeeDto));
        employeeDto.setEmployeeId(save.getEmployeeId());
        return employeeDto;
    }

    @Transactional(readOnly = true)
    public List<EmployeeDto> getAll() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::mapEmployeeToDto)
                .collect(toList());
    }


    public EmployeeDto getEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeRecordsException("No employee found with ID - " + id));
        return employeeMapper.mapEmployeeToDto(employee);
    }
}
