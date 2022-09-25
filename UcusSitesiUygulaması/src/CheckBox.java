import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckBox {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\huseyin.cakiroglu\\Documents\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected()); 
		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		
		/* java eğer assertTrue yazmasaydım expected [false] but found [true] hatası verecekti. Çıktı olarak true bekliyoruz 
		 * assertTrue ile test edersek sorunsuz şekilde testimiz devam edecektir.
		 * Kısacası false olan bir durumda true dersek teste devam etmez ama false bir duruma false dersek teste devam eder */
		
		
		
		//checkbox sayısını da .size() ile bulucam findElements olduğuna dikkat et birden fazla var
		
		System.out.println("Checkbox sayısı= "+driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		/*
		 * eğer ben 5 yetişkin yolcu 1 çocuk yolcu eklemek isteseydim yetişkin yolcu
		 * butonuna basmam gerkirdi 4 defa. yani aynı kodu en az 4 kere yazmak
		 * demekti.Çünkü sayfada 1 yetişkin seçili geliyor. doğru bir yaklaşım fakat bu
		 * görmeyi istediğimiz bir durum değil. döngüye-loops sokmak gerekir.
		 */

		System.out.println("Butonun seçim yapılmadan önceki yazısı: " + driver.findElement(By.id("divpaxinfo"))
				.getText()); /* butona herhangi bir seçim yapılmadan önceki yazı */
		
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText() , "1 Adult");

		int i = 1;
		while (i < 5) { // 4 kez döngüye girer.

			driver.findElement(By.id("hrefIncAdt")).click(); // +adult passenger
			i++;

		}
		

		for (int j = 1; j < 3; j++) {

			driver.findElement(By.id("hrefIncChd")).click(); // +child passenger 
		}
		

		driver.findElement(By.id("btnclosepaxoption")).click(); // done tuşuna basmak

		System.out.println("Butonun yolcular seçildikten sonraki yazısı= " + driver.findElement(By.id("divpaxinfo")).getText());
			 /* butonda yolcu seçimi yapıldıktan sonraki yazı */
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult, 2 Child");

		/* assertEquels(boolean actual, boolean excepted)  da actuale çıkan mesajı excepteda ise beklenilen mesajı yazıyoruz
		 * birbirine eşitse testten geçer. Eşit değilse test başarısız olur*/
	}
}
