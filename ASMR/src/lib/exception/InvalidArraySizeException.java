package lib.exception;

public class InvalidArraySizeException extends Exception
{
	String extraMessage = null;
	
	public InvalidArraySizeException(String msg)
	{
		super(msg);
	}
	
	public InvalidArraySizeException(String msg, String extra)
	{
		super(msg);
		extraMessage = extra;
	}
	
	public String getExtra()
	{
		return extraMessage;
	}
}
