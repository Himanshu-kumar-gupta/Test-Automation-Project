package Pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDataProvider {

WebDriver driver;
	
	@BeforeTest
	public void beforeLogin()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Test auto\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.electronicscomp.com/");	
	}
	
	@DataProvider(name="loginDataTest")
	public static Object[][] loginData(){
		Object[][] data = new Object[4][4];
		
		data[0][0]= "anonymous4321goal@gmail.com";
		data[0][1]= "gOblin34*";
		data[0][2]= "chrome";
		data[0][3]= "13.3.1";
		
		data[1][0]= "qwerty@gmail.com";
		data[1][1]= "gOblin56*";
		data[1][2]= "firefox";
		data[1][3]= "97.0.1";
		
		data[2][0]= "hogrider@gmail.com";
		data[2][1]= "hog09";
		data[2][2]= "brave";
		data[2][3]= "12.6.8";
		
		data[3][0]= "test234789mail@gmail.com";
		data[3][1]= "hog12rider!";
		data[3][2]= "internet Explorer";
		data[3][3]= "5.0.9";
		
		return data;
		
	}
	
	@Test(dataProvider = "loginDataTest")
	public void login1(String email1,String password1,String browser,String browserVersion)
	{
		//code for login on electronicscomp.com
		 driver.findElement(By.partialLinkText("Login")).click();
		 WebElement email = driver.findElement(By.id("input-email"));
	     email.sendKeys(email1);
         WebElement password = driver.findElement(By.id("input-password"));
         password.sendKeys(password1);
         WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"form-login\"]/p[1]/input"));
         signInButton.click();
         
         System.out.println("\nBrowser = "+browser);
         System.out.println("Browser Version = "+browserVersion);
	}

	
	@AfterTest
	public void afterLogin()
	{
		driver.close();
	}

}
