package Base_page;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utility.ScreenShot;

public class Listeners_class implements ITestListener {

	
	ExtentSparkReporter HTMLreports;
	ExtentReports reports;
	ExtentTest Test;
	
	public void configuration()
	{
		HTMLreports=new ExtentSparkReporter("ExtentReport.HTML");
		reports=new ExtentReports();
		reports.attachReporter(HTMLreports);
		
		//add system config
		reports.setSystemInfo("Machine", "Testpc1");
		reports.setSystemInfo("OS","Windows 11");
		reports.setSystemInfo("user", "Rohan");
		reports.setSystemInfo("Browser", "Chrome");
		
		//configuration
		HTMLreports.config().setDocumentTitle("ExtentReports");
		HTMLreports.config().setReportName("TestReport");
		HTMLreports.config().setTheme(Theme.DARK);
		HTMLreports.config().setTimeStampFormat("EEEE ,MMM dd, yyyy, hh:mm a,'('zzz')'");
		
		
	}
	@Override
	public void onStart(ITestContext context) {
		configuration();
		System.out.print("Script is start");
	}

	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		Test=reports.createTest(result.getName());
		Test.log(Status.PASS, MarkupHelper.createLabel("Name of The PASS Test:"+result.getName() ,ExtentColor.GREEN));
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Test=reports.createTest(result.getName());
		Test.log(Status.FAIL, MarkupHelper.createLabel("Name of The FAIL Test:"+result.getName() ,ExtentColor.RED));
		
	 }

	@Override
	public void onTestSkipped(ITestResult result) {

		Test=reports.createTest(result.getName());
		Test.log(Status.SKIP, MarkupHelper.createLabel("Name of The SkIP Test:"+result.getName() ,ExtentColor.YELLOW));
		
	}

	@Override
	public void onFinish(ITestContext context) {
	
		reports.flush();
	}

}
