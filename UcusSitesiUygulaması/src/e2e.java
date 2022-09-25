import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class e2e {
	//eğer ilerde gelip kodu çalıştırmaya kalkarsam ve çalışmazsa büyük ihtimalle tanımlanan tarih geçtiği için classı bulunmaz hata verir
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\huseyin.cakiroglu\\Documents\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']"))
		.click();
		
		driver.findElement(By.xpath("(//a[@class='ui-state-default'][normalize-space()='29'])[1]")).click();
		
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("dönüş tarihi butonu kapalı");
			Assert.assertTrue(true);
		}
		else {
			System.out.println("Dönüş tarihi butonu açık");
			Assert.assertTrue(false);
			
		}
		Thread.sleep(2000);
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
		for(int i=1;i<5;i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		
		int j=1;
		while(j<3) {
			driver.findElement(By.id("hrefIncChd")).click();
			j++;
		}
		
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByValue("USD");
		Thread.sleep(2000);
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
		
		
	}

}
