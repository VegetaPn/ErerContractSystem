package utils;
public class APPException extends Exception {
private int exceptionCode;
private String message;
public APPException(String message)
{
	super();
	this.message=message;
	
}
public APPException(String message,int code)
{
	super();
	this.exceptionCode=code;
	this.message=message;
}
public String getMessage() 
{
	return exceptionCode+message;
}
public int getExceptionCode()
{
	return exceptionCode;
	
}
}
