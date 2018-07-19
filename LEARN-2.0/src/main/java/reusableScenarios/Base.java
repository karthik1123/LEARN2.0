package reusableScenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import resources.Components;

public class Base {
	
	public static WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis= new FileInputStream("C:\\GitHubRepository\\.git\\SeleniumFrameWork\\src\\main\\java\\resources\\DataPool.properties");
		prop.load(fis);
		
		String Browser=prop.getProperty("browser");
		System.out.println(Browser);
		
		if (Browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			driver = new ChromeDriver(options);
		}
			else if (Browser.equals("Firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "c:/geckodriver/geckodriver.exe");
				driver = new FirefoxDriver();
			}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public WebDriver LoginAction() throws IOException
	{
		
		Properties prop = new Properties();
		FileInputStream fis= new FileInputStream("C:\\GitHubRepository\\.git\\SeleniumFrameWork\\src\\main\\java\\resources\\DataPool.properties");
		prop.load(fis);
		String URL=prop.getProperty("url");
		driver.get(URL);	
		driver.manage().window().maximize();
		
		Components Cmp= new Components(driver);
		//Cmp.LoginUsrId().sendKeys("karthik.agileqa@gmail.com");
		Cmp.LoginUsrId().sendKeys(prop.getProperty("usrnme"));
	    //Cmp.LoginPswd().sendKeys("plyboy@1123");
	    Cmp.LoginPswd().sendKeys(prop.getProperty("pswd"));
		Cmp.SubmitButton().click();	
		System.out.println(driver.getTitle());
		return driver;
	}
	public WebDriver LogoutAction() throws IOException
	{
		Components Cmp= new Components(driver);
		//Cmp.Settings().click();
		Cmp.LogoutButton().click();
		return driver;
	}

	public void getScreenshot(String result) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\GitHubRepository\\.git\\SeleniumFrameWork\\Results"+"screenshot.png"));
		
	}

}

