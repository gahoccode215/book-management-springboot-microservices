package com.gahoccode.employee_service.command.controller;

import com.gahoccode.employee_service.command.command.CreateEmployeeCommand;
import com.gahoccode.employee_service.command.model.CreateEmployeeModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
