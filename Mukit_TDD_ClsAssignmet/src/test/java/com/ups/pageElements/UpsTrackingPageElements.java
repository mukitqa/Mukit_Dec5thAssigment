package com.ups.pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpsTrackingPageElements {

	WebDriver driver=null;

	public UpsTrackingPageElements(WebDriver driver) {
		this.driver = driver;
	}

	
	public WebElement cokeRemov(){
		WebElement removeCokies=driver
		.findElement(By.xpath("//*[@id=\"__tealiumImplicitmodal\"]/div/button/span[1]"));
		//cookiesRemove.click();
		return removeCokies;
		
	}

	public WebElement trackingTBox() {

		WebElement trackBox = driver
				.findElement(By.xpath("//*[@id='stApp_trackingNumber']"));
		return trackBox;
	}

	public WebElement trackingButton() {
		WebElement trackButton = driver
				.findElement(By.xpath("//*[@id='stApp_btnTrack']"));
		return trackButton;
	}
	public WebElement setTrackNumber() {
		WebElement filltrackN = driver
				.findElement(By.xpath("//*[@id=\"stApp_trackingNumber\"]"));
		return filltrackN;
	}
	public WebElement clickOnTrack() {
		WebElement clickOnTkBox = driver.findElement(By.id("stApp_btnTrack"));
		//clickTrack.click();
		return clickOnTkBox;
	}
	public WebElement trackingErrorMsg() {
		WebElement trackErrorMsg = driver
				.findElement(By.xpath("//*[@id='stApp_error_alert_list0']"));
		return trackErrorMsg;
	}

}
