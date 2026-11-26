package Locator_Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class problem_user {

	 WebDriver driver;
	
	public problem_user(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	 By User=By.id("user-name");
	 By Pass=By.id("password");
	By Login=By.id("login-button");
	By error=By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
	
	By bag=By.cssSelector("//img[alt='Sauce Labs Backpack']");
	
	public void Login_with_problemuser(String patil ,String rohan) throws InterruptedException
	{
		//valid user name
		driver.findElement(User).sendKeys(patil);
		driver.findElement(Pass).sendKeys(rohan);
		driver.findElement(Login).click();
		String acpect=driver.getCurrentUrl();
		String except="https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(acpect, except);
		System.out.print("User login successfull");
		Thread.sleep(1000);
		
		driver.navigate().back();
		//invalid user name
		driver.findElement(User).sendKeys("rohan");
		driver.findElement(Pass).sendKeys("patil");
		driver.findElement(Login).click();
		WebElement errormassage=driver.findElement(error);
		System.out.println(errormassage.getText());
		Thread.sleep(1000);
		driver.navigate().refresh();
		
		//invalid password
		driver.findElement(User).sendKeys("problem_user");
		driver.findElement(Pass).sendKeys("33332");
		driver.findElement(Login).click();
		WebElement errorma=driver.findElement(error);
		System.out.println(errorma.getText());
		
		driver.navigate().refresh();
		
		driver.findElement(Login).click();
		WebElement e=driver.findElement(error);
		System.out.println(e.getText());
		
		Thread.sleep(1000);
		
		//masked fromat
		driver.findElement(Pass).sendKeys("secret_sauce");
		WebElement a=driver.findElement(Pass);
		
		String fieldtype=a.getDomAttribute("type");
		Assert.assertEquals(fieldtype,"password" ,"password is in maskedFromat");
		System.out.println("Config Password is in MasekedFromt");

	}
	public void Verify_product(String a ,String b)
	{
		driver.findElement(User).sendKeys(a);
		driver.findElement(Pass).sendKeys(b);
		driver.findElement(Login).click();
		driver.findElement(bag).click();
	}
	
}
