package com.ups.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpsDrivers {

	public WebDriver runChromeDriver() {
		WebDriverManager.chromedriver().browserVersion("87.0.4280.88").setup();
		WebDriver driver = new ChromeDriver();
		return driver;
	}

	public WebDriver runFirefoxDriver() {

		WebDriverManager.firefoxdriver().browserVersion("83").setup();
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

}
