package hw1;

import static org.junit.Assert.*;

import org.junit.Test;

public class NestedParentheses {
    /**
	 * Check if the parentheses in the string str are properly nested. For
	 * example:
	 * 
	 * (()) - proper 
	 * 
	 * (() - not proper
	 * 
	 * An empty string is also considered to be a valid nesting.
	 * 
	 * @param str a string containing only the characters ( or ).
	 * @return true if the nesting is valid and false if not.
	 */

    public static boolean validNesting(String s) {
		if (s.length() == 0) {
			return true;
		} else if (s.length()%2 != 0) {
			return false;
		} else if ((s.charAt(0) == '(') && (s.charAt(s.length()-1) == ')')){
			return validNesting(s.substring(1, s.length()-1));
		}else {
			return false;
		}
	}
	public static void main(String[] args) {
		System.out.println(validNesting("((()))"));
	}

    @Test
	public void testEmptyString() {
		assertTrue("Incorrect result on empty string.", validNesting(""));
	}
	
	@Test
	public void testOneSetValid() {
		assertTrue("Incorrect result on ().", validNesting("()"));
	}
	
	@Test
	public void testLeftParenInvalid() {
		assertFalse("Incorrect result on (.", validNesting("("));
	}
	
	@Test
	public void testRightParenInvalid() {
		assertFalse("Incorrect result on ).", validNesting(")"));
	}
	
	@Test
	public void testTwoLeftInvalid() {
		assertFalse("Incorrect result on ((.", validNesting("(("));
	}
	
	@Test
	public void testTwoRightnvalid() {
		assertFalse("Incorrect result on ((.", validNesting("))"));
	}
	
	@Test
	public void testRightLefttnvalid() {
		assertFalse("Incorrect result on )(.", validNesting(")("));
	}
	
	@Test
	public void testMultipleValid() {
		assertTrue("Incorrect result on ((())).", validNesting("((()))"));
	}
	
	@Test
	public void testMultipleInvalid() {
		assertFalse("Incorrect result on ((((())).", validNesting("((((()))"));
	}
}