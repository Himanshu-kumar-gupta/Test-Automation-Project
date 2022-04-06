package Pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login1 {

	public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "E:\\Test auto\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.electronicscomp.com/");
        
       
        //for login
        //driver.findElement(By.id("nav-signin-tooltip")).click();
        //driver.findElement(By.className("fa fa-sign-in")).click();
        driver.findElement(By.partialLinkText("Login")).click();
        //driver.findElement(By.className("raapopup-btn--btn raapopup-btn--close")).click();
        
        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("test234789mail@gmail.com");
//        WebElement continueButton = driver.findElement(By.id("continue"));
//        continueButton.click();
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("hog12rider!");
        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"form-login\"]/p[1]/input"));
        signInButton.click();
        
       // driver.findElement(By.className("raapopup-btn--btn raapopup-btn--close")).click();
    }

}

