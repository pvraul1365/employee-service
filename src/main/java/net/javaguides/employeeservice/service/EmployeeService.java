package net.javaguides.employeeservice.service;

import net.javaguides.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto create(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

}
