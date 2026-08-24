package net.javaguides.employeeservice.dto;

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
public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}
