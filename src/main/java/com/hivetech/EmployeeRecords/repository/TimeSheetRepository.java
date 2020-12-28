package com.hivetech.EmployeeRecords.repository;

import com.hivetech.EmployeeRecords.models.Employee;
import com.hivetech.EmployeeRecords.models.TimeSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TimeSheetRepository extends JpaRepository<TimeSheet, Long> {

    List<TimeSheet> findByEmployee(Employee employee);
}
