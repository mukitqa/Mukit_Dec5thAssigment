package com.ups.testRunner;

import static org.testng.Assert.fail;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.ups.drivers.UpsDrivers;
import com.ups.pageActions.UpsLoginPageActions;
import com.ups.pageElements.UpsLoginPageElements;

public class UpsLoginTestRunner extends UpsDrivers {

	WebDriver driver;
	UpsLoginPageActions loginTest;

	@BeforeMethod(alwaysRun = true)
	@Parameters(value = { "browser" })
	void beforeMethod(String browser) {
		if (browser.equalsIgnoreCase("ChromeBrowser")) {

			this.driver = runChromeDriver();
			this.loginTest = new UpsLoginPageActions(driver);
		} else if (browser.equalsIgnoreCase("FirefoxBrowser")) {

			this.driver = runFirefoxDriver();
			this.loginTest = new UpsLoginPageActions(driver);
		}
		driver.get("https://www.ups.com/lasso/login?");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test(groups = { "SanityTest" }, priority = 1)
	void loginErrorMsgTest() {
		loginTest.closeCookieBanner();
		loginTest.setUserId("MOh Mukit");
		loginTest.setPassword("Talentech@#$$%%");
		loginTest.clickSubmitBtn();
		String errorMsg = loginTest.loginErrorMsg();

		if (errorMsg.contains("unsuccessful")) {
			System.out.println("PASSED");
		} else {
			fail();
		}
	}

	@Test(groups = { "RegressionTest" }, priority = 2)
	void forgotLinkTest() {
		loginTest.closeCookieBanner();
		loginTest.clickLoginForgot();
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
