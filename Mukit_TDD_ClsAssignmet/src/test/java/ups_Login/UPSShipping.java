package ups_Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UPSShipping {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "‪C:\\Users\\moh\\Desktop\\chromedriver.exe");

		driver.get("https://www.ups.com/lasso/shipping");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		
		WebElement cookiesRemove = driver.findElement(By.xpath("//*[@id=\"__tealiumImplicitmodal\"]/div/button/span[1]"));
		cookiesRemove.click();
		WebElement clickShipNow=driver.findElement(By.id("ups-banner-ctatxtid0"));
		clickShipNow.click();
		String title=driver.getTitle();
		System.out.println(title);
		//WebElement clickShipFrom=driver.findElement(By.name("icon ups-icon-wedgedown"));
		//clickShipFrom.click();
		
		//WebElement clickON=driver.findElement(By.className("ng-tns-c0-0"));
		//clickON.click();
		
		
		Select clickCountry=new Select(driver.findElement(By.xpath("//*[@id=\"origin-cac_country\"]")));
		clickCountry.selectByIndex(2);
		
		WebElement setName=driver.findElement(By.xpath("//*[@id=\"origin-cac_companyOrName\"]"));
		setName.sendKeys(" Moh Mukit");
		
		WebElement setContName=driver.findElement(By.xpath("//*[@id=\"origin-cac_contactName\"]"));
		setContName.sendKeys("Farhan");
		
		WebElement addressSet=driver.findElement(By.xpath("//*[@id=\"origin-cac_addressLine1\"]"));
		addressSet.sendKeys("123 knmox place");
		
		WebElement postalCode=driver.findElement(By.id("origin-cac_postalCode"));
		postalCode.sendKeys("11276");
		
		WebElement setTown=driver.findElement(By.xpath("//*[@id=\"origin-cac_city\"]"));
		setTown.sendKeys(" Bronx");
		driver.quit();
		
	}

}
