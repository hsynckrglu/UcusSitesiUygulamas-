import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdateDropdown {
	//eğer ilerde gelip kodu çalıştırmaya kalkarsam ve çalışmazsa büyük ihtimalle tanımlanan tarih geçtiği için classı bulunmaz hata verir
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\huseyin.cakiroglu\\Documents\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		System.out.println("checkbox tıklamadan önce= "+driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		
		System.out.println("checkbox tıkladıktan sonra= "+driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected()); 
		/* checkbox ın seçilip seçilmediğini kontrol eder
		 * eğer seçilmemişse checkbox false döner, seçilmişse true döner*/
		
		
		
		
		System.out.println("gidiş-dönüşe basmadan önce= "+driver.findElement(By.id("Div1")).getAttribute("style"));
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();		
		
		System.out.println("gidiş-dönüşe bastıktan sonra= "+driver.findElement(By.id("Div1")).getAttribute("style"));
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			System.out.println("Takvimin dönüş tarihi butonu etkin");
			Assert.assertTrue(true);
		}
		else{
		Assert.assertTrue(false);	
		}
		
		
		
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

	
	}

}
