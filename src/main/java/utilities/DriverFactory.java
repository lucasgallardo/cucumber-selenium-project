package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	public static WebDriver open(String browserType) {
		if(browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
			return new FirefoxDriver();
		}
		else {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
			return new ChromeDriver();
		}
	}
}
