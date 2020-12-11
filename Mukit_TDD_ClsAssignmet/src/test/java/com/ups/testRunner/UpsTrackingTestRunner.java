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
import com.ups.pageActions.UpsTrackingPageActions;

public class UpsTrackingTestRunner extends  UpsDrivers {


	WebDriver driver;
	 UpsTrackingPageActions trackingTest;

	@BeforeMethod(alwaysRun = true)
	@Parameters(value = { "browser" })
	void beforeMethod(String browser) {
		if (browser.equalsIgnoreCase("ChromeBrowser")) {

			this.driver = runChromeDriver();
			this.trackingTest = new UpsTrackingPageActions (driver);
		} else if (browser.equalsIgnoreCase("FirefoxBrowser")) {

			this.driver = runFirefoxDriver();
			this.trackingTest = new UpsTrackingPageActions (driver);
		}
		driver.get("https://www.ups.com/lasso/tracking");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test(groups = { "SanityTest" }, priority = 1)
	void loginErrorMsgTest() {
		trackingTest.removeCookies();
		trackingTest.tracTBox();
		trackingTest.clickTkBtn();
		trackingTest.setTKNumber();
		trackingTest.clickOnTKBox();
		
		String errorMsg = trackingTest.getErrorMgs();

		if (errorMsg.contains("shipment")) {
			System.out.println("PASSED");
		} else {
			fail();
		}
		
		
	}

	@Test(groups = { "RegressionTest" }, priority = 2)
	void cookiesMsgTeat() {
		
		String expectedCooMsg= "Tracking Successfully ";
		String actulErrorCooMsg=trackingTest.cookiesMsg();
		Assert.assertEquals(actulErrorCooMsg, expectedCooMsg);

	}

	@AfterMethod(alwaysRun = true)
	void afterMethod() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

}
