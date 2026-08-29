package net.javaguides.employeeservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

/**
 * SwaggerConfig
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - pvraul
 * @version 29/08/2026 - 17:35
 * @since 1.17
 */
@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Employee Service Management REST APIs",
                version = "1.0",
                description = "API for managing employees in the system",
                /*contact = @Contact(
                        name = "Employee Service Support",
                        email = "support@employeeservice.com"
                ),*/
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html"
                )
        )/*,
        externalDocs = @ExternalDocumentation(
                description = "Employee Service Documentation",
                url = "http://www.employeeservice.com/docs"
        )*/
)
public class SwaggerConfig {
}
