package ups_Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UPSLogin {
	
	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "‪C:\\Users\\moh\\Desktop\\chromedriver.exe");

		driver.get("https://wwwapps.ups.com/doapp/signup");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());

		WebElement cookiesRemove = driver.findElement(By.xpath("//*[@id=\"__tealiumImplicitmodal\"]/div/button/span[1]"));
		cookiesRemove.click();

		WebElement userName=driver.findElement(By.xpath("//*[@id=\"ups-full_name_input\"]"));    
		userName.sendKeys("Moh Mukit");
		WebElement email=driver.findElement(By.xpath("//*[@id=\"ups-email_input\"]"));
		email.sendKeys("mohmukit@gmail.com");  
		WebElement userID=driver.findElement(By.xpath("//*[@id=\"ups-user_id_input\"]"));
		userID.sendKeys("Mohjpojooj");
		WebElement passWord=driver.findElement(By.xpath("//*[@id=\"ups-user_password_input\"]"));
		passWord.sendKeys("Mukitojo%^#@$");
		WebElement clickShowPW=driver.findElement(By.xpath("//*[@id=\"showButton\"]/span"));
		clickShowPW.click();


		Select country=new Select(driver.findElement(By.xpath("//*[@id=\"main\"]/div/fullpage-doa/main-component/div/login-register/div/div/div[2]/div[2]/form/div[3]/div/div[1]/div/select")));
		country.selectByValue("BI"); 

		WebElement phoneNumber=driver.findElement(By.xpath("//*[@id=\"ups-phone_input\"]"));
		phoneNumber.sendKeys("788999979");
		WebElement checkBox=driver.findElement(By.xpath("//*[@id=\"ups-checkbox_group\"]/div"));////*[@id="ups-checkbox_group"]/div/label
		checkBox.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement submitbutton=driver.findElement(By.xpath("//*[@id=\"main\"]/div/fullpage-doa/main-component/div/login-register/div/div/div[2]/div[2]/form/div[4]/div[3]/div/button"));
		submitbutton.click();
		driver.quit();
		
	}


}
