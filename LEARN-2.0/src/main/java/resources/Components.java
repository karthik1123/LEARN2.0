package resources;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import reusableScenarios.InvokeBrowser;

public class Components extends InvokeBrowser{
	
	  By usrname = By.xpath("//*[@id='login1']");
	  By psw = By.xpath("//*[@id='password']");
	  By go = By.xpath("//input[@name='proceed']");
	  By logout = By.xpath("/html/body/div[4]/div[1]/div/div[2]/a[2]");
			  
	 
	public Components(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public WebElement LoginUsrId()
	{
		return driver.findElement(usrname);
	}
	public WebElement LoginPswd()
	{
		return driver.findElement(psw);
	}
	public WebElement SubmitButton()
	{
		return driver.findElement(go);
	}
	
	public WebElement LogoutButton()
	{
		return driver.findElement(logout);
	}
	
	
}
