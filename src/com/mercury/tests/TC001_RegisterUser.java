package com.mercury.tests;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.mercury.pages.RegistrationPage;
import com.mercury.utils.ConfigReader;
import com.mercury.utils.ExcelConfig;

public class TC001_RegisterUser {
	
	ConfigReader objCR;
	WebDriver objDriver;
	ExcelConfig objeconfig;
	
	@BeforeMethod
	public void initialize()
	{
		System.setProperty("webdriver.gecko.driver", "G:\\Neon\\gecko driver\\geckodriver.exe");
		objDriver = new FirefoxDriver();
		objDriver.manage().window().maximize();
		objDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		objDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		objCR = new ConfigReader();
		}
	
	@Test(dataProvider="TestData",dataProviderClass=ExcelConfig.class)
	public void registeruser(String fname,String lname,String phn,String mail,String add1,String add2,String cit,
			String stat,String post,String count,String unam,String pas,String confirmpas){
			 
		objDriver.get(objCR.getApplicationURL());
		RegistrationPage objRpage = PageFactory.initElements(objDriver, RegistrationPage.class);
		objRpage.regiruser(fname,lname,phn,mail,add1,add2,cit,stat,post,count,unam,pas,confirmpas);
		Assert.assertEquals(objDriver.getTitle(), "Register: Mercury Tours");
		/*objeconfig = new ExcelConfig();
		try {
			objeconfig.writeData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
	}
	
	@AfterMethod
	public void closebrowser()
	{

		objDriver.close();
	}
	
}
