package script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LogoutPage{
	public WebDriver driver;
	@Test (priority=2)
	public void Logout() {
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		driver.findElement(By.linkText("Logout")).click();
	}


}
