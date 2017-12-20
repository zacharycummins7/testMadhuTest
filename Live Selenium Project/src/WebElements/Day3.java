package WebElements;



import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;




public class Day3 {

	  WebDriver driver;
	  String baseUrl;
	  
	  @Before
	  public void beforeTest() throws InterruptedException {
		 
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\automation\\Desktop\\JAVA\\chromedriver.exe");
			driver = new ChromeDriver();
			baseUrl = ("http://www.demo.guru99.com/V4/");
			
			
		
			
	  }

	
@Test
	public void loginLoop() {
	
				   
				   try {
				   // Specify the path of file
				   File src=new File("C:\\Users\\automation\\Desktop\\JAVA\\TestData.xlsx");
				  
				    // load file
				    FileInputStream fis=new FileInputStream(src);
				  
				    // Load workbook
				    XSSFWorkbook wb=new XSSFWorkbook(fis);
				    
				    // Load sheet- Here we are loading first sheetonly
				       XSSFSheet sh1= wb.getSheetAt(0);
				  

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
							  	
				// Closes workbook // Prevents resource leak
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
				   }catch (Exception e) {
				  
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

				  @After
				  public  void tearDown() throws InterruptedException {
				  driver.quit();
				 }
}
		  