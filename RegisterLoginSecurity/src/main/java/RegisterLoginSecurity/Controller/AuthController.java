package RegisterLoginSecurity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import RegisterLoginSecurity.DTO.LoginDto;
import RegisterLoginSecurity.DTO.UserRegisterDto;
import RegisterLoginSecurity.Service.AuthService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	private AuthService authService;
	
	
	@Operation(summary = "Register a new user", description = "This endpoint allows a new user to register.")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "201", description = "User registered successfully"),
	        @ApiResponse(responseCode = "400", description = "Invalid input data")
    })

	@PostMapping("/register")
	public ResponseEntity<String> userRegister(@RequestBody @Valid UserRegisterDto userRegisterDto) {
		String userRegister = authService.userRegister(userRegisterDto);
		return new ResponseEntity<String>(userRegister, HttpStatus.CREATED);
	}

	@Hidden  // This hides the login end point from Swagger UI
	@Operation(summary = "User login", description = "This endpoint allows a user to log in.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User logged in successfully"),
        @ApiResponse(responseCode = "401", description = "Invalid credentials")
    })
	
	@PostMapping("/login")
	public ResponseEntity<String> userLogin(@RequestBody @Valid LoginDto loginDto) 
	{
		String loginResponse = authService.userLogin(loginDto);
		return new ResponseEntity<>(loginResponse, HttpStatus.OK);
	}
}
