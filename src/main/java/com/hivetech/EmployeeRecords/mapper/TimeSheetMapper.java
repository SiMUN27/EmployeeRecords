package com.hivetech.EmployeeRecords.mapper;

import com.hivetech.EmployeeRecords.dto.TimeSheetDto;
import com.hivetech.EmployeeRecords.models.Employee;
import com.hivetech.EmployeeRecords.models.TimeSheet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TimeSheetMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "startTime", dateFormat = "yyyy-MM-dd HH:mm")
    @Mapping(target = "endTime", dateFormat = "yyyy-MM-dd HH:mm")
    @Mapping(target = "employee", source = "employee")
    TimeSheet map(TimeSheetDto timeSheetDto, Employee employee);

    @Mapping(target = "employeeId", expression = "java(timeSheet.getEmployee().getEmployeeId())")
    TimeSheetDto mapToDto(TimeSheet timeSheet);
}
