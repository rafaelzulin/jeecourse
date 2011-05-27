package main;

import org.junit.Test;
import static junit.framework.Assert.*;

public class CalculatorTest {
	
	@Test
	public void addNumbersWithSameLength() {
		String result = new CalculatorImpl().add("1234", "1234");
		assertEquals("2468", result);
	}
	
	@Test
	public void addNumbersWithDifferentLengthLeftBiggerThanRight() {
		String result = new CalculatorImpl().add("1234", "123");
		assertEquals("1357", result);
	}
	
	@Test
	public void addNumbersWithDifferentLengthRightBiggerThanLeft() {
		String result = new CalculatorImpl().add("123", "1234");
		assertEquals("1357", result);
	}
	
	@Test
	public void addNumbersWithOneMemberEqualsZero() {
		String result = new CalculatorImpl().add("0", "1234");
		assertEquals("1234", result);
	}
	
	@Test
	public void addNumbersVerifyingOneDigitIsIncremented() {
		String result = new CalculatorImpl().add("9999", "9999");
		assertEquals("19998", result);
	}
	
	public void addZeros() {
		String result = new CalculatorImpl().add("0", "0");
		assertEquals("0", result);
	}
	
	@Test
	public void addNumbersVeryVeryBig() {
		String result = new CalculatorImpl().add("9223372036854775807088787878554269221474412112424265457878754454", "92233788878454544758720368547758079");
		assertEquals("9223372036854775807088787878646503010352866657182985826426512533", result);
	}
	
	@Test
	public void subtractNumbersWithDifferentLengths() {
		String result = new CalculatorImpl().add("1234", "251");
		assertEquals("1082", result);
	}
}
