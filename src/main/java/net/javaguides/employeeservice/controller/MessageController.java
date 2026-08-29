package net.javaguides.employeeservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MessageController
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - pvraul
 * @version 28/08/2026 - 09:12
 * @since 1.17
 */
@RefreshScope
@RestController
@Tag(
        name = "Message Service REST API - MessageController",
        description = "Controller to retrieve messages from configuration"
)
public class MessageController {

    @Value("${spring.boot.message}")
    private String message;

    @GetMapping("/users/message")
    @Operation(
            summary = "Get message from configuration",
            description = "Retrieve the message value from the configuration server"
    )
    public String getMessage() {
        return message;
    }
}
