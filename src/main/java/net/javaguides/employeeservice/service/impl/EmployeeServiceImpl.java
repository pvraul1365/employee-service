package net.javaguides.employeeservice.service.impl;

import lombok.RequiredArgsConstructor;
import net.javaguides.employeeservice.dto.APIResponseDto;
import net.javaguides.employeeservice.dto.DepartmentDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.exception.ResourceNotFoundException;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;

    @Override
    public EmployeeDto create(final EmployeeDto employeeDto) {

        final Employee employee = modelMapper.map(employeeDto, Employee.class);

        final Employee savedEmployee = employeeRepository.save(employee);

        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    public APIResponseDto getEmployeeById(final Long employeeId) {

        final Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));

        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/{id}",
                DepartmentDto.class, employee.getDepartmentCode());
        final DepartmentDto departmentDto = responseEntity.getBody();
        final APIResponseDto apiResponseDto = APIResponseDto.builder()
                .employee(modelMapper.map(employee, EmployeeDto.class))
                .department(departmentDto)
                .build();

        return apiResponseDto;
    }

}
