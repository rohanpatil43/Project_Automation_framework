package Test_script;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base_page.Setup_application;
import Locator_Action.problem_user;
@Listeners(Base_page.Listeners_class.class)
public class Problem_User_Login extends Setup_application {

	
	
	problem_user problem;
	
	//Verify login with problem user
	@Test(priority=29)
	public void Login_fun()throws InterruptedException
	{
		problem=new problem_user(driver);
		problem.Login_with_problemuser("standard_user", "secret_sauce");
	}
	
}
