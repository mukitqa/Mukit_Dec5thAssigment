package com.ups.pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpsLoginPageElements {

	WebDriver driver = null;

	public UpsLoginPageElements(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement upsPageCloseCookieBanner() {

		WebElement closeCookieBanner = driver
				.findElement(By.xpath("//*[@id='__tealiumImplicitmodal']/div/button/span[1]"));
		return closeCookieBanner;
	}

	public WebElement loginUserId() {
		WebElement userId = driver.findElement(By.id("email"));
		return userId;
	}

	public WebElement loginPassword() {
		WebElement password = driver.findElement(By.name("password"));
		return password;
	}

	public WebElement loginButton() {
		WebElement loginBtn = driver.findElement(By.cssSelector("#submitBtn"));
		return loginBtn;
	}

	public WebElement upsLoginErrorMsg() {
		WebElement errorMsg = driver.findElement(By.xpath("//*[@id='errorMessages']"));
		return errorMsg;

	}
	
	public WebElement upsForgotLogin() {
		WebElement forgotLogin = driver.findElement(By.linkText("I forgot my User ID or Password"));
		return forgotLogin;
		
	}
	
	
}
