package com.gahoccode.employee_service.command.controller;

import com.gahoccode.employee_service.command.command.CreateEmployeeCommand;
import com.gahoccode.employee_service.command.command.UpdateEmployeeCommand;
import com.gahoccode.employee_service.command.model.CreateEmployeeModel;
import com.gahoccode.employee_service.command.model.UpdateEmployeeModel;
import jakarta.validation.Valid;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addEmployee(@RequestBody CreateEmployeeModel model){
        CreateEmployeeCommand command = new CreateEmployeeCommand(UUID.randomUUID().toString(), model.getFirstName(), model.getLastName(),model.getKin(),false);
        return commandGateway.sendAndWait(command);
    }

    @PutMapping("/{employeeId}")
    public String updateEmployee(@Valid @RequestBody UpdateEmployeeModel model, @PathVariable String employeeId){
        UpdateEmployeeCommand command = new UpdateEmployeeCommand(employeeId, model.getFirstName(), model.getLastName(), model.getLastName(), model.getIsDisciplined());
        return commandGateway.sendAndWait(command);
    }

}
