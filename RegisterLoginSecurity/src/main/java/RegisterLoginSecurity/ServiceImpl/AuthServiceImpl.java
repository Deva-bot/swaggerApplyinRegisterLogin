package RegisterLoginSecurity.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import RegisterLoginSecurity.DTO.LoginDto;
import RegisterLoginSecurity.DTO.UserRegisterDto;
import RegisterLoginSecurity.DtoToEntityConverter.UserRegisterDtoToEntity;
import RegisterLoginSecurity.Entity.Users;
import RegisterLoginSecurity.Exception.EmailAlreadyExistsException;
import RegisterLoginSecurity.Exception.PasswordInvalidException;
import RegisterLoginSecurity.Exception.UserNameAlreadyExistsException;
import RegisterLoginSecurity.Repository.UserRepository;
import RegisterLoginSecurity.Service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRegisterDtoToEntity userRegisterDtoToEntity;

	@Override
	public String userRegister(UserRegisterDto userRegisterDto) {
		Optional<Users> existsEmail = userRepository.findByEmail(userRegisterDto.getEmail());

		if (existsEmail.isPresent()) {
			throw new EmailAlreadyExistsException("Email already exists with: " + userRegisterDto.getEmail());
		}

		Optional<Users> existsUserName = userRepository.findByUserName(userRegisterDto.getUserName());
		if (existsUserName.isPresent()) {
			throw new UserNameAlreadyExistsException(
					"UserName already exists with userName: " + userRegisterDto.getUserName());
		}

		Users users = userRegisterDtoToEntity.userRegisterDtoToEntity(userRegisterDto);
		userRepository.save(users);

		return "User Registers Successfully!";
	}

	@Override
	public String userLogin(LoginDto loginDto)  
	{
	    try 
	    {
	         Authentication authentication = authenticationManager
	                .authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUserNameOrEmail(),loginDto.getPassword()));
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        return "User logged in successfully!";
	    } 
	    catch (BadCredentialsException e) 
	    {
	    	throw new PasswordInvalidException("Password is incorrect. Please try again.");
	    }
	   
	 }
}
