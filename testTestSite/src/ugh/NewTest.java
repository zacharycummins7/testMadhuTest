package ugh;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NewTest extends Base {
  @Test
  public void verifypage() {
	 driver.get("http://www.madhutest.com");
	 driver.findElement(By.partialLinkText("go to quiz1.html")).click();
  }
}
