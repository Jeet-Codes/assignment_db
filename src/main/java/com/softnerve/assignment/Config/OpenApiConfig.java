package com.softnerve.assignment.Config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Sandeep Kumar",
                        email = "sandeep090304@gmail.com",
                        url = "https://github.com/Jeet-Codes/assignment_db.git"
                ),
                description = "OpenApi Documentation for Student",
                title = "OpenApi specification - Sandeep",
                termsOfService = "Term of Service"
        ),
        servers = @Server(
                description = "Local ENV",
                url = "https://localhost:8080"

        )
)
public class OpenApiConfig {


}
