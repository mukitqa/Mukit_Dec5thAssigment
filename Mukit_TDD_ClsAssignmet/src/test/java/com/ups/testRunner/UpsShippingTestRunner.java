package com.ups.testRunner;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ups.drivers.UpsDrivers;
import com.ups.pageActions.UpsLoginPageActions;
import com.ups.pageActions.UpsShippingPageActions;

public class UpsShippingTestRunner extends  UpsDrivers{


	WebDriver driver;
	UpsShippingPageActions shipTest;

	@BeforeMethod(alwaysRun = true)
	@Parameters(value = { "browser" })
	void beforeMethod(String browser) {
		if (browser.equalsIgnoreCase("ChromeBrowser")) {

			this.driver = runChromeDriver();
			this.shipTest = new UpsShippingPageActions(driver);
		} else if (browser.equalsIgnoreCase("FirefoxBrowser")) {

			this.driver = runFirefoxDriver();
			this.shipTest = new UpsShippingPageActions(driver);
		}
		driver.get("https://www.ups.com/lasso/shipping");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test(groups = { "SanityTest" }, priority = 1)
	void shipErrorMsgTest() {
		shipTest.closeCookieBanner();
		shipTest.clickOnShipNow();
		shipTest.printShipPageTitle();
		shipTest.countrySelect();
		shipTest.shiperName();
		shipTest.contactName();
		shipTest.address();
		shipTest.postalCode();
		shipTest.townName();
		shipTest.tcBoxClick();
		shipTest.tcBoxCAgain();
		
		String errorMsg = shipTest.getTCErrorMsg();

		if (errorMsg.contains("Tariff/Terms")) {
			System.out.println("PASSED");
		} else {
			fail();
		}
	}

	@Test(groups = { "RegressionTest" }, priority = 2)
	void forgotClickBanner() {
		shipTest.closeCookieBanner();
		String expectedPageTitle = "Reset or Recover Login Settings | UPS - United States";
		String actualPageTitle = driver.getTitle();
		Assert.assertEquals(actualPageTitle, expectedPageTitle);

	}

	@AfterMethod(alwaysRun = true)
	void afterMethod() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

}
