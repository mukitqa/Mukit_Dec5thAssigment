package com.ups.pageActions;

import org.openqa.selenium.WebDriver;

import com.ups.pageElements.UpsTrackingPageElements;





public class UpsTrackingPageActions   {

	UpsTrackingPageElements tracPage ;

	public UpsTrackingPageActions  (WebDriver driver) {

		this.tracPage = new UpsTrackingPageElements (driver);

	}

	
	public void removeCookies() {
		
		tracPage.cokeRemov().click();
	}
	public String cookiesMsg() {
		return tracPage.cokeRemov().getText();
	}
	public void tracTBox() {
		
		tracPage.trackingTBox().click();
	}
	public void clickTkBtn() {
		tracPage.trackingButton().click();
	}
	
	public void setTKNumber() {
		tracPage.setTrackNumber().sendKeys("6688800000");
	}
	
	public void clickOnTKBox() {
		tracPage.clickOnTrack().click();
	}
	
	
	public  String getErrorMgs() {
		 tracPage.trackingErrorMsg().isDisplayed();
		 return getErrorMgs();
		
		}

}
