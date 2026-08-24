package net.javaguides.employeeservice.controller;

import java.net.URI;
import lombok.RequiredArgsConstructor;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * EmployeeController
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - pvraul
 * @version 24/08/2026 - 15:26
 * @since 1.17
 */
@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody final EmployeeDto employeeDto) {
        final EmployeeDto savedEmployee = employeeService.create(employeeDto);

        return ResponseEntity.created(URI.create("/api/employees/" + savedEmployee.getId()))
                .body(savedEmployee);
    }

}
