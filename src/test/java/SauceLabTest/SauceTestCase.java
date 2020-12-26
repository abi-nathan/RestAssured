package SauceLabTest;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SauceTestCase {
		public WebDriver driver = null;
		
		public static final String USERNAME = "abicnathan";
		public static final String ACCESS_KEY = "17a4c060-692e-4098-b217-d658d7154ef2";
		public static final String URL = "https://"+USERNAME +":"+ACCESS_KEY + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";
		
		@BeforeClass
		@Parameters({"browser","version","platform"})
		
		/*void startUp(String br,String vr,String pf) throws MalformedURLException 
		  {
			if (br.equalsIgnoreCase("chrome")) 
			 { 
				 DesiredCapabilities caps=new DesiredCapabilities() ;
					caps.setCapability("browserName",br );
					caps.setCapability("version", vr);
					caps.setCapability("platform", pf);
					driver=new RemoteWebDriver(new java.net.URL(URL), caps);
			 }
			 else if(br.equalsIgnoreCase("firefox"))
			 {
				 DesiredCapabilities caps=new DesiredCapabilities() ;
					caps.setCapability("browserName",br );
					caps.setCapability("version", vr);
					caps.setCapability("platform", pf);
					driver=new RemoteWebDriver(new java.net.URL(URL), caps); 
			 }*/
		
		    public void setup( @Optional("Firefox")String br,@Optional("45.0")String vr,@Optional("Linux")String pf) throws MalformedURLException {
			DesiredCapabilities caps=new DesiredCapabilities() ;
			caps.setCapability("browserName",br );
			caps.setCapability("version", vr);
			caps.setCapability("platform", pf);
			driver=new RemoteWebDriver(new java.net.URL(URL), caps);
		}
		
		@Test
		public void verifyLogin()
		{
			driver.get("https://opensource-demo.orangehrmlive.com/");
			Assert.assertEquals(driver.getTitle(), "OrangeHRM");
			
			driver.findElement(By.id("txtUsername")).sendKeys("Admin");
			driver.findElement(By.id("txtPassword")).sendKeys("admin123");
			driver.findElement(By.id("btnLogin")).click();
			
			Assert.assertEquals(driver.getTitle(), "OrangeHRM");
			
		}
		
		
		
		@AfterClass
		public void tearDown() 
		{
			System.out.println("Now tearing down the url");
			driver.quit();
		}

	}



