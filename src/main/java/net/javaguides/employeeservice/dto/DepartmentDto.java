package net.javaguides.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DepartmentDto
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - pvraul
 * @version 23/08/2026 - 15:44
 * @since 1.25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(
        name = "DepartmentDto",
        description = "Data Transfer Object for Department entity"
)
public class DepartmentDto {

    private Long id;

    @Schema(description = "Name of the department")
    private String departmentName;

    @Schema(description = "Description of the department")
    private String departmentDescription;

    @Schema(description = "Code of the department")
    private String departmentCode;

}
