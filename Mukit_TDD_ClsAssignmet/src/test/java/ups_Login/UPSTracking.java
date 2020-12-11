package ups_Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UPSTracking {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "‪C:\\Users\\moh\\Desktop\\chromedriver.exe");

		driver.get("https://www.ups.com/lasso/tracking");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());

		WebElement cookiesRemove = driver.findElement(By.xpath("//*[@id=\"__tealiumImplicitmodal\"]/div/button/span[1]"));
		cookiesRemove.click();
		
		WebElement clickTracking=driver.findElement(By.linkText("Tracking"));
		clickTracking.click();
		WebElement clickTPackage =driver.findElement(By.linkText("Track a Package"));
		clickTPackage.click();
		WebElement setTackNum=driver.findElement(By.xpath("//*[@id=\"stApp_trackingNumber\"]"));
		setTackNum.sendKeys("274878478478757575");
		
		WebElement clickTrack=driver.findElement(By.id("stApp_btnTrack"));
		clickTrack.click();
		
		/*UPS could not locate the shipment details for this tracking number. 
		Details are only available for shipments made within 
		the last 120 days. Please verify your information*/
		
		WebElement getText=driver.findElement(By.id("stApp_error_alert_list0"));
		System.out.println(getText.getText());
		
		
		
		//driver.quit();
	}

}
