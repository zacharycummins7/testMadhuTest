package WebElements;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Day2 {
	 WebDriver driver;
	 String baseUrl;
	  
	  @BeforeTest
	  public void beforeTest() {
		
		  System.setProperty("webdriver.chrome.driver", WebElements.Util.CHROME_PATH);
			driver = new ChromeDriver();
			baseUrl = (WebElements.Util.BASE_URL);
			driver.get(baseUrl);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
	  }

	
  @Test
  public  void managerLogin() throws InterruptedException {
	  // Find username field and enter username into field
	 WebElement userName = driver.findElement(By.name("uid"));
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 	userName.sendKeys(WebElements.Util.USER_NAME);
	 	
	 // Find password field and enter password into field
	  WebElement passWord = driver.findElement(By.name("password"));
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  	passWord.sendKeys(WebElements.Util.PASSWD);
	 	
	 // Click Login button 
	    driver.findElement(By.name("btnLogin")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 	
	  //ANOTHER WAY TO DO IT
	    Assert.assertEquals(WebElements.Util.EXPECT_TITLE, driver.getTitle());
	  System.out.println("Login Successful");
//	    String actualTitle = driver.getTitle();
//	    if(actualTitle == driver.getTitle()) {
//	    	System.out.println("Login Successful");
//	    	
//	    }
//	    else {
//	    	System.out.println("Login Unsuccessful");
//	    }
  }


@AfterTest
  public void afterTest() {
	
	  driver.quit();
  }




}
