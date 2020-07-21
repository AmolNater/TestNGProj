package script;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrgHRM {
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
	public void pageProp(){
		driver.findElement(By.xpath("//input[@id='txtUsername']")).clear();
		driver.findElement(By.xpath("//input[@id='txtPassword']")).clear();
		
	}
	
	@Test(priority=0)
	public void TestCase3(){

		System.out.println("Valid Username and Valid Password");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");;
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");;
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	}
	
	@Test(priority=1)
	public void TestCase2(){
		System.out.println("Valid Username and InValid Password");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");;
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Admin123");;
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	}
	
	@Test(priority=2)
	public void TestCase5(){
		System.out.println("InValid Username and Valid Password");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("admin");;
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");;
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	}
	
	@Test(priority=3)
	public void TestCase4(){
		System.out.println("Invalid Username and Invalid Password");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("admin");;
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Admin123");;
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	}
	
	@Test(priority=4)
	public void TestCase6(){
		System.out.println("Blank Username and Blank Password Fields");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("");;
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("");;
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	}
	
	@AfterMethod
	public void Logout(){
		String currentURL=driver.getCurrentUrl();
		System.out.println(currentURL);
		String actualURL="https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		if(currentURL.equals(actualURL)) {
			driver.findElement(By.xpath("//a[@id='welcome']")).click();
			driver.findElement(By.linkText("Logout")).click();
		}
	}
	
	@AfterClass
	public void driverClose(){
		driver.close();
	}
/*	
	@AfterTest
	public void AfterTestAnn(){
		
	}
	
	@AfterSuite
	public void AfterSuiteAnn(){
		
	}
*/	
}
