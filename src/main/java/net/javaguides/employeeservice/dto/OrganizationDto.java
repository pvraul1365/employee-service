package net.javaguides.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * OrganizationDto
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - pvraul
 * @version 28/08/2026 - 21:59
 * @since 1.17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(
        name = "OrganizationDto",
        description = "Data Transfer Object for Organization entity"
)
public class OrganizationDto {

    private Long id;

    @Schema(description = "Name of the organization")
    private String organizationName;

    @Schema(description = "Description of the department")
    private String organizationDescription;

    @Schema(description = "Code of the department")
    private String organizationCode;

    @Schema(description = "Creation date of the organization")
    private LocalDateTime createdDate;

}
