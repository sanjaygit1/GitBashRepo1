package testNg;

import org.testng.annotations.Test;

public class SampleTest {

	@Test(invocationCount = 3)
	public void createContact() {

		System.out.println("contact created");
	}

	@Test
	public void modifyContact() {
		System.out.println("contact modified");
	}

	@Test
	public void deleteContact() {
		System.out.println("contact deleted");
	}
}
