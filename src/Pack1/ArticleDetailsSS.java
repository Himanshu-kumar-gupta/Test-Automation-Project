package Pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ArticleDetailsSS {
	public static void main(String[] args)
	{
		BaseTest.setUpBrowser();
		
		WebDriver driver = BaseTest.generateTest();
		
		WebElement searchBar = driver.findElement(By.id("input-search")); 
		searchBar.sendKeys("Arduino NANO");;
		BaseTest.captureScreenshort(driver);
		
		
		WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"search\"]/span/button/i"));
		searchButton.click();
		driver.findElement(By.partialLinkText("Arduino NANO V3.0 Development Board - Clone Compatible Model")).click();
		BaseTest.captureScreenshort(driver);
		
		
		//Product Name
		boolean productName_1 = driver.findElement(By.xpath("//*[@id=\"raa-div-prduct\"]/h1")).isEnabled();
		WebElement productName2 = driver.findElement(By.xpath("//*[@id=\"raa-div-prduct\"]/h1"));
		
		System.out.println("\nProduct Name displayed Status = " + productName_1 + 
						   "\n Product Name : " + productName2.getText());
		
		//Product Price
		boolean productPrice_1 = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div[2]/h1")).isDisplayed();
		WebElement productPrice_2 = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div[2]/h1"));
		
		System.out.println("\n Is Product Price displayed = " + productPrice_1 + 
				   		   "\n Product Price : " + productPrice_2.getText());
		
		//Product Image
		boolean productImage_1 = driver.findElement(By.id("main-img")).isDisplayed();
		System.out.println("\n Product Image displayed Status = " + productImage_1);
				
		//Product Ratings
		boolean productRatings_1 = driver.findElement(By.cssSelector("#raa-div-prduct > div.rating > p > a:nth-child(6)")).isDisplayed();
		WebElement productRatings_2 = driver.findElement(By.cssSelector("#raa-div-prduct > div.rating > p > a:nth-child(6)"));
		
		System.out.println("\n Product Ratings display status = " + productRatings_1 + 
						   "\n Product Ratings : " + productRatings_2.getText());
		
		//Product Quantity
		boolean productDelivery_1 = driver.findElement(By.id("input-quantity")).isDisplayed();
		WebElement productDelivery_2 = driver.findElement(By.id("input-quantity"));
		
		System.out.println("\n Product Delivery display status = " + productDelivery_1 + 
				           "\n Product Delivery : " + productDelivery_2.getText());
		
		//Product Availability
		boolean productAvailability_1 = driver.findElement(By.xpath("//*[@id=\"raa-div-prduct\"]/ul[1]/li[2]")).isDisplayed();
		WebElement productAvailability_2 = driver.findElement(By.xpath("//*[@id=\"raa-div-prduct\"]/ul[1]/li[2]"));
		
		System.out.println("\n Product Availability display status= " + productAvailability_1 + 
				           "\n Product Availability : " + productAvailability_2.getText());
		
		//Add To Cart and Buy Now
		boolean addToCartButton_1 = driver.findElement(By.id("button-cart")).isEnabled();
		boolean buyNowButton_1 = driver.findElement(By.id("button-buynow")).isEnabled();
		
		System.out.println("\n Is Add To Cart Button display status = " + addToCartButton_1 + 
		           		   "\n Is Buy Now Button display status = " + buyNowButton_1);
		
		BaseTest.captureScreenshort(driver);
		
		BaseTest.tearDown(driver);
	}
}
