package script;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
public static WebDriver driver;
	
	@BeforeSuite
	public void Launch(){
		String driverPath=System.getProperty("user.dir")+"\\src\\webdriver\\chromedriver.exe";
		System.out.println(driverPath);
		System.setProperty("webdriver.chrome.driver",driverPath);
		driver=new ChromeDriver();
	}
	
	@BeforeTest
	public void driverProp(){
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@BeforeClass
	public void scriptWait(){
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.MINUTES);
	}
	
	@BeforeMethod
	public static void pageProp(){
		WebElement usrMail=driver.findElement(By.xpath("//input[@id='txtUsername']"));
		WebElement usrPass=driver.findElement(By.xpath("//input[@id='txtPassword']"));
		usrMail.clear();
		usrPass.clear();
		
	}
	
	
	
	@Test(priority=0)
	public void TestCase3(){
		
		System.out.println("Valid Username and Valid Password");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");;
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");;
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		driver.findElement(By.linkText("Logout")).click();
		String currentURL=driver.getCurrentUrl();
		System.out.println(currentURL);
	}
	

	@AfterClass
	public void driverClose(){
		driver.close();
	}}
