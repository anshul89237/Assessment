package com.lpu.test;

import static org.junit.jupiter.api.Assertions.fail;

import org.hibernate.annotations.Parameter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DemoTest {
	
	@BeforeAll
	public static void m1()
	{
		System.out.println("BeforeAll");
	}
	
	@AfterAll
	public static void m2()
	{
		System.out.println("AfterAll");
	}
	
	@BeforeEach 
	public void m3()
	{
		System.out.println("BeforeEach test method");
	}
	
	@AfterEach
	public void m4()
	{
		System.out.println("AfterEach test method");
	}
	
	@Test
	public void demo1()
	{
		// check expected and actual equal or not
		Assertions.assertEquals("xyz", "xyz");
	}
	
	@Test
	public void demo2()
	{
		// expected value is not null
		Assertions.assertNotNull(9, "test fail message");
	}
	
	@Test
	public void demo3()
	{
		// matches the exception on both expected and actual
		Assertions.assertThrows(ArithmeticException.class, () -> {
			System.out.println(9 / 0);
		});
	}
	
	@Test
	public void demo4()
	{
		// checks whether it is not getting exception
		Assertions.assertDoesNotThrow(() -> {
			System.out.println(9 / 0);
		});
	}
	
	@Test
	public void demo5()
	{
		String s1 = "xyz";
		String s2 = "xyz";
		// compare the reference or object
		Assertions.assertSame(s1, s2);
	}
	
	@Test
	public void demo6()
	{
		int age = 17;
		if(age < 18)
		{
			fail("age is less than 18");
		}
	}
	
	@Test
	public void demo7()
	{
		int arr1[] = {10, 20};
		int arr2[] = {10, 20};
		Assertions.assertArrayEquals(arr1, arr2);
	}
	
	@Test
	public void demo8()
	{
		boolean res = true;
		Assertions.assertTrue(res);
	}
	
	@Test
	public void demo9()
	{
		boolean res = true;
		Assertions.assertFalse(res);
	}
	
	@ParameterizedTest
	@CsvSource({"2, 3, 5", "10, 20, 40", "1, 1, 2"})
	void testAddition(int a, int b, int expected)
	{
		int res = a + b;
		Assertions.assertEquals(expected, res);
	}
}
