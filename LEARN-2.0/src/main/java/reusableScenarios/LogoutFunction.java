package reusableScenarios;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import resources.Components;

public class LogoutFunction extends Base{

	public WebDriver LogoutAction() throws IOException
	{
		Components Cmp= new Components(driver);
		//Cmp.Settings().click();
		Cmp.LogoutButton().click();
		return driver;
	}
}
