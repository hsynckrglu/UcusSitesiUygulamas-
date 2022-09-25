import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestive {

	// auto suggestion --> otomatik öneri

	/*
	 * burada sayfanın sol üst kısmında ülke arama yerine india yı seçmek istiyorum.
	 * bu alan bir şeyler yazmaya başlayınca ülkeleri sıralayan bir kısım indiayı
	 * seçmek istiyorum. "ind" yazdım fakat içinde ind geçen tüm ülkeler listelendi
	 * bu ülkeleri dizi-list olarak tanımladım daha sonra "india" ya eşit olan kısma
	 * tıkla yaptım. bunları ırasıyla for dönggüsü ve if le yaptım.
	 */
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\huseyin.cakiroglu\\Documents\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item']")); 
		//burada findelements yaptım çünkü üç tane vardı

		for (WebElement option : options) {

			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}

		}

	}

}
