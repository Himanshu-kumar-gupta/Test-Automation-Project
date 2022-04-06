package Pack1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelReader {


		public static void main(String[] args) throws IOException {
			String username = "";
			String password = "";
			
			try {
				FileInputStream fis = new FileInputStream("E:\\Test auto\\Project\\Excel1\\TA_project.xlsx");
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				XSSFSheet sheet = wb.getSheet("Login");
				
				int rowCount = sheet.getLastRowNum();
				
				for(int i=1; i<=rowCount; i++ ) {
					XSSFRow row = sheet.getRow(i);
					if(row.getCell(0).getCellType()==CellType.NUMERIC)
						username = row.getCell(0).getRawValue();
					else
						username = row.getCell(0).toString();
					password =  row.getCell(1).getRawValue();
					login(username, password);
				}
				fis.close();
				wb.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}
		public static void login(String uname, String pwd) {
			System.out.println("Running TC with username "+uname+" password "+pwd);
			
			System.setProperty("webdriver.chrome.driver", "E:\\\\Test auto\\\\chromedriver_win32\\\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.electronicscomp.com/");
			
			driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a")).click();
			WebElement email = driver.findElement(By.id("input-email"));
			email.sendKeys(uname);
			
			WebElement password = driver.findElement(By.id("input-password"));
			password.sendKeys(pwd);
			
			WebElement signInButton = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div[2]/div/div/form/p[1]/input"));
			signInButton.click();
			driver.quit();
		}


	
}
