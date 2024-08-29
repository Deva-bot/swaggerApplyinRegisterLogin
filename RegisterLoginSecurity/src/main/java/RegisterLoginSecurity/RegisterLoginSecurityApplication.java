package RegisterLoginSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
//swagger document details
@OpenAPIDefinition(info = @Info(
        title = "Spring Boot Security Register and Login",
        description = "API documentation for user registration and login with security features.",
        version = "1.0",
        contact = @Contact(name = "Support", email = "support@example.com", url = "http://www.example.com"),
        license = @License(name = "Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0.html")),
        externalDocs = @ExternalDocumentation(description = "Find out more about the API", url = "http://githup.com"))

public class RegisterLoginSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterLoginSecurityApplication.class, args);
	}

}
