package net.javaguides.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * EmployeeDto
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - pvraul
 * @version 24/08/2026 - 14:38
 * @since 1.17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(
        name = "EmployeeDto",
        description = "Data Transfer Object for Employee entity"
)
public class EmployeeDto {

    private Long id;

    @Schema(description = "First name of the employee")
    private String firstName;

    @Schema(description = "Last name of the employee")
    private String lastName;

    @Schema(description = "Email address of the employee")
    private String email;

    @Schema(description = "Code of the department the employee belongs to")
    private String departmentCode;

    @Schema(description = "Code of the organization the employee belongs to")
    private String organizationCode;

}
