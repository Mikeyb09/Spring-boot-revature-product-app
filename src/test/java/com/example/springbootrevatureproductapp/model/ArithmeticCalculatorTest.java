package com.example.springbootrevatureproductapp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ArithmeticCalculatorTest {

	ArithmeticCalculator calc;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
//		System.out.println("Set up before class");
		ArithmeticCalculator calc;
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
//		System.out.println("Set up after class");
	}

	@BeforeEach
	void setUp() throws Exception {
//		System.out.println("Set up before each test case");
		calc = new ArithmeticCalculator();
	}

	@AfterEach
	void tearDown() throws Exception {
//		System.out.println("Set up after each test case");
		calc = null;
	}
	
//	
//	Addition tests
//	

	@Test
	@DisplayName("Testing add method -1")
	void testAdd1() {
		assertEquals(20, calc.add(10, 10));
	}
	
	@Test
	@DisplayName("Testing add method -2")
	void testAdd2() {
		assertEquals(28, calc.add(14, 14));
	}

//	
//	Subtraction tests
//	
	
	@Test
	@DisplayName("Testing subtract method -1")
	void testSubtract1() {
		assertEquals(0, calc.subtract(10, 10));
	}
	
	@Test
	@DisplayName("Testing subtract method -2")
	void testSubtract2() {
		assertEquals(2, calc.subtract(12, 10));
	}
	
	@Test
	@DisplayName("Testing subtract method -3")
	void testSubtract3() {
		assertEquals(-2, calc.subtract(10, 12));
	}

//	
//	Multiplication tests
//	
	
	@Test
	@DisplayName("Testing multiply method -1")
	void testMultiply1() {
		assertEquals(100, calc.multiply(10, 10));
	}
	
	@Test
	@DisplayName("Testing multiply method -2")
	void testMultiply2() {
		assertEquals(25, calc.multiply(5, 5));
	}
	
	@Test
	@DisplayName("Testing multiply method -3")
	void testMultiply3() {
		assertEquals(-25, calc.multiply(5, -5));
	}
	
//	
//	Division Tests
//	
	
	@Test
	@DisplayName("Testing divide method -1")
	void testDivide1() {
		assertEquals(10, calc.divide(100, 10));		
	}
	
	@Test
	@DisplayName("Testing divide method -2")
	void testDivide2() {
		assertEquals(-10, calc.divide(100, -10));
	}
	
	@Test
	@DisplayName("Testing divide method -3")
	void testDivide3() {
		assertEquals(0.0, calc.divide(2, 3));
	}
	
	
//	
// Get Message Tests
//	
	
	@Test
	@DisplayName("Testing Get Message")
	void testGetMessage() {
		assertEquals("Hello and welcome to REVATURE app", calc.getMessage());
	}
}
