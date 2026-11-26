package Test_script;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base_page.Setup_application;
import Locator_Action.Login_page;
@Listeners(Base_page.Listeners_class.class)
public class Login  extends Setup_application  {

	Login_page page;

	//Login with valid user name and password
	//Login with invalid username  and password
	//Login with invalid user name 
	//Login with invalid password
	//Login with balnk field 
	//Login with Only user name field blank
	//Login with only password field blank
	//verify password type in masked
	
	@Test
	public void Login_Functionality() throws InterruptedException
	{
		 page=new Login_page(driver);
		
		page.Login_Functionality("standard_user", "secret_sauce");
		
	}

	
}

