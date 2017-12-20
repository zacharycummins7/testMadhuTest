package WebElements;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Day5 {
	WebDriver driver;
	String baseUrl;

	
	@DataProvider (name = "test 1")
	public static Object[][] loginData() {
		return new Object[][] {{"mngr98691", "bYhudYg"}, {"Invalid", "bYhudYg"}, {"mngr98691", "Invalid"}, {"Invalid", "Invalid"}};
	}
	
	
  @Test (dataProvider = "test 1")
  public void login(String userId, String passCode) {
	  try {
//		  
		// Opens Guru99 bank page
			  driver.get(baseUrl);
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			
				
		// Finds username field  	
				 WebElement userName = driver.findElement(By.name("uid"));
				 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				 
		// Sends string from excel sheet to username field
				 	userName.sendKeys(userId);
				 	System.out.println("Username " + userId + " entered");
				 	
		// Finds password field		  
					  WebElement passWord = driver.findElement(By.name("password"));
					  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					  
		// Sends string from excel sheet to password field
					  	passWord.sendKeys(passCode);
					  	System.out.println("Password " + passCode + " entered");
					  	
		// Finds and clicks "Submit" button			  	
					  	driver.findElement(By.name("btnLogin")).click();
			
		// If alert present, accepts alert and prints out message
		  
			if (isAlertPresent() == true) {
				
				driver.switchTo().alert().accept();
				System.out.println("Login failed! Try Again!");
				System.out.println("");
			} 
		// If alert not present, prints out message
			else  {
				System.out.println("Login Successful!");
				String mangerHeading = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")).getText();
				mangerHeading.contains("Manger Id : ");
				System.out.println("Manger Id :" + userId +  " is present on the page");
				System.out.println("");
		}
			
					  	
			

		  } catch (Exception e) {
		  
		    System.out.println(e.getMessage());}
		  
		   }
	  
		   
	
		// Method to determine if alert pop-up present
			public boolean isAlertPresent() {
			  
			  try {
				  driver.switchTo().alert();
				  return true;
			  }
			  catch (NoAlertPresentException Ex) {
				  return false;
			  }
			  
		  }
  @BeforeTest
  public void beforeTest() {
			 
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\automation\\Desktop\\JAVA\\chromedriver.exe");
			driver = new ChromeDriver();
			baseUrl = ("http://www.demo.guru99.com/V4/");
  }

  @AfterTest
  public void afterTest () throws InterruptedException {
	  driver.quit();  }
  		
}
