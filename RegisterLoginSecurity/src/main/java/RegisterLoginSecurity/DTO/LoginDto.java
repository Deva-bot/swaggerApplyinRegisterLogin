package RegisterLoginSecurity.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDto 
{

	@NotBlank(message = "Password is mandatory")
	@Schema(description = "The password of the user", example = "P@ssw0rd")    //swagger document variable details
	private String password;

	@NotBlank(message = "userName or Email is mandatory")
	@Schema(description = "The username or email of the user", example = "user@example.com")
	private String userNameOrEmail;

}