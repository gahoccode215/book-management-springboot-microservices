package com.gahoccode.employee_service.command.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeModel {
    @NotBlank(message = "Firstname is mandatory")
    private String firstName;
    @NotBlank(message = "Lastname is mandatory")
    private String lastName;
    @NotBlank(message = "kin is mandatory")
    private String kin;

    @NotNull(message = "Disciplined is mandatory")
    private Boolean isDisciplined;
}
