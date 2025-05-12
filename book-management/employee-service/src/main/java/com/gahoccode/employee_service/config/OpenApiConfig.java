package com.gahoccode.employee_service.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Employee Api Specification",
                description = "Api Documentation for Employee Service",
                version = "1.0",
                contact = @Contact(
                        name = "Gahoccode",
                        email = "gahoccode215@gmail.com",
                        url = "https://fpt.edu.vn"
                ),
                license = @License(
                        name = "FPT License",
                        url = ""
                ),
                termsOfService = ""
        ),
        servers = {@Server(
                description = "Local ENV",
                url = "http://localhost:9092"
        ),
                @Server(
                        description = "Prod ENV",
                        url = "https://employee-service.prod.com"
                )
        }
)
public class OpenApiConfig {
}
