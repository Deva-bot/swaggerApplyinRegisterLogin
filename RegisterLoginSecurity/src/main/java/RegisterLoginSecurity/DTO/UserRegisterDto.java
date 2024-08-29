package RegisterLoginSecurity.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegisterDto 
{
	@NotBlank(message = "Username is required")
	@Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
	@Schema(description = "The username of the user", example = "john_doe")
	private String userName;

	@NotBlank(message = "Password is required")
	@Size(min = 8, message = "Password must be at least 8 characters")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", 
	message = "Password must contain at least one uppercase letter, one lowercase letter, one digit, "
			+ "and one special character")
	@Schema(description = "The password of the user", example = "P@ssw0rd")
	private String password;

	@NotBlank(message = "Email is required")
	@Email(message = "Email should be valid")
	@Schema(description = "The email of the user", example = "user@example.com")
	private String email;
}
