package net.javaguides.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * APIResponseDto
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - pvraul
 * @version 26/08/2026 - 09:08
 * @since 1.17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(
        name = "APIResponseDto",
        description = "Data Transfer Object for API response containing employee, department, and organization details"
)
public class APIResponseDto {

    @Schema(description = "Employee details")
    private EmployeeDto employee;

    @Schema(description = "Department details")
    private DepartmentDto department;

    @Schema(description = "Organization details")
    private OrganizationDto organization;

}
