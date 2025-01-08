package Generic_Utility;

import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportConfig implements ITestListener
{
ExtentReports report;
ExtentTest test;
	

	public void onTestStart(ITestResult result) 
	{
		//@Test Will Trigger
		test=report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {

		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
		System.out.println("TestSCript is Pass");
		
	}

	public void onTestFailure(ITestResult result)
	{
		
			String testName = result.getMethod().getMethodName();
			
			test.log(Status.FAIL, testName + "==>Failed==<");
			test.log(Status.FAIL, result.getMethod().getMethodName());
			test.log(Status.FAIL, result.getThrowable());
String screenshot = null;
			////			System.out.println("Script fail");
	//
//			System.out.println("----------im taking ScreenShot-----");
	//		String screenshot=null;
			try {
				screenshot = WebDriver_Utility.takeScreenShot1(BaseClass.sDriver, result.getMethod().getMethodName());

			} catch (Throwable e) {

				e.printStackTrace();
			}
			test.addScreenCaptureFromPath(screenshot);
			}

	public void onTestSkipped(ITestResult result) 
	{
		
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
		System.out.println("TestSCript is Skip");
	}

	public void onStart(ITestContext context) {
		
		String dateTime = new Date().toString().replace(" ", "_").replace(":", "_");
	//OutLook of the Report
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReports/Report.html"+dateTime);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("VtigerReport");
		spark.config().setReportName("Shobha");
		
		//System Configuration
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("PlatFrom", "windows");
		report.setSystemInfo("executedBy", "SHOBHA");
		report.setSystemInfo("ReviwedBy", "RATHIN");
		
	
	}

	public void onFinish(ITestContext context) {
		report.flush();
	}
	

}
