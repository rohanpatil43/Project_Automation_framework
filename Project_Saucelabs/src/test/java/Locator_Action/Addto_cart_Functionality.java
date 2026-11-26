package Locator_Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Addto_cart_Functionality {

	WebDriver driver;
	
	public Addto_cart_Functionality(WebDriver driver)
	{
		this.driver=driver;
	}
	 By Username=By.id("user-name");
	 By Password=By.id("password");
	By Loginbtn=By.id("login-button");
	
	By Bagpack=By.cssSelector("#add-to-cart-sauce-labs-backpack");
	By verify_productadd=By.cssSelector(".inventory_item_name");
	
	//add to cart button
	By Add_cartbtn=By.xpath("//a[@class='shopping_cart_link']");
	
	//multiple product
	By Bikelight=By.cssSelector("#add-to-cart-sauce-labs-bike-light");
	By verify_bike=By.xpath("//div[text()='Sauce Labs Bike Light']");
	
	By Black_Tshirt=By.cssSelector("#add-to-cart-sauce-labs-bolt-t-shirt");
	By verify_tshirt=By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']");
	
	By  onesie_shirt=By.cssSelector("#add-to-cart-sauce-labs-onesie");
	By   Verify_product=By.xpath("//div[text()='Sauce Labs Onesie']");
	
	By removebutton=By.id("remove-sauce-labs-backpack");
	
	By continue_shoping=By.cssSelector("#continue-shopping");
	
	public void Add_singleproduct(String name ,String password) throws InterruptedException
	{
		driver.findElement(Username).sendKeys(name);
		driver.findElement(Password).sendKeys(password);
		driver.findElement(Loginbtn).click();
		Thread.sleep(1000);
		driver.findElement(Bagpack).click();
		Thread.sleep(1000);
		driver.findElement(Add_cartbtn).click();
		
		Thread.sleep(1000);
		WebElement  result=driver.findElement(verify_productadd);
		boolean verify=result.isDisplayed();
		Assert.assertTrue(verify ,"Adding product is successfull");
		System.out.println("Single product added successfull");
		driver.navigate().back();
	}
	
	public void add_multiple_product(String UserName ,String p) throws InterruptedException
	{
		driver.findElement(Username).sendKeys(UserName);
		driver.findElement(Password).sendKeys(p);
		driver.findElement(Loginbtn).click();
		Thread.sleep(1000);
		driver.findElement(Black_Tshirt).click();
		Thread.sleep(1000);
		driver.findElement(Bikelight).click();
		Thread.sleep(1000);
		driver.findElement(Add_cartbtn).click();
		Thread.sleep(1000);
		WebElement visibleproduct=driver.findElement(verify_bike);
		boolean light=visibleproduct.isDisplayed();
		Assert.assertTrue(light);;
		WebElement product2=driver.findElement(verify_tshirt);
		boolean tshirt=product2.isDisplayed();
		Assert.assertTrue(tshirt);
		System.out.println("multiple product is add successfull");
		driver.navigate().back();
	}
	
	public void cart_badge(String un ,String pa) throws InterruptedException
	{
		driver.findElement(Username).sendKeys(un);
		driver.findElement(Password).sendKeys(pa);
		driver.findElement(Loginbtn).click();
		Thread.sleep(1000);
		driver.findElement(Black_Tshirt).click();
		Thread.sleep(1000);
		String badgecountfrist=driver.findElement(By.className("shopping_cart_badge")).getText();
		Thread.sleep(1000);
		Assert.assertEquals(badgecountfrist, "1");
		System.out.println("Count is one display");
		
		driver.findElement(Bagpack).click();
		Thread.sleep(1000);
		String Secound=driver.findElement(By.className("shopping_cart_badge")).getText();
		Assert.assertEquals(Secound ,"2");
		System.out.println("After adding multiple product count is change");
		
		//add to cart button change in remove
		WebElement removebtn=driver.findElement(removebutton);
		Assert.assertTrue(removebtn.isDisplayed(), "After adding product remove button not visible");	

		
	}
	
	public void Product_Price_vefiy(String NAME ,String PASS) throws InterruptedException
	{
		driver.findElement(Username).sendKeys(NAME);
		driver.findElement(Password).sendKeys(PASS);
		driver.findElement(Loginbtn).click();
		Thread.sleep(1000);
		driver.findElement(Bagpack).click();
		Thread.sleep(1000);
		driver.findElement(Add_cartbtn).click();
		WebElement quantity_verify=driver.findElement(By.className("cart_quantity"));
		boolean expext=quantity_verify.isEnabled();
		Assert.assertTrue(expext );
		System.out.println("Product quality is stable not change");
		
		WebElement actual=driver.findElement(By.cssSelector(".inventory_item_price"));
		boolean except=actual.isDisplayed();
		Assert.assertTrue(except ,"Price is not match");
		System.out.println("Added product value is not change");
		
		//After add product remove button vivible ahe ka
		WebElement remove_btn=driver.findElement(removebutton);
		boolean btn=remove_btn.isEnabled();
		Assert.assertTrue(btn);
		System.out.println("After adding product remove button is visible");
	}
	
	public void Continue_shoping_btn(String rohan ,String patil) throws InterruptedException
	{
		driver.findElement(Username).sendKeys(rohan);
		driver.findElement(Password).sendKeys(patil);
		driver.findElement(Loginbtn).click();
		Thread.sleep(1000);
		
		driver.findElement(Bagpack).click();
		Thread.sleep(1000);
		driver.findElement(Add_cartbtn).click();
		Thread.sleep(1000);
		driver.findElement(continue_shoping).click();
		System.out.println("Button work uer is navigate to home page");
		Thread.sleep(1000);
		driver.findElement(Bikelight).click();
		Thread.sleep(1000);
		driver.findElement(Add_cartbtn).click();
		System.out.println("On navigate and new product");
		WebElement actual=driver.findElement(verify_bike);
		boolean expect=actual.isEnabled();
		Assert.assertTrue(expect,"Sauce Labs Bike Light");
		System.out.println("After navigate new product add successfull");
	//After continue remove button avalible
		WebElement acpect=driver.findElement(removebutton);
		boolean verify=acpect.isEnabled();
		Assert.assertTrue(verify);
		System.out.println("After click continue button remove button is avalible");
	}
	
	

	 
}
