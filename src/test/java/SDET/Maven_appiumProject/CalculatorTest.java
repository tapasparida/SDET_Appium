package SDET.Maven_appiumProject;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculatorTest {
    AppiumDriver<MobileElement> driver = null;
    
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Xiaomi Redmi Note 8 Pro");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.miui.calculator");
        caps.setCapability("appActivity", ".cal.CalculatorActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
    }

    @Test
    public void multiply() {
    	driver.findElementById("btn_c_s").click();
        driver.findElementById("btn_7_s").click();
        driver.findElementById("btn_plus_s").click();
        driver.findElementById("btn_4_s").click();
        driver.findElementById("btn_equal_s").click();
        
        //Display Result
        String result = driver.findElementById("com.miui.calculator:id/result").getText();
        System.out.println(result);
        Assert.assertEquals(result, "= 11");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}