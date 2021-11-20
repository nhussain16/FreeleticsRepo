package com.qa.java;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.qa.utils.Constants;
import com.qa.utils.ElementUtil;

public class BasePage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	private Logger log = LogManager.getLogger(BasePage.class);

	private By acceptCookies = By.xpath("//span[text()='Accept all cookies']/parent::button");
	private By careersLink = By.linkText("Careers");
	private By openPositionsLink = By.cssSelector("a[href*='jobs']");
	private By QAPositionLink = By.linkText("QA Engineer (m/f/d) - Remote or Munich");

	private By jobTitle = By.cssSelector("h1[itemprop='title']");
	private By jobLocation = By.cssSelector("span[itemprop='jobLocation']");
	private By jobResponsilityTitle = By.cssSelector("section[itemprop='responsibilities']>header>h2");
	private By responsibilityPoints = By.cssSelector("section[itemprop='responsibilities']>ul>li");
	private By profileTitle = By.cssSelector("section[itemprop='experienceRequirements']>header>h2");
	private By profilePoints = By.cssSelector("section[itemprop='experienceRequirements']>header+ul>li");
	private By applyNowBtn = By.linkText("Apply now");

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.elementUtil = new ElementUtil(driver);
	}

	public void acceptBrowserCookies() {
		try {
			elementUtil.waitForElementVisibleUsingBy(acceptCookies, 5);
			elementUtil.doActionsClick(acceptCookies);

			log.info("Accept all cookies button from browser popup...");

		} catch (NoSuchElementException e) {
			log.error("All cookies popup screen not appeared...", e.fillInStackTrace());
		}
	}

	public void accessCareerPage() {
		try {
			elementUtil.scrollPageDown();
			elementUtil.doActionsClick(careersLink);

			log.info("Access career page...");

		} catch (NoSuchElementException e) {
			log.error("All cookies popup screen not appeared...", e.fillInStackTrace());
		}
	}

	public void openPositionLink() {
		try {
			elementUtil.waitForElementVisibleUsingBy(openPositionsLink, 5);
			elementUtil.doClick(openPositionsLink);

			log.info("Click on open positions...");

		} catch (NoSuchElementException e) {
			log.error("All cookies popup screen not appeared...", e.fillInStackTrace());
		}
	}

	public void selectQAPosition() {
		try {
			elementUtil.waitForElementVisibleUsingBy(QAPositionLink, 5);
			elementUtil.doActionsClick(QAPositionLink);

			log.info("Select QA Engineer job position...");

		} catch (NoSuchElementException e) {
			log.error("All cookies popup screen not appeared...", e.fillInStackTrace());
		}
	}

	public String verifyJobTitle() {
		String pageTitle = null;
		try {
			elementUtil.waitForElementPresence(jobTitle, 5);
			pageTitle = elementUtil.getElement(jobTitle).getText();

			log.info("Verify job title...");

		} catch (NoSuchElementException e) {
			log.error("Job title not found...", e.fillInStackTrace());
		}
		return pageTitle;
	}

	public String verifyJobLocation() {
		String jobLoc = null;
		try {
			elementUtil.waitForElementPresence(jobLocation, 5);
			jobLoc = elementUtil.getElement(jobLocation).getText();

			log.info("Verify job location...");

		} catch (NoSuchElementException e) {
			log.error("Job location not found...", e.fillInStackTrace());
		}
		return jobLoc;
	}

	public Boolean verifyJobDescription() {
		try {

			log.info("Verify Job description...");

			return elementUtil.doGetPageSource(Constants.JOB_DESC_CONTAINS);

		} catch (NoSuchElementException e) {
			log.error("Job description not found...", e.fillInStackTrace());
			return false;
		}
	}

	public String verifyJobResponsilityTitle() {
		String jobResp = null;
		try {
			jobResp = elementUtil.getElement(jobResponsilityTitle).getText();

			log.info("Verify Job responsibility title..." + jobResp);

		} catch (NoSuchElementException e) {
			log.error("Job responsibility not found...", e.fillInStackTrace());
		}
		return jobResp;
	}

	public int verifyResponsibilityPoints() {
		int pointsCount = 0;
		try {
			pointsCount = elementUtil.getElements(responsibilityPoints).size();

			log.info("Verify Job responsibility bullet points count..." + Constants.POINTS_COUNT);

		} catch (NoSuchElementException e) {
			log.error("Job responsibility points not matched...", e.fillInStackTrace());
		}
		return pointsCount;
	}

	public String verifyProfileTitle() {
		String profile = null;
		try {
			profile = elementUtil.getElement(profileTitle).getText();

			log.info("Verify profile title..." + profile);

		} catch (NoSuchElementException e) {
			log.error("Job profile title not found...", e.fillInStackTrace());
		}
		return profile;
	}

	public int verifyProfilePoints() {
		int pointsCount = 0;
		try {

			log.info("Verify profile bullet points count..." + Constants.POINTS_COUNT);
			
			return elementUtil.getElements(profilePoints).size();
		} catch (NoSuchElementException e) {
			log.error("Job profile points not matched...", e.fillInStackTrace());
		}
		return pointsCount;
	}

	public void applyNow() {
		try {
			elementUtil.scrollPageDown();
			elementUtil.doActionsClick(applyNowBtn);

			log.info("Apply Now button is clicked...");

		} catch (NoSuchElementException e) {
			log.error("Apply now button not found...", e.fillInStackTrace());
		}
	}

	public String verifyTitleOfApplyFormPageFromNewTab() {
		int NewTab = 1;
		String page = null;
		try {
			List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
			page = driver.switchTo().window(browserTabs.get(NewTab)).getTitle();

			log.info("Apply Now form page title..." + page);
			
		} catch (NoSuchElementException e) {
			log.error("Apply form page title not found...", e.fillInStackTrace());
		}
		return page;
	}
}