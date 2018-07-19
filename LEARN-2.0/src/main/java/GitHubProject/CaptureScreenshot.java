package GitHubProject;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import reusableScenarios.InvokeBrowser;

public class CaptureScreenshot extends InvokeBrowser{
	
	public void FailedScreenshot()
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
		FileUtils.copyFile(scrFile, new File("C:\\GitHubRepository\\.git\\SeleniumFrameWork\\FailedTests\\screenshots"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
