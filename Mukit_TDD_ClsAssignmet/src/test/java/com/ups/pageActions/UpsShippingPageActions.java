package com.ups.pageActions;

import org.openqa.selenium.WebDriver;

import com.ups.pageElements.UpsLoginPageElements;
import com.ups.pageElements.UpsShippingPageElements;

public class UpsShippingPageActions {


	UpsShippingPageElements  shipPage ;

	public UpsShippingPageActions(WebDriver driver) {

		this.shipPage = new UpsShippingPageElements(driver);

	}

	public void closeCookieBanner() {
		shipPage.upsPageCloseCookieBanner().click();
	}

	public void clickOnShipNow() {
		shipPage.shipNowClick().click();
		
	}

	public void printShipPageTitle() {
		shipPage.getShipPageTitle();
	}

	public void countrySelect() {
		shipPage.selectCountry();
	}
	
	public void shiperName() {
		shipPage.fillShipperName().sendKeys("Moh Mukit");
		
	}
	public void contactName() {
		shipPage.fillContactName().sendKeys("Farhan");
		
	}
	public void address() {
		shipPage.fillHomeAddress().sendKeys("43-97 Knox Pl");
		
	}
	public void postalCode() {
		shipPage.fillCustomerZip().sendKeys("11928");
		
	}
	

	public void townName() {
		shipPage.fillTownULive().sendKeys("Bronx");
		
	}
	
	public void tcBoxClick() {
		shipPage.clickonTCBox().click();
		
	}
	
	public void tcBoxCAgain() {
		shipPage.tcBoxCAgain().click();
		
	}
	
	public String getTCErrorMsg() {
	String errorMsg=	shipPage.getTCErrorMsg().getText();
	System.out.println(errorMsg);
	return errorMsg;
		
	}
	
	

}
