package net.javaguides.employeeservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import net.javaguides.employeeservice.dto.APIResponseDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@Tag(
        name = "Employee Service REST API - EmployeeController",
        description = "Operations related to employees"
)
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    @Operation(
            summary = "Create a new employee",
            description = "Create a new employee with the provided details"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Employee created successfully")
    })
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody final EmployeeDto employeeDto) {
        final EmployeeDto savedEmployee = employeeService.create(employeeDto);

        return ResponseEntity.created(URI.create("/api/employees/" + savedEmployee.getId()))
                .body(savedEmployee);
    }

    @GetMapping("/{employeeId}")
    @Operation(
            summary = "Get employee by ID",
            description = "Retrieve an employee by its unique ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Employee not found")
    })
    public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable final Long employeeId) {
        final APIResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);

        return ResponseEntity.ok(apiResponseDto);
    }

}
