package SeleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class PopUp {
	
	
	@Test
	public void handlePopUp()
	{
		
		System.setProperty("webdriver.gecko.driver", "G:\\Neon\\gecko driver\\geckodriver.exe");
		WebDriver objDriver = new FirefoxDriver();
		objDriver.manage().window().maximize();
		objDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		objDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		objDriver.get("file:///C:/Users/krunal/Desktop/Selenium%20webpages/HTMLTag.html");
		JavascriptExecutor js = (JavascriptExecutor)objDriver;
		js.executeScript("document.getElementById('txtUserName').value = 'krunal'");
		
	}
}
