package Pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotate {

	WebDriver driver;
	
	@BeforeTest
	public void beforeLogin()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Test auto\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.electronicscomp.com/");	
	}
	
	@Test
	public void login1()
	{
		//code for login on electronicscomp.com
		 driver.findElement(By.partialLinkText("Login")).click();
		 WebElement email = driver.findElement(By.id("input-email"));
	     email.sendKeys("test234789mail@gmail.com");
         WebElement password = driver.findElement(By.id("input-password"));
         password.sendKeys("hog12rider!");
         WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"form-login\"]/p[1]/input"));
         signInButton.click();
	}

	
	@AfterTest
	public void afterLogin()
	{
		driver.close();
	}

}


