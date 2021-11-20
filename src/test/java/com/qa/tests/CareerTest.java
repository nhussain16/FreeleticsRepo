package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.utils.Constants;

public class CareerTest extends BaseTest{

	@Test
	public void GetQAEngineerJobDetails() {
		careerPage.acceptBrowserCookies();
		careerPage.accessCareerPage();
		careerPage.openPositionLink();
		careerPage.selectQAPosition();

		softAssert.assertEquals(careerPage.verifyJobTitle(), Constants.JOB_TITLE);
		softAssert.assertEquals(careerPage.verifyJobLocation(), Constants.JOB_LOCATION);
		softAssert.assertTrue(careerPage.verifyJobDescription());
		
		softAssert.assertEquals(careerPage.verifyJobResponsilityTitle(), Constants.JOB_RESPONSIBILITY_TITLE);
		softAssert.assertEquals(careerPage.verifyResponsibilityPoints(), Constants.POINTS_COUNT);
		
		softAssert.assertEquals(careerPage.verifyProfileTitle(), Constants.PROFILE_TITLE);
		softAssert.assertEquals(careerPage.verifyProfilePoints(), Constants.POINTS_COUNT);

		careerPage.applyNow();
		softAssert.assertEquals(careerPage.verifyTitleOfApplyFormPageFromNewTab(), Constants.APPLY_NOW_PAGE_TITLE);
		softAssert.assertAll();
	}	
}
