package SeleniumPractice;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultipleWindows {
	
	@Test
	public void testmultipleWindows() throws InterruptedException{
		
		System.setProperty("webdriver.gecko.driver", "G:\\Neon\\gecko driver\\geckodriver.exe");
		
		WebDriver objDriver = new FirefoxDriver();
		objDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		objDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		objDriver.manage().window().maximize();
		objDriver.get("file:///C:/Users/krunal/Desktop/Selenium%20webpages/HandlingMultipleWindows.html");
		objDriver.findElement(By.xpath("//input[@id='btnConfirm']")).click();
		String strParentWindow = objDriver.getWindowHandle();
		Set<String> allWindow = objDriver.getWindowHandles();
		
		for(String strChild : allWindow){
			
			if(!strParentWindow.equalsIgnoreCase(strChild)){
				
				objDriver.switchTo().window(strChild);
				objDriver.manage().window().maximize();
				objDriver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("krunal");
				objDriver.close();
			}
		}
		
		objDriver.switchTo().window(strParentWindow);
		
		objDriver.close();
		
	}

}
