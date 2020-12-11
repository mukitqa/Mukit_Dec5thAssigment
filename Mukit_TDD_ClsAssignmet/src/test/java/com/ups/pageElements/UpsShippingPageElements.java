package com.ups.pageElements;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

public class UpsShippingPageElements {

	WebDriver driver = null;

	public UpsShippingPageElements(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement upsPageCloseCookieBanner() {

		WebElement cookiesRemove = driver
		.findElement(By.xpath("//*[@id=\"__tealiumImplicitmodal\"]/div/button/span[1]"));
		return cookiesRemove;
	}

	public WebElement shipNowClick() {
		WebElement clickShipNow=driver
				.findElement(By.id("ups-banner-ctatxtid0"));
		return clickShipNow;
	}

	public String getShipPageTitle() {
		
		String title=driver.getTitle();
		System.out.println(title);
		return title;
	}
	
	public WebElement selectCountry() {
		Select clickCountry=new Select(driver.findElement(By.xpath("//*[@id=\"origin-cac_country\"]")));
		//clickCountry.selectByIndex(2);
		return (WebElement) clickCountry;
		
	}

	public WebElement fillShipperName() {
		WebElement setName=driver.findElement(By.xpath("//*[@id=\"origin-cac_companyOrName\"]"));
		//setName.sendKeys(" Moh Mukit");
		return setName;
	}


	public WebElement fillContactName() {
		WebElement setContName=driver.findElement(By.xpath("//*[@id=\"origin-cac_contactName\"]"));
		//setContName.sendKeys("Farhan");
		return setContName;
	}

	public WebElement fillHomeAddress() {
		WebElement addressSet=driver.findElement(By.xpath("//*[@id=\"origin-cac_addressLine1\"]"));
		//addressSet.sendKeys("123 knmox place");
		return addressSet;
	}
	
	public WebElement fillCustomerZip() {
		WebElement postalCode=driver.findElement(By.id("origin-cac_postalCode"));
		//postalCode.sendKeys("11276");
		 return  postalCode;
		
	}
	public WebElement fillTownULive() {
		WebElement setTown=driver.findElement(By.xpath("//*[@id=\"origin-cac_city\"]"));
		//setTown.sendKeys(" Bronx");
		
		return setTown;
	}
	
	
	public WebElement clickonTCBox() {
		WebElement tcBoxClick=driver.findElement(By.xpath("//*[@id=\"termsAndConditionsControl\"]/div[2]/common-checkbox/div/div/label"));
		tcBoxClick.click();
		
		return tcBoxClick;
	}
	public WebElement tcBoxCAgain() {
		WebElement tcBoxCA=driver.findElement(By.xpath("//*[@id=\"termsAndConditionsControl\"]/div[2]/common-checkbox/div/div/label"));
	   // TCBoxclickAgain.click();
		
		return tcBoxCA;
	}
	

	public WebElement getTCErrorMsg() {
		WebElement tcErrorMsg=driver.findElement(By.xpath("//*[@id=\"termsAndConditionsControlFieldError\"]"));
	    System.out.println(tcErrorMsg.getText());
		
		
		return tcErrorMsg;
	}

}
