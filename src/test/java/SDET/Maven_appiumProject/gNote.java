package SDET.Maven_appiumProject;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class gNote {
	
	
	AppiumDriver<MobileElement> driver =null;
	
	@BeforeClass
	public void gNoteBefore() throws MalformedURLException {
		DesiredCapabilities dcap=new DesiredCapabilities();
		dcap.setCapability("deviceName", "Xiaomi Redmi Note 8 Pro");
		dcap.setCapability("platformName", "Android");
		dcap.setCapability("appPackage","com.google.android.keep");
		dcap.setCapability("appActivity",".activities.BrowseActivity");
		dcap.setCapability("noReset", true);
		
		//Instantiate Appium
		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, dcap);
		//WebDriverWait wait=new WebDriverWait(driver, 30);
	}
	@Test
	public void newNote() throws InterruptedException {
		
		
		driver.findElementById("com.google.android.keep:id/new_note_button").click();
		driver.findElementById("com.google.android.keep:id/editable_title").sendKeys("NoteTest");
		
		
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.id("com.google.android.keep:id/edit_note_text"))).sendKeys("Note desc test");
		
		driver.findElementByAccessibilityId("Navigate up").click();
		
		String actName=driver.findElementById("com.google.android.keep:id/index_note_title").getText();
		String actDesc=driver.findElementById("com.google.android.keep:id/index_note_text_description").getText();
		
		Assert.assertEquals("NoteTest", actName);
		Assert.assertEquals("Note desc test", actDesc);
		
		System.out.println("validation pass");
		
	}
	
	
 
}
