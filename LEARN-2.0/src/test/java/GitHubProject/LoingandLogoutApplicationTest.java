package GitHubProject;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import reusableScenarios.Base;
//import reusableScenarios.LoginFunction;
//import reusableScenarios.LogoutFunction;
import reusableScenarios.closeApplication;

//@Listeners(CustomListener.class)

public class LoingandLogoutApplicationTest extends Base{

	public static Logger log =LogManager.getLogger(Base.class.getName());
	//InvokeBrowser Login = new InvokeBrowser();
		
	@Test(priority=1)
	public void OpenApplication() throws IOException
	{
		
	initializeDriver();
	log.info("Driver is initialized");
	LoginAction();
	log.info("User Login to Rediff account");
		
	}	
	
	@Test(priority=2)
	public void LogoutApplication() throws IOException
	{
	LogoutAction();
	log.info("User is Logout of Rediff account");
	closeApplication CloseApp= new closeApplication();
	CloseApp.Closebrowser();
	log.info("Application and Browser is closed");
	
	}
}

