package RegisterLoginSecurity.Service;

import RegisterLoginSecurity.DTO.LoginDto;

import RegisterLoginSecurity.DTO.UserRegisterDto;

public interface AuthService 
{
	public String userRegister(UserRegisterDto userRegisterDto);
	String userLogin(LoginDto loginDto);
}
