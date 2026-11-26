package Locator_Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class Check_out_Field {

	WebDriver driver;
	
	public Check_out_Field(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By Username=By.id("user-name");
	 By Password=By.id("password");
	By Loginbtn=By.id("login-button");
	
	By Bagpack=By.cssSelector("#add-to-cart-sauce-labs-backpack");
	By verify_productadd=By.cssSelector(".inventory_item_name");

	By Bikelight=By.cssSelector("#add-to-cart-sauce-labs-bike-light");
	//add to cart button
	By Add_cartbtn=By.xpath("//a[@class='shopping_cart_link']");

	By Checkout=By.id("checkout");
	
	//from
	//fistname
	By Fname=By.xpath("//input[@placeholder='First Name']");
	By Lname=By.xpath("//input[@placeholder='Last Name']");
	By PIN=By.cssSelector("input[placeholder='Zip/Postal Code']");
	
	By contbtn=By.id("continue");
	
	//product quantity
	By product_quantity=By.cssSelector(".cart_quantity");
	//product price
	By product_price=By.cssSelector(".inventory_item_price");
	//product total caculation
	By total_calculation=By.cssSelector(".summary_total_label");
	
	By finish=By.id("finish");
	
	By cancel=By.cssSelector("#cancel");
	
	By verifycheckout=By.className("title");
	
	By error_massage=By.xpath("//h3[@role='alert']");
	
	public void verify_checkout_page(String uname ,String pass) throws InterruptedException
	{
		driver.findElement(Username).sendKeys(uname);
		driver.findElement(Password).sendKeys(pass);
		driver.findElement(Loginbtn).click();
		
		Thread.sleep(1000);
		driver.findElement(Bagpack).click();
		Thread.sleep(1000);
		driver.findElement(Add_cartbtn).click();
		
		Thread.sleep(3000);
		driver.findElement(Checkout).click();
		Thread.sleep(1000);
		System.out.println("CheckOut page is open successfull");
	}
	
	public void Add_deatils_inField(String username ,String Pass, String NAME ,String Lastname ,String PINcode) throws InterruptedException
	{
		driver.findElement(Username).sendKeys(username);
		driver.findElement(Password).sendKeys(Pass);
		driver.findElement(Loginbtn).click();
		
		Thread.sleep(1000);
		driver.findElement(Bikelight).click();
		Thread.sleep(1000);
		driver.findElement(Add_cartbtn).click();
		
		Thread.sleep(3000);
		driver.findElement(Checkout).click();
		Thread.sleep(1000);
		
		driver.findElement(Fname).sendKeys(NAME);
		driver.findElement(Lname).sendKeys(Lastname);
		driver.findElement(PIN).sendKeys(PINcode);
		
		Thread.sleep(1000);
		driver.findElement(contbtn).click();
		Thread.sleep(2000);
		
		String actual=driver.findElement(product_quantity).getText();
		String e="1";
		Assert.assertEquals(actual, e);
		System.out.println("prodct quantity is match ");
		Thread.sleep(1000);
		String act=driver.findElement(product_price).getText();
		String ex="$9.99";
		Assert.assertEquals(act, ex);
		System.out.println("price same as produt price");
		
		String total=driver.findElement(total_calculation).getText();
		String avalible="Total: $10.79";
		Assert.assertEquals(total, avalible);
		System.out.println("Total Calculation is match as tax and product price");
		
		driver.findElement(finish).click();
		Thread.sleep(1000);
		
		String Actual=driver.findElement(By.className("complete-header")).getText();
		String except="Thank you for your order!";
		Assert.assertEquals(Actual, except);
		System.out.println("Product checkout successfull");
		
		driver.navigate().back();
		driver.findElement(cancel).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
		System.out.println("Cancel button verify successfull");
		
	}
	
	public void Verify_Checout_Datafill(String USER ,String PASS ) throws InterruptedException
	{
		SoftAssert soft=new SoftAssert();
		driver.findElement(Username).sendKeys(USER);
		driver.findElement(Password).sendKeys(PASS);
		driver.findElement(Loginbtn).click();
		
		Thread.sleep(1000);
		driver.findElement(Bikelight).click();
		Thread.sleep(1000);
		driver.findElement(Add_cartbtn).click();
		
		Thread.sleep(3000);
		driver.findElement(Checkout).click();
		Thread.sleep(1000);
		
		driver.findElement(contbtn).click();
		System.out.println(driver.findElement(error_massage).getText());
		
		driver.navigate().refresh();
		driver.findElement(Lname).sendKeys("Patil");
		driver.findElement(PIN).sendKeys("4335");
		Thread.sleep(1000);
		driver.findElement(contbtn).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(error_massage).getText());
		
		driver.navigate().refresh();
		driver.findElement(Fname).sendKeys("Rohan");
		driver.findElement(PIN).sendKeys("3333");
		Thread.sleep(1000);
		driver.findElement(contbtn).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(error_massage).getText());
		
		driver.navigate().refresh();
		driver.findElement(Fname).sendKeys("Rohan");
		driver.findElement(Lname).sendKeys("Patil");
		Thread.sleep(1000);
		driver.findElement(contbtn).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(error_massage).getText());
		
		driver.navigate().refresh();
		
		driver.findElement(Fname).sendKeys("@@@@@");
		driver.findElement(Lname).sendKeys("@@@@@");
		driver.findElement(PIN).sendKeys("@@@@@");
		Thread.sleep(1000);
		 Thread.sleep(1000);
		    WebElement checkoutbtn=driver.findElement(By.name("continue"));
		    boolean checkbtn=checkoutbtn.isEnabled();
		    Assert.assertFalse(checkbtn ,"After enter only spical character continue button is visible");
		   

		driver.navigate().refresh();
		

	}
	public void Only_number_Checkoutbox(String U,String P ) throws InterruptedException
	{
	
		driver.findElement(Username).sendKeys(U);
		driver.findElement(Password).sendKeys(P);
		driver.findElement(Loginbtn).click();
		
		Thread.sleep(1000);
		driver.findElement(Bikelight).click();
		Thread.sleep(1000);
		driver.findElement(Add_cartbtn).click();
		
		Thread.sleep(3000);
		driver.findElement(Checkout).click();
		Thread.sleep(1000);
		
	    driver.findElement(Fname).sendKeys("11111");
	    driver.findElement(Lname).sendKeys("11111");
	    driver.findElement(PIN).sendKeys("11111");
	    WebElement btn=driver.findElement(By.name("continue"));
	    boolean validation=btn.isEnabled();
	    Assert.assertFalse(validation ,"continue button is clickable after entering only number in filed");
	 
	}
	
	public void Without_Add_Any_Product(String userss ,String PA) throws InterruptedException
	{
		driver.findElement(Username).sendKeys(userss);
		driver.findElement(Password).sendKeys(PA);
		driver.findElement(Loginbtn).click();
		Thread.sleep(1000);
		driver.findElement(Add_cartbtn).click();
		Thread.sleep(1000);
		driver.findElement(Checkout).click();

		driver.findElement(Fname).sendKeys("rohan");
	    driver.findElement(Lname).sendKeys("patil");
	    driver.findElement(PIN).sendKeys("11111");
	    driver.findElement(contbtn).click();
	  
	    WebElement Finbtn=driver.findElement(By.name("finish"));
	    boolean Finishbutton=Finbtn.isEnabled();
	    Assert.assertFalse(Finishbutton ,"After without add any product product checkout successfull");
	}
	
}
