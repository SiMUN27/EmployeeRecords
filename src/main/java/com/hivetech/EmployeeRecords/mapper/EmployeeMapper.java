package com.hivetech.EmployeeRecords.mapper;

import com.hivetech.EmployeeRecords.dto.EmployeeDto;
import com.hivetech.EmployeeRecords.models.Employee;
import com.hivetech.EmployeeRecords.models.TimeSheet;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(target = "numberOfTimeSheets", expression = "java(mapTimeSheets(employee.getTimeSheets()))")
    EmployeeDto mapEmployeeToDto(Employee employee);

   default Integer mapTimeSheets(List<TimeSheet> numberOfTimeSheets) {
        return numberOfTimeSheets.size();
    }

    @InheritInverseConfiguration
    @Mapping(target = "timeSheets", ignore = true)
    Employee mapDtoToEmployee(EmployeeDto EmployeeDto);
}
