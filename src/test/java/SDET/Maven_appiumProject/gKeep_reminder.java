package SDET.Maven_appiumProject;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class gKeep_reminder {
	
	
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
	public void newNote() throws MalformedURLException {
		
		
		driver.findElementById("com.google.android.keep:id/new_note_button").click();
		driver.findElementById("com.google.android.keep:id/editable_title").sendKeys("Reminder Test2");
		
		
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.id("com.google.android.keep:id/edit_note_text"))).sendKeys("Note reminder desc");
		
		//driver.findElementByAccessibilityId("Navigate up").click();
		
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.id("com.google.android.keep:id/menu_switch_to_grid_view"))).click();
		
		driver.findElementById("com.google.android.keep:id/date_spinner").click();
		
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		driver.findElementById("com.google.android.keep:id/reminder_date_tomorrow").click();
		
		driver.findElementById("com.google.android.keep:id/time_spinner").click();
		 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 driver.findElementById("com.google.android.keep:id/reminder_time_afternoon").click();
		 driver.findElementById("com.google.android.keep:id/save").click();
		 driver.findElementByAccessibilityId("Navigate up").click();
		 driver.findElementsByAccessibilityId("com.google.android.keep:id/reminder_chip_icon");
		 
		// driver.findElementById("com.google.android.keep:id/search").click();
		 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 driver.findElementById("com.google.android.keep:id/open_search_bar_text_view").click();
		 driver.findElementById("com.google.android.keep:id/open_search_view_edit_text").sendKeys("Reminder Test2");
		 
		 
		 String noteName = driver.findElementById("com.google.android.keep:id/index_note_title").getText();
		 System.out.println(noteName);
		 Assert.assertEquals("Reminder Test2", noteName);
		 
		 String rem_text=driver.findElementById("com.google.android.keep:id/reminder_chip_text").getText();
		 System.out.println(rem_text);
		 Assert.assertEquals("Tomorrow, 1:00 PM", rem_text);
		
	}
	
}
