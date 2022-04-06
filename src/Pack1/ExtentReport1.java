package Pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport1 {
	
	static ExtentTest test;
	static ExtentReports report;

	String baseurl = "https://www.electronicscomp.com/";
	String driverpath = "E:\\\\Test auto\\\\chromedriver_win32\\\\chromedriver.exe";
	WebDriver driver;

	@BeforeClass
	public static void initializeReport()
	{
		report = new ExtentReports("E:\\Test auto\\Extent\\Output\\ExtentReportResults.html");
		test = report.startTest("ExtentDemo");
	}

	@BeforeTest
	public void launchingBrowser()
	{
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseurl);
	}

	@Test(priority=0)
	public void containsText()
	{		
	    WebElement searchBar = driver.findElement(By.id("input-search")); 
		searchBar.sendKeys("Arduino NANO");
		
		WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"search\"]/span/button/i"));
		searchButton.click();
		
		driver.findElement(By.partialLinkText("Arduino NANO V3.0 Development Board - Clone Compatible Model")).click();
        
		WebElement artcleTitle = driver.findElement(By.xpath("//*[@id=\"raa-div-prduct\"]/h1"));
			
		if(artcleTitle.getText().contains("Arduino NANO V3.0"))
		{
			test.log(LogStatus.PASS, "The title contains the required text");
		}	
		else
		{
			test.log(LogStatus.FAIL, "The title does not contain the required text");
		}
	}
	
	@Test(priority=1)
	public void cartButton()
	{
		WebElement addtocartslot = driver.findElement(By.id("button-cart"));
		if(addtocartslot.isEnabled())
		{
			test.log(LogStatus.PASS, "Add to cart button is enabled");
		}	
		else
		{
			test.log(LogStatus.FAIL, "Add to cart button is not enabled");
		}
	}
	
	@Test(priority=2)
	public void buyN()
	{
		WebElement buynowslot = driver.findElement(By.id("button-buynow"));

		if(buynowslot.isEnabled())
		{
			test.log(LogStatus.PASS, "Buy now button is enabled");
		}	
		else
		{
			test.log(LogStatus.FAIL, "Buy now button is not enabled");
		}
	}

	@Test(priority=3)
	public void enterYourLoginName()
	{
		WebElement pricealertslot = driver.findElement(By.xpath("//*[@id=\"product\"]/div/button[2]"));

		if(pricealertslot.isEnabled())
		{
			test.log(LogStatus.PASS, "Price alert button is enabled");
		}	
		else
		{
			test.log(LogStatus.FAIL, "Price alert button is not enabled");
		}
	}

	@Test(priority=4)
	public void quanButtton()
	{
		WebElement quantityslot = driver.findElement(By.id("input-quantity"));
		
		if(quantityslot.isEnabled())
		{
			test.log(LogStatus.PASS, "Quantity button is enabled");
		}		
		else
		{
			test.log(LogStatus.FAIL, "Quantity button is not enabled");
		}
	}

	@AfterTest
	public void destroyingSession()
	{
		driver.close();
		test.log(LogStatus.PASS, "Browser Closed Successfully");
	}
	
	@AfterClass
	public void publishingReport() 
	{
		report.endTest(test);
		report.flush();
	}
}
