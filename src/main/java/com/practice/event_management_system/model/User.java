package com.practice.event_management_system.model;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
public class User {
    private UUID id = UUID.randomUUID();

    @NotBlank(message = "Username required")
    private String username;

    private LocalDate dateOfBirth;
    @Email(message = "Email does not match the pattern")
    @NotBlank(message = "Email required")
    private String email;

    @Size(min = 8, message = "Password must contain at least 8 characters")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$\n", message = "Password must be alphanumeric and contain special character")
    private String pass;

}
