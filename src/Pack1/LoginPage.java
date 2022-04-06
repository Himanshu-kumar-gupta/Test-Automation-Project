package Pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public static void main(String[] args)
	{
		BaseTest.setUpBrowser();
		
		WebDriver driver = BaseTest.generateTest();
		
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a")).click();
		BaseTest.captureScreenshort(driver);
		
		WebElement email = driver.findElement(By.id("input-email"));
		email.sendKeys("test234789mail@gmail.com");
		BaseTest.captureScreenshort(driver);
		
		
		WebElement password = driver.findElement(By.id("input-password"));
		password.sendKeys("hog12rider!");
		BaseTest.captureScreenshort(driver);
		
		
		WebElement loginButton = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div[2]/div/div/form/p[1]/input"));
		loginButton.click();
		BaseTest.captureScreenshort(driver);
		
		BaseTest.tearDown(driver);
	}
}
