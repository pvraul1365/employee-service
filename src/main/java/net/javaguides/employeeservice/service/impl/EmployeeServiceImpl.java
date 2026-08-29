package net.javaguides.employeeservice.service.impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javaguides.employeeservice.dto.APIResponseDto;
import net.javaguides.employeeservice.dto.DepartmentDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.dto.OrganizationDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.exception.ResourceNotFoundException;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.APIClient;
import net.javaguides.employeeservice.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

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
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final APIClient apiClient;
//    private final RestTemplate restTemplate;
    private final WebClient webClient;

    @Override
    public EmployeeDto create(final EmployeeDto employeeDto) {

        final Employee employee = modelMapper.map(employeeDto, Employee.class);

        final Employee savedEmployee = employeeRepository.save(employee);

        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
//    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    public APIResponseDto getEmployeeById(final Long employeeId) {

        log.info("📤 - Inside getEmployeeById of EmployeeServiceImpl");

        final Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));

         final DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/departments/{id}", employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();

         final OrganizationDto organizationDto = webClient.get()
                 .uri("http://localhost:8083/api/organizations/{id}", employee.getOrganizationCode())
                 .retrieve()
                 .bodyToMono(OrganizationDto.class)
                 .block();

//        final DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());
        
        final APIResponseDto apiResponseDto = APIResponseDto.builder()
                .employee(modelMapper.map(employee, EmployeeDto.class))
                .department(departmentDto)
                .organization(organizationDto)
                .build();

        return apiResponseDto;
    }

    public APIResponseDto getDefaultDepartment(final Long employeeId, final Exception exception) {

        log.info("❌ - Inside getDefaultDepartment of EmployeeServiceImpl");

        final Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));

        final DepartmentDto departmentDto = DepartmentDto.builder()
                .departmentName("R&D Department")
                .departmentCode("RD001")
                .departmentDescription("Research and Development Department")
                .build();

        final APIResponseDto apiResponseDto = APIResponseDto.builder()
                .employee(modelMapper.map(employee, EmployeeDto.class))
                .department(departmentDto)
                .build();

        return apiResponseDto;
    }
}
