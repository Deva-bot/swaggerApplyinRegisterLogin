package RegisterLoginSecurity.Exception;

public class UserNameOrEmailNotFoundException extends RuntimeException
{
	public UserNameOrEmailNotFoundException(String message)
	{
		super(message);
	}
}
