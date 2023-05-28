package com.junit;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;


public class CalculatorTest {
	 Calculator cal;
	
	@BeforeAll
	static void beforeAll(){
		System.out.println("Before All: This will execute before all test cases.");
	}
	
	@AfterAll
	static void afterAll() {
		System.out.println("After All: This will execute after all test cases.");
	}
	
	@BeforeEach
	 void beforeEach() {
		cal = new Calculator();
	}
	
	@AfterEach
	 void afterEach() {
		cal = null; //null referencing
		System.out.println("Clean Up..");
	}
	
	@Test
	void testAddition()
	{
		Calculator cal = new Calculator();
		assertEquals(11, cal.addition(6, 5));
	}
	
	@Test
	@DisplayName("Testing Substraction Method")
	//we are disabling this test to run on Mac OS
	@DisabledOnOs(value = {OS.MAC})
	//we are enabling this test to run only on system that has
	//JRE between 11 and 19
	@EnabledForJreRange(min = JRE.JAVA_11, max=JRE.JAVA_19)
	//we are disabling this test for those who have JAVA_9 in this system
	@DisabledOnJre(value= JRE.JAVA_19)
	void testSubstraction()
	{
		Calculator cal = new Calculator();
		assertEquals(4, cal.substraction(10, 6));
	}
	
	@Test
	@DisplayName("Testing Division Method")
	void testDivision()
	{
		assertEquals(5, cal.division(25, 5),
		"This test method is to test division of two integer values");
	}
	
	@Test
     void testDivisionWithException()
	{
		assertThrows(ArithmeticException.class ,
		             ()-> cal.division(10, 0));
	}
	
	@Test 
	void testMultiplicationMethod()
	{
		assertAll(
				()-> assertEquals(10, cal.multiplication(5,2)),
				()-> assertEquals(100, cal.multiplication(25,4)),
				()-> assertEquals(-2, cal.multiplication(2,-1))
				);
	}
	
	@Test
	@DisplayName("Disabled Method")
	@Disabled
	void testDisabled()
	{
		fail("This test should be disabled.");
	}
	
	@Nested
	@DisplayName("All Addition Methods")
	class TestAdd
	{
		@Test 
		@DisplayName("Testing Addition Method")
		@EnabledOnOs(value = {OS.WINDOWS, OS.LINUX})
		void testAddition()
		{
			//Calculator cal = new Calculator();
			assertEquals(11, cal.addition(6, 5));
		}
		
		@Test
		@DisplayName("Testing Positive Addition")
		void testAddPositive()
		{
			assertEquals(25, cal.additionWithPositiveValue(20, 5));
		}
		
		@Test
		@DisplayName("Testing Negative Addition")
		void testAddNegative()
		{
			assertEquals(-5, cal.additionWithNegativeValue(-2, -3));
		}
	}//end of nested class
	
	@Test
	void testAssumption()
	{
		boolean flag = false;
		//assumeTrue(flag);
		assumeFalse(flag);
	}
	
	@Test
	@DisplayName("To chack null/not null and true/false")
	void test()
	{
		int num = 6;
		String st1 = "hi";
		String st2 = null;
		
		//check true condition
		assertTrue(num<10); //asserting the condition should be true
		
		//check false condition
		assertFalse(num>10); // asserting the condition should be false
		
		//checking for null
		assertNull(st2); // expecting str2 should be null
		
		//checking for not null
		assertNotNull(st1); //expecting str1 should not be null
	}
	
	 @Test
	 @DisplayName("Testing Factorial")
	  void testFactorial() {
	        assertEquals(24, cal.factorial(4));
	 }
	        

	  @Test
	  @DisplayName("Testing MaxValue")
	  void testMaxValue() {
	      int[] arr1 = {26, 58, 65, 12, 54};
	      assertEquals(65, cal.maxValue(arr1));
	      }
	

}




