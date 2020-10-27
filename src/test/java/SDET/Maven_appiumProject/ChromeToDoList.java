package SDET.Maven_appiumProject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ChromeToDoList {
	
	    WebDriverWait wait;
	    AppiumDriver<MobileElement> driver = null;

	    @BeforeTest
	    public void setup() throws MalformedURLException {

	        // Set the Desired Capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	        //caps.setCapability("deviceName", "Xiaomi Redmi Note 8 Pro");
	        caps.setCapability("deviceName", "Pixel 3 API 29");
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("appPackage", "com.android.chrome");
	        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
	        caps.setCapability("noReset", true);
	        // Instantiate Appium Driver
	        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	        wait = new WebDriverWait(driver, 10);
	}
	    
	    @Test
	    public void toDoList() {
	    	
	    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	        driver.get("https://www.training-support.net/selenium");
	        MobileElement toDO=driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"To-Do List\").instance(0))"));
	        toDO.click();
	        System.out.println("To do clicked");
	      
	        
	    }
	    
}
