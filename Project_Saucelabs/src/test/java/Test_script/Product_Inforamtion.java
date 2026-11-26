package Test_script;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base_page.Setup_application;
import Locator_Action.Addto_cart_Functionality;
@Listeners(Base_page.Listeners_class.class)
public class Product_Inforamtion extends Setup_application{
 
	
	Addto_cart_Functionality product;
	
	//Add only single product  
	@Test(priority=18)
	public void single_product() throws InterruptedException
	{
		product=new Addto_cart_Functionality(driver);
		product.Add_singleproduct("standard_user" ,"secret_sauce");
	}
	
	//Add multiple product 
	@Test(priority=19)
	public void multiple_product_add() throws InterruptedException
	{
		product=new Addto_cart_Functionality(driver);
		product.add_multiple_product("standard_user" ,"secret_sauce");

		
	}
	
	//verify Badge count is change or not 
	@Test(priority=20)
	public void Badge_count() throws InterruptedException
	{
		product=new Addto_cart_Functionality(driver);
		product.cart_badge("standard_user" ,"secret_sauce");
		
	}
	
	//verify add product price is visible or not 
	@Test(priority=21)
	public void verify_price_add_product() throws InterruptedException 
	{
		product=new Addto_cart_Functionality(driver);
		product.Product_Price_vefiy("standard_user" ,"secret_sauce");
	}
	
	//Verify continue button 
	@Test(priority=22)
	public void Continue_shoping_button_field() throws InterruptedException
	{
		product=new Addto_cart_Functionality(driver);
		product.Continue_shoping_btn("standard_user" ,"secret_sauce");

	}
}
