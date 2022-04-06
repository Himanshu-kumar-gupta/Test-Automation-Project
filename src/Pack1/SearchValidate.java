package Pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchValidate {

		public static void main(String args[])
		{
	        System.setProperty("webdriver.chrome.driver", "E:\\Test auto\\chromedriver_win32\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.electronicscomp.com/");
	        
	        WebElement searchBar = driver.findElement(By.id("input-search")); 
			searchBar.sendKeys("Arduino NANO");
			
			WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"search\"]/span/button/i"));
			searchButton.click();
			
			driver.findElement(By.partialLinkText("Arduino NANO V3.0 Development Board - Clone Compatible Model")).click();
	        
			WebElement artcleTitle = driver.findElement(By.xpath("//*[@id=\"raa-div-prduct\"]/h1"));
			
			System.out.println(artcleTitle.getText());
			
			System.out.println("outpdscv :   "+artcleTitle.getText().contains("Arduino NANO V3.0"));
			
			//validating diff fields
			
			WebElement addtocartslot = driver.findElement(By.id("button-cart"));
			boolean r1 = addtocartslot.isEnabled();
			System.out.println("Add to cart button is enabled : "+r1);
			
			WebElement buynowslot = driver.findElement(By.id("button-buynow"));
			boolean r2 = buynowslot.isEnabled();
			System.out.println("Buy now button is enabled : "+r2);
			
			WebElement pricealertslot = driver.findElement(By.xpath("//*[@id=\"product\"]/div/button[2]"));
			boolean r3 =pricealertslot.isEnabled();
			System.out.println("Price alert button is enabled : "+r3);
			
			WebElement quantityslot = driver.findElement(By.id("input-quantity"));
			boolean r4 =quantityslot.isEnabled();
			System.out.println("Quantity button is enabled : "+r4);
			
			WebElement addtowhishlist = driver.findElement(By.xpath("//*[@id=\"raa-div-prduct\"]/div[1]/button[1]/i"));
			boolean r5 = addtowhishlist.isEnabled();
			System.out.println("Add to Wishlist button is enabled : "+r5);
			
			
			WebElement compare_product =  driver.findElement(By.xpath("//*[@id=\"raa-div-prduct\"]/div[1]/button[2]/i"));
			boolean r6 = compare_product.isEnabled();
			System.out.println("Compare product button is enabled : "+r6);
			
			
			WebElement wishlistslot = driver.findElement(By.xpath("//*[@id=\"wishlist-total\"]/span"));
			boolean r7 = wishlistslot.isEnabled();
			System.out.println("Wishlist button is enabled : "+r7);
			
			
			WebElement reviews = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/ul[2]/li[3]/a"));
			boolean r8 = reviews.isEnabled();
			System.out.println("Reviews button is enabled : "+r8);
			
			driver.quit();
	        
		}
}
