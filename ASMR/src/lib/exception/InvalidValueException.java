package lib.exception;

public class InvalidValueException extends Exception
{
	String extraMessage = null;
	
	public InvalidValueException(String msg)
	{
		super(msg);
	}
	
	public InvalidValueException(String msg, String extra)
	{
		super(msg);
		extraMessage = extra;
	}
	
	public String getExtra()
	{
		return extraMessage;
	}
}
