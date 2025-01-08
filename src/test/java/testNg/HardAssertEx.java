package testNg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx {
	@Test
	public void m1() {
		System.out.println("Step1");
		System.out.println("Step2");
		Assert.assertEquals(true, false);
		System.out.println("Step3");
		System.out.println("Step4");
	}

	@Test
	public void m2() {
		String expData = "Qspiders ";
		String actData = "Qspiders";
		Assert.assertEquals(actData, expData);
	}

	@Test
	public void m3() {
		int a = 1;
		int b = 10;
		Assert.assertEquals(b, a, "Assert fail not Equal");
		System.out.println("Assert Pass Equal");
}

	@Test
	public void m4()
	{
		int a=10;
		int b=1;
		Assert.assertNotEquals(b, a, "it is equal");
		System.out.println("not equal");
	}
	
	@Test
	public void m5()
	{
		String s1="Shobh";
		String s2="Shobha";
		Assert.assertTrue(s1.equalsIgnoreCase(s2));
		System.out.println("Assert PASS");
	}
	@Test
	public void m6()
	{
		String s1="Shobh";
		String s2="Shobha";
		Assert.assertTrue(s1.equalsIgnoreCase(s2),"Assert FAIL");
		System.out.println("Assert PASS");
	}
	
	@Test
	public void m7()
	{
		String s1="Shobha";
		String s2="Shobha";
		Assert.assertFalse(s1.equalsIgnoreCase(s2), "equal==");
		System.out.println("Not Equal==");
	}
	
	@Test
	public void m8()
	{
		String s1="Shobha";
	Assert.assertNull(s1, "It is not Null");
		System.out.println("It is Null");
	}
	
	@Test
	public void m9()
	{
		String s1=null;
	Assert.assertNull(s1, "It is not Null");
		System.out.println("It is Null");
	}
	
	@Test
	public void m10()
	{
		String s1="Shobha";
		String s2="Shobh";
		Assert.assertSame(s1,s2," not Same");
		System.out.println("same=");
	}
	
	@Test
	public void m11()
	{
		String s1="Shobha";
		String s2="Shobh";
		Assert.assertNotSame(s1,s2," Same");
		System.out.println("Not same=");
	}
	
	@Test
	public void m12()
	
	{
		String s1="Shobha";
		String s2="Shobha";
		Assert.assertNotSame(s1,s2,"  Same");
		System.out.println("not same=");
	}
	
	@Test
	public void m13()
	{
		Assert.fail("im failing the script");
	}
}
