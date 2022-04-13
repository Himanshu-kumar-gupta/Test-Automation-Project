package Pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

	public class JenkinsAuto {
	  @Test
	  public void f() {
		  System.setProperty("webdriver.chrome.driver", "E:\\\\\\\\Test auto\\\\\\\\chromedriver_win32\\\\\\\\chromedriver.exe");
	      WebDriver driver = new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.get("https://www.electronicscomp.com");
	      
	      //for login
	      WebElement loginbut = driver.findElement(By.linkText("Login"));
	      loginbut.click();
	      
	      WebElement email = driver.findElement(By.xpath("//*[@id=\"input-email\"]"));
	      email.sendKeys("test234789mail@gmail.com");
	      
	      WebElement password = driver.findElement(By.xpath("//*[@id=\"input-password\"]"));
	      password.sendKeys("hog12rider!");
	      
	      WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"form-login\"]/p[1]/input"));
	      signInButton.click();     
	      
	      driver.quit();
	      
	      System.out.println("Log-in sucessfull !");
	  }
	
}
