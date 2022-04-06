package Pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegisterAnnotate {

	WebDriver driver;
	
	@BeforeTest
	public void beforeRegister()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Test auto\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.electronicscomp.com/");	
	}
	
	@Test
	public void register1()
	{
		 //for registration
        WebElement signin = driver.findElement(By.linkText("Login"));
        signin.click();
        WebElement reg = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div[1]/div/p[3]/a"));
        reg.click();
        WebElement fname = driver.findElement(By.id("input-firstname"));
        fname.sendKeys("Himanshu");
        WebElement lname = driver.findElement(By.id("input-lastname"));
        lname.sendKeys("gupta");
        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("test234789mail@gmail.com");
        WebElement mobno = driver.findElement(By.id("input-telephone"));
        mobno.sendKeys("6393617864");
        WebElement pwd = driver.findElement(By.id("input-password"));
        pwd.sendKeys("hog12rider!");
        WebElement rpwd = driver.findElement(By.id("input-confirm"));
        rpwd.sendKeys("hog12rider!");
        WebElement cbox = driver.findElement(By.xpath("/html/body/div[5]/div/div/form/div/div/input[1]"));
        cbox.click();
        WebElement confirm = driver.findElement(By.xpath("/html/body/div[5]/div/div/form/div/div/input[2]"));
        confirm.click();
	}
	
	
	@AfterTest
	public void afterLogin()
	{
		driver.close();
	}
}
