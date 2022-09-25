import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NeredenNereyeButonları {
	//eğer ilerde gelip kodu çalıştırmaya kalkarsam ve çalışmazsa büyük ihtimalle tanımlanan tarih geçtiği için classı bulunmaz hata verir
	public static void main(String[] args) throws InterruptedException {

		/*
		 * Burada tanımladığım //a[@value='MAA'])[2] xpath olan yol indis ve parantez
		 * içinde kullanmamın sebebi aslında iki tane açılır buton var bu butonlardan
		 * birisi nereden gideceksin diğeri ise nereye gideceksin. çalışma mantığı da bu
		 * sitedeki butonun ise şu şekilde nereden butonunundan gideceğin yeri
		 * seçeceksin seçmeden nereye butonuna tıklarssan boş görürsün hiç bir değer
		 * gelmez.Ondan dolayı nereden kısmına ben bir şehir seçtiğimde ( örneğin,
		 * "//a[@value='BLR']" ) o yoldan 1 tane buluyor herhangi bir sorun yok süper.
		 * Ama nereye kısmına gelince aynı şehirler nereden kısmında olduğu için
		 * yazdığım yol (Örneğin, //a[@value='MAA'] ) iki değer buluyor. Çünkü iki
		 * tarafta da bu şehir var. E ne yapıcam? Selectorhub yada Chropath da yolu
		 * yazınca yolu parantez içine alıyorum ve köşeli parantez içinde kaçıncı indis
		 * olduğunu yazıyorum[2] ( örneğin, "(//a[@value='MAA'])[2]") bu şekilde) . Ha
		 * diyeceksinki neden id ya da class gibi tek o butona özgü şeyleri yapmıyosun?
		 * tanımlanırken elements de yok bunlar mecbur value ile tanımlıyorum.
		 */

		/*
		 * çoğu müşteriler index kullanmasına karşı oldukları için şu şekilde
		 * parents-child ilişkisi altında yazdım. Önce açılan butonu yazdım sonra da
		 * şehrin yolunu yazdım şehri xpath seçtim ama tablo id sin css selectors
		 * seçtiydim bulmadı neden bilmiyorum. kısacası yorum satırlarının altındaki
		 * yolla aşağısındaki kod aynı yol demek.
		 */

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\huseyin.cakiroglu\\Documents\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();

		//driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//a[@value='BLR']")).click();
				

		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']"))
				.click();
		// driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		
		
		/*  .ui-state-default.ui-state-highlight --> bu yolla classı belirdim syntaxı = .class 
		 * class adında boşluk varsa aralarındaki boşlukları . ile dolduruyorum. 
		 * class="ui-state-default ui-state-highlight" --> .ui-state-default.ui-state-highlight */
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		
		 
		
		
		

	}

}
