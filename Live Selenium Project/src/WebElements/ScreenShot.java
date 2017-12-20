package WebElements;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class ScreenShot {
	WebDriver driver;
	  String baseUrl;
  @Test
  public void screenShot() {

	  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  // Now you can do whatever you need to do with it, for example copy somewhere
	  try {
		FileUtils.copyFile(scrFile, new File("C:\\Users\\automation\\Desktop\\JAVA\\ScreenShots\\testscreenshot.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\automation\\Desktop\\JAVA\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = ("http://www.google.com/");
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
