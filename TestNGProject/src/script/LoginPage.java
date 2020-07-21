package script;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPage {
	
	public WebDriver driver;
	@Parameters("browser")
	@Test
	public void browserLaunch(String browserName) {
		System.out.println("Browser Name"+browserName);
		if(browserName.equalsIgnoreCase("chrome")) {
			String driverPath=System.getProperty("user.dir")+"\\src\\webdriver\\chromedriver.exe";
			System.out.println(driverPath);
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			String driverPath=System.getProperty("user.dir")+"\\src\\webdriver\\geckodriver.exe";
			System.out.println(driverPath);
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.MINUTES);
	}
	
	@Test (priority=1)
	public void Login() {
		System.out.println("Valid Username and Valid Password");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");;
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");;
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	}
	
	
}
