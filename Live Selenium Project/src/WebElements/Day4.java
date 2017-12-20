package WebElements;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Day4 {
	WebDriver driver;
	String baseUrl;

  @Test
  public void login() {
	  try {
		   // Specify the path of file
		   File src = new File("C:\\Users\\automation\\Desktop\\JAVA\\TestData.xlsx");
		  
		    // load file
		    FileInputStream fis = new FileInputStream(src);
		  
		    // Load workbook
		    XSSFWorkbook wb = new XSSFWorkbook(fis);
		    
		    // Load sheet- Here we are loading first sheetonly
		       XSSFSheet sh1 = wb.getSheetAt(0);
		  

		  for (int row = 1; row < 5; row++) {
		// Opens Guru99 bank page
			  driver.get(baseUrl);
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				
		// Pulls username and password data from excel file and converts to String
				String userId = (sh1.getRow(row).getCell(0)).toString();
				String passCode = (sh1.getRow(row).getCell(1)).toString();
				
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
			
		// Closes workBook // Prevents resource leak
					  	wb.close();
		// If alert present, accepts alert and prints out message
		  
			if (isAlertPresent() == true) {
				
				driver.switchTo().alert().accept();
				System.out.println("Login failed! Try Again!");
				System.out.println("");
			} 
		// If alert not present, prints out message
			else  {
				System.out.println("Login Successful!");
				System.out.println("");
		}
			
					  	
			
		   }
		  } catch (Exception e) {
		  
		    System.out.println(e.getMessage());
		  
		   }
	  
		   
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
