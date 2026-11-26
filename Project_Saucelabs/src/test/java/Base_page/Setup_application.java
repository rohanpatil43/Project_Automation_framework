package Base_page;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utility.ScreenShot;


public class Setup_application {

	public  EdgeDriver driver;
	

    public static Properties prop;
	public Setup_application() {
        try {
            prop = new Properties();
            
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	@BeforeMethod
	public void steup()
	{
		driver=new EdgeDriver();
		
		driver.get(prop.getProperty("url"));
		
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void close(ITestResult result) throws InterruptedException 
	{		
		  if (result.getStatus() == ITestResult.FAILURE) {
	            ScreenShot.takeScreenShot(driver, result.getName());
	        }
	        
		Thread.sleep(5000);
		
		if(driver!=null)
		{
			driver.close();
		}
	}
	
	
	
	
}
