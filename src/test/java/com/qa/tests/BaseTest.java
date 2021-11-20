package com.qa.tests;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.factory.DriverFactory;
import com.qa.java.BasePage;

public class BaseTest {
	
	WebDriver driver;
	Properties prop;
	DriverFactory df;
	
	private Logger log = LogManager.getLogger(BaseTest.class);
	
	SoftAssert softAssert;
		
	BasePage careerPage;

	@BeforeTest
	public void SetUp() {
		try {
		softAssert = new SoftAssert();
		df = new DriverFactory();
		prop = df.init_properties();	
		driver = df.initDriver(prop);
		careerPage = new BasePage(driver);
		
		log.info("Before test method executed...");

		} catch (Exception e) {
			log.error("Somethign went wrong at setup...", e.fillInStackTrace());
		}
		
	}
	
	@AfterTest
	public void TearDown() {
		try {
		driver.quit();
		log.info("After test method executed and quit browser...");

	} catch (Exception e) {
		log.error("Somethign went wrong at TearDown...", e.fillInStackTrace());
	}
	}
}
