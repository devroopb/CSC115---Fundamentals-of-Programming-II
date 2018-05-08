/**
 * StackTester.java
 *
 * Some test cases for a stack.
 */
public class StackTester {
	public static void testOne (Stack<Integer> s) {
		try{
			if (!s.isEmpty()) {
				System.out.println("1: Failed isEmpty.");
			}
			s.push(1);
			s.push(2);
			if (s.isEmpty()) {
				System.out.println("2: Failed isEmpty.");
			}
			if (!s.pop().equals(2)) {
				System.out.println("3: Failed pop");
			}
			if (!s.peek().equals(1)) {
				System.out.println("4: Failed peek");
			}
			if (!s.pop().equals(1)) {
				System.out.println("5: Failed pop");
			}
			if (!s.isEmpty()) {
				System.out.println("6: Failed isEmpty.");
			}
		} catch (StackEmptyException e) {
			System.out.println(e);
		}	
	}
	
	public static void testTwo (Stack<Integer> s) {
		s.push(3);
		s.push(4);
		try {
			s.popAll();
			s.pop();
			System.out.println("Failed empty stack test.");
		} catch (StackEmptyException e) {
			// means we passed the test.
		}
	}
	
	public static void main (String args[])
	{
		Stack<Integer> s1 = new LLStack<Integer>();
		Stack<Integer> s2 = new LLStack<Integer>();
		System.out.println("Testing the stack: No messages indicate no errors");
		testOne(s1);
		testTwo(s2);
		System.out.println("Finished testing the stack");
	}
}
