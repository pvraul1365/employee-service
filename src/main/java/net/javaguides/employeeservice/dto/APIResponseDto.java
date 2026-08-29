package net.javaguides.employeeservice.dto;

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
public class APIResponseDto {

    private EmployeeDto employee;
    private DepartmentDto department;
    private OrganizationDto organization;

}
