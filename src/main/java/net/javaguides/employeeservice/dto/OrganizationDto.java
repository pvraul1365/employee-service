package net.javaguides.employeeservice.dto;

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
public class OrganizationDto {

    private Long id;
    private String organizationName;
    private String organizationDescription;
    private String organizationCode;
    private LocalDateTime createdDate;

}
