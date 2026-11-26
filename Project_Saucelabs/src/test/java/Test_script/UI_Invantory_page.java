package Test_script;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base_page.Setup_application;
import Locator_Action.Inventory_page;
@Listeners(Base_page.Listeners_class.class)
public class UI_Invantory_page extends Setup_application{


	Inventory_page verify;
	
	//Verify Product page UI visible
	@Test(priority=10)
	public void loginverify()
{
		verify=new Inventory_page(driver);
		
		verify.Verify_inventroy_page("standard_user", "secret_sauce");
		
	}
	
	//Verify product tittle Is match to product image
	@Test(priority=11)
	public void vefrify_product_name()
	{
		verify=new Inventory_page(driver);
		
		verify.verify_product_Display("standard_user", "secret_sauce");
	}

	//verify product discrpition is visible or not
    @Test(priority=12)
     public void verify_product_decription() throws InterruptedException
    {
		verify=new Inventory_page(driver);
		verify.Product_Discription("standard_user", "secret_sauce");
	}
	
	//verify product image is visible
	@Test(priority=13)
	public void img_varifaction()
	{
		verify=new Inventory_page(driver);
		verify.Verify_product_onimg("standard_user" ,"secret_sauce");
	}
	
	//verify product tittle is visible
	@Test(priority=14)
	public void title_verifaction() throws InterruptedException
	{
		verify=new Inventory_page(driver);
		verify.click_product_name("standard_user", "secret_sauce");
	}
	
	//verify product add to cart or not
	@Test(priority=15)
	public void Add_Cart()
	{
		verify=new Inventory_page(driver);
		verify.Add_Tocart_button("standard_user", "secret_sauce");
	}
	
	//verify product range shorting with AZ 
	@Test(priority=16)
	public void Sorting_AZ() throws InterruptedException
	{
		verify=new Inventory_page(driver);
		verify.Sorting_product("standard_user", "secret_sauce");

	}
	
	//verify all menu section in navbar
   @Test(priority=17)
	public void All_menu_section() throws InterruptedException, IOException
	{
		verify=new Inventory_page(driver);
		verify.ALL_Navbar_menu("standard_user", "secret_sauce");
	}
}
