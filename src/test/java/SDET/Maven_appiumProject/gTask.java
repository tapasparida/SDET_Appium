package SDET.Maven_appiumProject;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class gTask {
    AppiumDriver<MobileElement> driver = null;
    //WebDriverWait wait;
    
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Xiaomi Redmi Note 8 Pro");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        WebDriverWait wait=new WebDriverWait(driver, 10);
         
    }

    @Test
    public void newTask() throws InterruptedException {
    	String  taskN[]= {"Complete the second Activity Google Keep","Complete Activity with Google Keep","Complete Activity with Google Tasks"};
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
    	driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete Activity with Google Tasks");
    	driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
    	
    	driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
    	driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete Activity with Google Keep");
    	driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
    	
    	driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
    	driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete the second Activity Google Keep");
    	driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
    	
    	List<MobileElement> task=driver.findElementsById("com.google.android.apps.tasks:id/task_name");
    	int taskSize=task.size();
    	
    	for (int i=0;i < taskSize; i++) {
    		String x=task.get(i).getText();
    		System.out.println(x);
    		
    		assertTrue(x.equals("Complete the second Activity Google Keep") || x.equals("Complete Activity with Google Keep") || x.equals("Complete Activity with Google Tasks"));
    	 
    	}
    	
    }
       
        
     

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }
}