package Locator_Action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import utility.ScreenShot;

public class Login_page {

	WebDriver driver;
	ScreenShot sr;
	 By Username=By.id("user-name");
	 By Password=By.id("password");
	By Loginbtn=By.id("login-button");
	By errormassage=By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
	By crossbutton=By.cssSelector(".error-button");
	
	By menubtn=By.xpath("//button[@id='react-burger-menu-btn']");

	By Logoutbtn=By.xpath("//a[@id='logout_sidebar_link']");
	//inalization of driver
	public Login_page(EdgeDriver driver)
	{
		this.driver=driver;
	}
		
	public void Login_Functionality(String userName ,String pass) throws InterruptedException
	{
		driver.findElement(Username).sendKeys(userName);
		driver.findElement(Password).sendKeys(pass);
		driver.findElement(Loginbtn).click();
		System.out.println("Login with valid user name");
		try
		{
		Thread.sleep(3000);
		driver.findElement(menubtn).click();
		WebElement btn=driver.findElement(Logoutbtn);
		JavascriptExecutor JS=(JavascriptExecutor)driver;
		JS.executeScript("arguments[0].click();", btn);
		Thread.sleep(1000);
		btn.click();
		}
		catch(Exception e)
		{
			
		}

		//Verify with invalid user name and Invalid password
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		driver.findElement(Username).sendKeys("rohan");
		driver.findElement(Password).sendKeys("Patil");
		driver.findElement(Loginbtn).click();
		WebElement error=driver.findElement(errormassage);
		System.out.println(error.getText());
		
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		//Test case for Invalid username 
		driver.findElement(Username).sendKeys("Adity");
		driver.findElement(Password).sendKeys("secret_sauce");
		driver.findElement(Loginbtn).click();
		WebElement e=driver.findElement(errormassage);
		System.out.println(e.getText());
		
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		//only password is invalid and check login or not
		driver.findElement(Username).sendKeys("standard_user");
		driver.findElement(Password).sendKeys("123");
		driver.findElement(Loginbtn).click();
		WebElement E=driver.findElement(errormassage);
		System.out.println(E.getText());
	
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		//User name and pssword field is blank and check login or not
		driver.findElement(Loginbtn).click();
		WebElement ER=driver.findElement(errormassage);
		System.out.println(ER.getText());

		Thread.sleep(2000);
		driver.navigate().back();
		//only Username field is balnk and check login or not
		driver.findElement(Password).sendKeys("secret_sauce");
		driver.findElement(Loginbtn).click();
		WebElement Error=driver.findElement(errormassage);
		System.out.println(Error.getText());

	
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		//only password field is blank and check login or not
		driver.findElement(Username).sendKeys("standard_user");
		driver.findElement(Loginbtn).click();
		WebElement Massage=driver.findElement(errormassage);
		System.out.println(Massage.getText());

		
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		//verify the password fromat is masked or not
		driver.findElement(Password).sendKeys("secret_sauce");
		WebElement actual=driver.findElement(Password);
		
		String fieldtype=actual.getDomAttribute("type");
		Assert.assertEquals(fieldtype,"password" ,"password is in maskedFromat");
		System.out.println("Config Passwrd is in MasekedFromt");
		
	
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		//verify After clicking on error massage cross button this is clse or not
		driver.findElement(Username).sendKeys("secret_sauce");
		driver.findElement(Password).sendKeys("y6566");
		driver.findElement(Loginbtn).click();
		WebElement cross=driver.findElement(crossbutton);
		Actions act=new Actions(driver);
		act.moveToElement(cross).click().perform();
		System.out.println("Error massage is successfully close with cross button");
	
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		//Verify Login with Locked_username 
		driver.findElement(Username).sendKeys("locked_out_user");
		driver.findElement(Password).sendKeys("secret_sauce");
		driver.findElement(Loginbtn).click();		
		WebElement M=driver.findElement(errormassage);
		System.out.println(M.getText());
		Assert.fail();
		Thread.sleep(1000);

	}
	
	
	

	

		
}
