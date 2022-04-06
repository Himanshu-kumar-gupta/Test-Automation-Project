package Pack1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import com.mongodb.MapReduceCommand.OutputType;

public class BaseTest {
	static WebDriver driver;
	static String driverPath;
	static String baseURL;
	
	@BeforeTest
	public static void setUpBrowser()
	{
		  driverPath = "E:\\\\Test auto\\\\chromedriver_win32\\\\chromedriver.exe";
		  baseURL = "https://www.electronicscomp.com/";
	}
	
	@Test
	public static WebDriver generateTest()
	{
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(baseURL);
		captureScreenshort(driver);
		
		return driver;
	}
	
	public static void captureScreenshort(WebDriver ldriver)
	{
		String folderPath = "E:\\Test auto\\Project\\SS\\";
		
		File src = ((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);
		
		try
		{
			FileUtils.copyFile(src, new File(folderPath + System.currentTimeMillis() + ".png"));
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void implicitWait()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@SuppressWarnings("deprecation")
	public static void explicittWait()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	@AfterTest
	public static void tearDown(WebDriver driver)
	{
		driver.close();
	}
}
