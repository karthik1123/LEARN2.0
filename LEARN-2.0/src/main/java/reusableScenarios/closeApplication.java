package reusableScenarios;

import java.io.IOException;

public class closeApplication extends Base{
	
	public void Closebrowser() throws IOException
	{
	
		driver.close();
		driver.quit();
	}
}