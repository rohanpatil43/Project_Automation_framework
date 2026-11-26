package Locator_Action;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class Inventory_page {
	
	WebDriver driver;
	
	
	public Inventory_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
		
	@FindBy(id="user-name")
	WebElement Username;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(id="login-button")
	WebElement button;
	
	//product name
	@FindBy(xpath="//*[@id=\"item_4_title_link\"]/div")
	WebElement productname;
	
	@FindBy(xpath="//*[@id=\"item_0_title_link\"]/div")
	WebElement product2;
	
	@FindBy(xpath="//*[@id=\"item_1_title_link\"]/div")
	WebElement Product3;
	
	@FindBy(xpath="//*[@id=\"item_5_title_link\"]/div")
	WebElement Product4;
	
	@FindBy(xpath="//*[@id=\"item_2_title_link\"]/div")
	WebElement Product5;
	
	@FindBy(xpath="//*[@id=\"item_3_title_link\"]/div")
	WebElement Product6;
	
	//Product Discription
	@FindBy(xpath=("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[1]/div"))
	WebElement Discription_Fleecejacket;
	
	@FindBy(xpath="//*[@id=\"inventory_container\"]/div/div[2]/div[2]/div[1]/div")
	WebElement Labs_Backpack;
	
	@FindBy(xpath="//*[@id=\"inventory_container\"]/div/div[3]/div[2]/div[1]/div")
	WebElement Bolt_TShirt;
	
	@FindBy(xpath="//*[@id=\"inventory_container\"]/div/div[4]/div[2]/div[1]/div")
	WebElement T_Shirt_Red;
	
	@FindBy(xpath="//*[@id=\"inventory_container\"]/div/div[5]/div[2]/div[1]/div")
	WebElement  Bike_Light;
	
	@FindBy(xpath="//*[@id=\"inventory_container\"]/div/div[6]/div[2]/div[1]/div")
	WebElement Labs_Onesie;
	
	@FindBy(xpath="//*[@id=\"item_4_img_link\"]/img")
	WebElement bag_img;
	@FindBy(xpath="//*[@id=\"inventory_item_container\"]/div/div/div[1]/img")
	WebElement Bag_imageafterclick;
	
	@FindBy(xpath="//div[text()='Sauce Labs Backpack']")
	WebElement Bag_Title;
	
	@FindBy(xpath="//div[text()='Sauce Labs Bike Light']")
	WebElement LightTitile;
	
	@FindBy(xpath="//*[@id=\"item_1_title_link\"]/div")
	WebElement Tshirt;
	
	@FindBy(xpath="//div[text()='Sauce Labs Fleece Jacket']")
	WebElement jacket;
	
	@FindBy(xpath="//div[text()='Sauce Labs Onesie']")
	WebElement Labstshit;
	
	@FindBy(xpath="//div[text()='Test.allTheThings() T-Shirt (Red)']")
	WebElement WhiteT;
	
	@FindBy(xpath="//button[text()='Add to cart']")
	WebElement Add_cartButton;
	
	@FindBy(className="product_sort_container")
	WebElement sorting_button;
	
	@FindBy(xpath="//option[text()='Name (A to Z']")
	WebElement AZ_sorting;
		
	@FindBy(xpath=("//option[text()='Name (Z to A)'"))
	WebElement ZA_sorting;
	
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")
	WebElement NavBar;
	
	@FindBy(xpath="//a[@id='dynamic_catalog_sidebar_link']")
	WebElement Dynamic_Catalog;
	
	@FindBy(xpath="//a[@id='dynamic_catalog_lazy_load_link']")
	WebElement Lazy_load_link;
	
	@FindBy(xpath="//a[@id='dynamic_catalog_spinner_link']")
	WebElement Catlog_spinner;
		
	@FindBy(id="about_sidebar_link")
	WebElement About_Section;
	
	@FindBy(id="reset_sidebar_link")
	WebElement RestApp_state;
	
	public void Verify_inventroy_page(String username ,String pass)
	{
		Username.sendKeys(username);
		Password.sendKeys(pass);
		button.click();
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html" ,"you are on wrong page");
		System.out.println("Inventory page is visible succsessfull");
	}
	
	public void verify_product_Display(String username2 ,String pass2)
	{
		Username.sendKeys(username2);
		Password.sendKeys(pass2);
		button.click();
		
		boolean product_name=productname.isDisplayed();
		Assert.assertTrue(product_name ,"product name is not match");
		WebElement bag_t=driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
		System.out.println(bag_t.getText());
		
		boolean product=product2.isDisplayed();
		Assert.assertTrue(product,"Product title and actual product is diffrent");
		WebElement light=driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']")); 
		System.out.println(light.getText());
		
		boolean product3=Product3.isDisplayed();
		Assert.assertTrue(product,"Product title and actual product is diffrent");
		WebElement tshirt=driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")); 
		System.out.println(tshirt.getText());

		
		boolean product4=Product4.isDisplayed();
		Assert.assertTrue(product ,"Product title and actual product is diffrent");
		WebElement jacket=driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']")); 
		System.out.println(jacket.getText());

		
		boolean product5=Product5.isDisplayed();
		Assert.assertTrue(product ,"Product title and actual product is diffrent");
		WebElement Labs_Shirt=driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']")); 
		System.out.println(Labs_Shirt.getText());

		
		boolean product6=Product6.isDisplayed();
		Assert.assertTrue(product ,"Product title and actual product is diffrent");
		WebElement Red_t=driver.findElement(By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']")); 
		System.out.println(Red_t.getText());

		System.out.println("All Product is Displayed Successfull");
	}
	
	public void Product_Discription(String UNAME,String PASS) throws InterruptedException
	{
		Username.sendKeys(UNAME);
		Password.sendKeys(PASS);
		button.click();
		boolean product1=Discription_Fleecejacket.isDisplayed();
		Assert.assertTrue(product1,"Discription_Fleecejacket Discripition not match");
	//	WebElement BAG_Dis=driver.findElement(By.xpath("//div[text()='carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.']"));
		System.out.println("It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.");
		
		boolean product2=Labs_Backpack.isDisplayed();
		Assert.assertTrue(product1,"Bag Discripition not match");
	//	WebElement Bike_l=driver.findElement(By.xpath("//div[text()='carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.']"));
		System.out.println("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");

		boolean product3=Bolt_TShirt.isDisplayed();
		Assert.assertTrue(product1," Bolt_TShirt not match");
		//WebElement Black_t=driver.findElement(By.xpath("//div[text()='Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.']"));
		System.out.println("Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.");


		boolean product4=T_Shirt_Red.isDisplayed();
		Assert.assertTrue(product1,"T_Shirt_Red Discripition not match");
		System.out.println("This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.");

		boolean product5=Bike_Light.isDisplayed();
		Assert.assertTrue(product1," Bike_Light Discripition not match");
		//WebElement White_T=driver.findElement(By.xpath("//div[text()='Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.']"));
		System.out.println("Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel");


		boolean product6=Labs_Onesie.isDisplayed();
		Assert.assertTrue(product1,"Labs_Onesie Discripition not match");
		//WebElement red_T=driver.findElement(By.xpath("//div[text()='This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.']"));
		System.out.println("This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.");

		System.out.println("All Prodcut Discrpition is Matched ");

	}
	
	public void Verify_product_onimg(String name ,String password)
	{
		
		Username.sendKeys(name);
		Password.sendKeys(password);
		button.click();
		
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		WebElement cick=wait.until(ExpectedConditions.elementToBeClickable(bag_img));
		bag_img.click();
		try {
		Thread.sleep(1000);
		}
		catch(Exception e) {
		}
	     WebElement Bag=Bag_imageafterclick;
	     boolean display=Bag.isDisplayed();
	     Assert.assertTrue(display);
	     System.out.println("Selected product(Bag) Image match successfull");
		
	     driver.navigate().back();
	     	     
	}
	
	public void click_product_name(String NAME ,String Pass) throws InterruptedException
	{
		SoftAssert soft=new SoftAssert();
		Username.sendKeys(NAME);
		Password.sendKeys(Pass);
		button.click();
		Thread.sleep(1000);
		Bag_Title.click();
		Thread.sleep(1000);
		WebElement title=driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
		boolean bag=title.isDisplayed();
		Assert.assertTrue(bag ,"after clicking product not match");
		System.out.println("Bag title is match");
		
		driver.navigate().back();
		Thread.sleep(1000);
		LightTitile.click();
		Thread.sleep(1000);
		WebElement title2=driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]"));
		boolean light=title2.isDisplayed();
		Assert.assertTrue(light ,"Tittle is not this is wrong product");
		driver.navigate().back();
		System.out.println("Bike light title is match");
		
	
		Thread.sleep(1000);
		Tshirt.click();
		Thread.sleep(1000);
		WebElement title3=driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']"));
		boolean Tshirt=title3.isDisplayed();
		Assert.assertTrue(Tshirt ,"Tittle is not this is wrong product");
		driver.navigate().back();
		System.out.println("Tshit product Title is Match");
		
		Thread.sleep(1000);
		jacket.click();
		Thread.sleep(1000);
		WebElement title4=driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']"));
		boolean jacket=title4.isDisplayed();
		Assert.assertTrue( jacket,"Tittle is not this is wrong product");
		driver.navigate().back();
		System.out.println("jacket product Title is Match");
		
		Thread.sleep(1000);
		Labstshit.click();
		Thread.sleep(1000);
		WebElement title5=driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']"));
		boolean Labstshit=title5.isDisplayed();
		Assert.assertTrue(Labstshit ,"Tittle is not this is wrong product");
		driver.navigate().back();
		System.out.println("Labstshit product Title is Match");
		
		
		Thread.sleep(1000);
		WhiteT.click();
		Thread.sleep(1000);
		WebElement title6=driver.findElement(By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']"));
		boolean WhiteT=title6.isDisplayed();
		Assert.assertTrue(WhiteT ,"Tittle is not this is wrong product");
		driver.navigate().back();
		System.out.println("Labstshit product Title is Match");

	}
	
	public void Add_Tocart_button(String UN ,String PA)
	{
		Username.sendKeys(UN);
		Password.sendKeys(PA);
		button.click();
		
		boolean addtocart=Add_cartButton.isEnabled();
		Assert.assertTrue(addtocart,"Button is Disenabled");
		System.out.println("Add to cart button is Enabled");
	}
	
	public void Sorting_product(String Na ,String PASS) throws InterruptedException
	{
		Username.sendKeys(Na);
		Password.sendKeys(PASS);
		button.click();
		Thread.sleep(1000);
		

		sorting_button.click();
		Select sc=new Select(sorting_button);
		sc.selectByVisibleText("Name (A to Z)");
		Thread.sleep(5000);
		
		sorting_button.click();
		Select sc1=new Select(sorting_button);
		sc1.selectByVisibleText("Name (Z to A)");

		Thread.sleep(5000);
		sorting_button.click();
		Select sc3=new Select(sorting_button);
		sc3.selectByVisibleText("Price (high to low)");
		
		System.out.println("All sorting is successfull");
	}
	
	public void ALL_Navbar_menu(String N ,String P) throws InterruptedException, IOException
	{
		SoftAssert soft=new SoftAssert();
		Username.sendKeys(N);
		Password.sendKeys(P);
		button.click();
		Thread.sleep(1000);

		
		NavBar.click();
		Thread.sleep(1000);
		Dynamic_Catalog.click();
		Thread.sleep(1000);
		Lazy_load_link.click();
		Thread.sleep(5000);
		WebElement ss=driver.findElement(By.xpath("//div[@class='dynamic_catalog_lazy_load_container']"));
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ss.getScreenshotAs(OutputType.FILE);
		File Dis=new File("C:\\Users\\Rohan patil\\RohanAutomationTesting\\Project_Saucelabs\\screenshots\\dynamic.jpg");
		FileHandler.copy(source,Dis); 
		Thread.sleep(3000);
		//Validation is 
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,1000)");
		
				Thread.sleep(5000);
		System.out.println("Infinate product thre is bug");
		driver.navigate().back();
		
		Thread.sleep(4000);
		
		NavBar.click();
		Thread.sleep(1000);
		Dynamic_Catalog.click();
		About_Section.click();
		WebElement acutal=driver.findElement(By.xpath("//h1[@class='hero-heading']"));
		boolean expext=acutal.isDisplayed();
		Assert.assertTrue(expext);
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(2000);
		
		NavBar.click();
		Thread.sleep(1000);
		RestApp_state.click();
		Thread.sleep(1000);
		boolean Rest_app=RestApp_state.isEnabled();
		
		Assert.assertFalse(Rest_app, "RestApp button is Not clickable");
		System.out.println("RestApp button is Not clickable");
		
	}
	
	
		
	
	
		
	
}
