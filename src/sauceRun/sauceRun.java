package sauceRun;

import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class sauceRun {
	
	public static final String USERNAME = "prannoy1";
	public static final String ACCESS_KEY = "4b1bc36b-f5d5-43f4-867a-6624be2f452d";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	
	@DataProvider(name = "dp", parallel = true)
	public Object[][] data(){
		return new Object[][]{
			{"MicrosoftEdge", "14.14393", Platform.WIN10},
			{"firefox", "49.0", Platform.WIN8_1},
	        {"internet explorer", "11.0", Platform.WIN8_1}
	       
		};
	}
	
	@Test(dataProvider = "dp")
	public void run(String browser, String version, Platform p) throws Exception{
		DesiredCapabilities c = new DesiredCapabilities(browser,version,p);
		
		WebDriver d = new RemoteWebDriver(new URL(URL),c);
		d.get("http://www.newtours.demoaut.com/");
		d.findElement(By.name("userName")).sendKeys("tutorial");
		d.findElement(By.name("password")).sendKeys("tutorial");
		d.findElement(By.name("login")).click();
		d.close();
		d.quit();
	}

}
