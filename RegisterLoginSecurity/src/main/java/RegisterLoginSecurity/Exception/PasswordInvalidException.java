package RegisterLoginSecurity.Exception;

public class PasswordInvalidException extends RuntimeException
{
	public PasswordInvalidException(String message)
	{
		super(message);
	}
}
