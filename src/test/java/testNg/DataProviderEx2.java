package testNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx2 {

	@Test(dataProvider ="getData" )
	public void bookTickets(String src,String dest,int numOfppl)
	{
	//	System.out.println("book tickets from---->"+src+"to--->"+dest+"and--->"+numOfppl);
		System.out.println("Book Tickets from " + src + " to " + dest+","+numOfppl+"");
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr = new Object[3][3];
		
		objArr[0][0]="Banglore";
		objArr[0][1]="Goa";
		objArr[0][2]=3;
		
		objArr[1][0]="Banglore";
		objArr[1][1]="mysore";
		objArr[1][2]=4;
		
		objArr[2][0]="Banglore";
		objArr[2][1]="pune";
		objArr[2][2]=5;
		return objArr;
	}
}

