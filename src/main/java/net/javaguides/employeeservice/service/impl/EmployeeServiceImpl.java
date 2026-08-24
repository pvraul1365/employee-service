package net.javaguides.employeeservice.service.impl;

import lombok.RequiredArgsConstructor;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * EmployeeServiceImpl
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - pvraul
 * @version 24/08/2026 - 14:39
 * @since 1.17
 */
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto create(final EmployeeDto employeeDto) {

        final Employee employee = Employee.builder()
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .email(employeeDto.getEmail())
                .build();

        final Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeDto.builder()
                .id(savedEmployee.getId())
                .firstName(savedEmployee.getFirstName())
                .lastName(savedEmployee.getLastName())
                .email(savedEmployee.getEmail())
                .build();
    }

}
