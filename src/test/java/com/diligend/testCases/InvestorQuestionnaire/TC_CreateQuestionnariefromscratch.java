package com.diligend.testCases.InvestorQuestionnaire;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.diligend.BaseClass.DiligendBaseClass;
import com.diligend.PageObjects.ManagerQuestionnairePage.DiligendMNCQuestionnairePage;
import com.diligend.PageObjects.Questionnaires.DiligendQuestionnairesPage;
import com.diligend.actiondriver.Common;
import com.diligend.testCases.TC_Diligend_Login_LogoutTest;
import com.diligend.utilities.ExcelUtilility;

public class TC_CreateQuestionnariefromscratch extends DiligendBaseClass {

	DiligendQuestionnairesPage objQP; // page factory
	TC_Diligend_Login_LogoutTest objLP = new TC_Diligend_Login_LogoutTest(driver); // interface class
	TC_DesignerPage_003 objQD = new TC_DesignerPage_003();

	// Code Reusablity calling Login test methods from  TC_Diligend_Login_LogoutTest_001 class
	

	@Parameters({ "browser", "role" })
	@Test(priority = 1)
	public void LoginClass(String browser, String role) {
		System.out.println(browser + " " + role);
		objQP = new DiligendQuestionnairesPage(driver);
		objLP = new TC_Diligend_Login_LogoutTest(driver);
		try {
			logger.info("verifying for User Login");
			objLP.verifyTitle();
			String[][] data = objLP.getdata(browser, role);
			objLP.Logintest(data[0][0], data[0][1]);
			Assert.assertTrue(true);
			Common.pageLoadTimeOut(driver, 300);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertTrue(false);
			logger.warn("Login Verification failed");
		}
	}
	
	
	@Test(dependsOnMethods = { "LoginClass" })
	public void QuestionnariePageFromSidemenu() {

		logger.info("Verifying for Questionnarie from Scratch");
		try {

			Thread.sleep(2000);
			logger.info("verify for open Questionnarie page from sidemenu");
			objQP = new DiligendQuestionnairesPage(driver);
			Thread.sleep(500);
			logger.info("clicked on sidemenu");
			objQP.QuestionnarieSidemenuClick();
			Thread.sleep(1000);
			Assert.assertTrue(true);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.warn(e);
			Assert.assertTrue(false);
		}

	}

	@Test(dependsOnMethods = { "QuestionnariePageFromSidemenu" }, dataProvider = "QuestionData")
	public void CreateQuestionnariefromScratch(String Description, String Name) {
		try {

			logger.info("Verifying for creating new Questionnarie");
			objQP.MoreButtonOnPage();
			Thread.sleep(500);
			logger.info("verify for Questionnarie from Scratch");
			objQP.CreatefromScratch();
			Thread.sleep(2000);
			logger.info("verify for Questionnarie popup");
			Thread.sleep(2000);
			logger.info("Adding Question Name and Description");
			objQP.CreatePopup(Name, Description);
			Thread.sleep(2000);
			Assert.assertTrue(true);
			logger.info("Questionnaire are created sucessfully");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.warn(e);
			Assert.assertTrue(false);
		}

	}

	
	

	@DataProvider(name = "QuestionData")
	public String[][] getdata() throws IOException {

		// get the data from excel

		String path = System.getProperty("user.dir")
				+ "//src//test//resources//TestData//CreateFromScratchQuestionnarie.xlsx";

		System.out.println(path);

		ExcelUtilility xlutility = new ExcelUtilility(path);

		int totalrow = xlutility.getRowCount("Sheet1");
		int totalcols = xlutility.getCellCount("Sheet1", 1);

		String loginData[][] = new String[totalrow][totalcols];
		for (int i = 1; i <= totalrow; i++) {

			for (int j = 0; j < totalcols; j++) {
				loginData[i - 1][j] = xlutility.getCellData("Sheet1", i, j);
			}
		}
		return loginData;

	}


}
