package utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class time_wait {

	WebDriver driver;
	WebDriverWait wait;
	
	public time_wait(WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(driver ,Duration.ofSeconds(7));
	}
	
	//Wait for element vasilibity
	public  WebElement WaitForVivibility(By loctor)
	{
		By locator = null;
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	//Wait for element clickable
	public WebElement WaitForClickable(By locator)
	{
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	//wait for presence element
	public  WebElement tWaitForPresence(By locator)
	{
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
}

