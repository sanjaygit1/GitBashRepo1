package testNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 {

	@Test(dataProvider ="getData" )
	public void bookTickets(String src,String dest)
	{
		System.out.println("book tickets from---->"+src+"to"+dest);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr = new Object[2][2];
		
		objArr[0][0]="Banglore";
		objArr[0][1]="Goa";
		
		objArr[1][0]="Banglore";
		objArr[1][1]="mysore";
		
		return objArr;
	}
}
