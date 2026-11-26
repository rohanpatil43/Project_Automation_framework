package Test_script;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base_page.Setup_application;
import Locator_Action.Check_out_Field;
@Listeners(Base_page.Listeners_class.class)
public class Check_out_functionality extends Setup_application{

	
	Check_out_Field checkout;
	

	//To check wether Checkout functionality page is open or not
	@Test(priority=23)
	public void Open_Check_out_informationpage() throws InterruptedException
	{
		checkout=new Check_out_Field(driver);
		checkout.verify_checkout_page("standard_user", "secret_sauce");
	}
	
	//To verify Add information in Check out Field 
	@Test(priority=24)
	public void Check_out_with_filldata() throws InterruptedException
	{
		checkout=new Check_out_Field(driver);
		checkout.Add_deatils_inField("standard_user", "secret_sauce","ROhan" ,"PAtil" ,"3456");

	}
	
	//To verify Check out field with blank data and only spical character
	@Test(priority=25)
	public void Check_out_withblank_field() throws InterruptedException
	{
		checkout=new Check_out_Field(driver);
		checkout.Verify_Checout_Datafill("standard_user", "secret_sauce");
	
	}
	
	//verify check out field with fill only 
	@Test(priority=26)
	public void only_number() throws InterruptedException
	{
		checkout=new Check_out_Field(driver);
		checkout.Only_number_Checkoutbox("standard_user", "secret_sauce");

	}
	//Verify without add any product check out is succusseful or not
	@Test(priority=28)
	public void Without_ptoduct_select() throws InterruptedException
	{
		checkout=new Check_out_Field(driver);
		checkout.Without_Add_Any_Product("standard_user", "secret_sauce");

	}
}
