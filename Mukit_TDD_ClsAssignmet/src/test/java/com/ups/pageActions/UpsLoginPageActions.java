package com.ups.pageActions;

import org.openqa.selenium.WebDriver;
import com.ups.pageElements.UpsLoginPageElements;

public class UpsLoginPageActions {

	UpsLoginPageElements loginPage = null;

	public UpsLoginPageActions(WebDriver driver) {

		this.loginPage = new UpsLoginPageElements(driver);

	}

	public void closeCookieBanner() {
		loginPage.upsPageCloseCookieBanner().click();
	}

	public void setUserId(String userId) {
		loginPage.loginUserId().sendKeys(userId);
	}

	public void setPassword(String password) {
		loginPage.loginPassword().sendKeys(password);
	}

	public void clickSubmitBtn() {
		loginPage.loginButton().click();
	}

	public String loginErrorMsg() {
		String msg = null;

		try {

			msg = loginPage.upsLoginErrorMsg().getText();

		} catch (Exception e) {
			System.out.println("Error message not displayed!");
		}

		return msg;
	}

	public void clickLoginForgot() {
		loginPage.upsForgotLogin().click();
	}
	
}
