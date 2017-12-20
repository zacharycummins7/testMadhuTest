package WebElements;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Day1 {
	 WebDriver driver;
	 String baseUrl;
	  @Parameters("browser")
	  @BeforeTest
	  public void beforeTest(String browser) {
		 if(browser.equalsIgnoreCase("chrome")) {
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\automation\\Desktop\\JAVA\\chromedriver.exe");
			driver = new ChromeDriver();
		 }else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.driver", "C:\\Users\\automation\\Desktop\\JAVA\\geckodriver.exe"); 
			driver = new FirefoxDriver();
		 }
			baseUrl = ("http://www.demo.guru99.com/V4/");
			driver.get(baseUrl);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
	  }

	
  @Test
  public void managerLogin() {
	  // Find username field and enter username into field
	 WebElement userName = driver.findElement(By.name("uid"));
	 	userName.sendKeys("mngr98691");
	 // Find password field and enter password into field
	  WebElement passWord = driver.findElement(By.name("password"));
	  	passWord.sendKeys("bYhudYg");
	 // Click Login button 
	    driver.findElement(By.name("btnLogin")).click();
	  Assert.assertEquals("Guru99 Bank Manager HomePage", driver.getTitle());
	  //ANOTHER WAY TO DO IT
	  // String actualValue = "Guru99 Bank Manager HomePage"
	  // actualValue = driver.getTitle();
  }
  
 


@AfterTest
  public void afterTest() throws InterruptedException {
	  
	Thread.sleep(5000);
	  driver.quit();
  }




}











//<test name = "FirefoxTest" >
//
//<parmeter name = "browser" value = "firefox"/>
//
//<classes>
//
//<class name = "practiceExercises.multipleBrowsers" />
//
//</classes>
//
//</test>
