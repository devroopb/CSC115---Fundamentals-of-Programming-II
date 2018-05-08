//
// StackEmptyException.java
// 
// There is some question as to whether this should be a
// checked or unchecked exception.
//
// A discussion can be found here:
//
// For this assignment we have decided to make the 
// exception checked so that the exception handling
// mechanisms are explicit.
// 
public class StackEmptyException extends RuntimeException
{
	public StackEmptyException(String msg)
	{
		super(msg);
	}
	public StackEmptyException() {
		super();
	}
}

