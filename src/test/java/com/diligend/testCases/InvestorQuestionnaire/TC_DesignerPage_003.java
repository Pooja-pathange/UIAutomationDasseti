package com.diligend.testCases.InvestorQuestionnaire;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.diligend.BaseClass.DiligendBaseClass;
import com.diligend.PageObjects.Questionnaires.DligendQuestionDesignerPage;

//Author Pooja
//date 24-03-2022

public class TC_DesignerPage_003 extends DiligendBaseClass {

	DligendQuestionDesignerPage objQDP ;

	@Test(priority = 1)
	public void QuestionPageValidation() {
	

		try {
			objQDP = new DligendQuestionDesignerPage(driver);
			logger.info("verify for Question Design Page");
			objQDP.designPagevalidation();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Test(priority = 2)
	public void QuestionDesignnerPage() throws InterruptedException {

		try {

			logger.info("verify for Question Designer Page");
			objQDP.QuestionDesignerPageValidation();
			Thread.sleep(200);
			objQDP.QuestionDesignerSettingValidation();
			Thread.sleep(200);
			objQDP.UpdateQuestionnairename();
			Thread.sleep(500);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

}
