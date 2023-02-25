package com.diligend.testCases.Responses;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.diligend.BaseClass.DiligendBaseClass;
import com.diligend.PageObjects.Responses.DiligendResponsesPage;
import com.diligend.testCases.TC_Diligend_Login_LogoutTest;


public class TC_Diligend_Responses_006 extends DiligendBaseClass {

	DiligendResponsesPage objQRP = new DiligendResponsesPage(driver);
	TC_Diligend_Login_LogoutTest objLP = new TC_Diligend_Login_LogoutTest(driver);

	@Test(priority = 1)
	public void LoginClass(String browser, String role) {
		try {
			logger.info("Automation Test script started for Login and create questionnaire from scratch");		
			objLP.verifyTitle();
			Thread.sleep(200);
			String[][] data = objLP.getdata(browser, role);
			objLP.Logintest(data[0][0], data[0][1]);
			Assert.assertTrue(true);
			
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertTrue(false);
		} 
	}

	/*
	 * @Test(enabled = false) public void navigationResponseIR() throws Exception {
	 * //objQRP = new DiligendResponsesPage(driver);
	 * logger.info("verify for open Questionnarie reposnse page");
	 * Thread.sleep(500); objQRP.navigationResponsePage(); }
	 * 
	 * @Test(enabled = false) public void verificationResponseIR() throws Exception
	 * { //objQRP = new DiligendResponsesPage(driver);
	 * logger.info("verify for open Questionnarie reposnse page");
	 * objQRP.verificationFolderViewResponsePage();
	 * 
	 * }
	 * 
	 * @Test (enabled = false) public void validationResponseIR() throws Exception {
	 * objQRP = new DiligendResponsesPage(driver); objQRP.importResponse(); }
	 */

	@Test(priority=3)
	public void ResponsePageValidationImportResponseQR() throws Exception {

		objQRP = new DiligendResponsesPage(driver);
		logger.info("Importing response");
		objQRP.ResponsePageValidationImportResponseQR();
	
		
	}

	@Test(priority = 2)
	public void verificationResponseQR() throws Exception {
		objQRP = new DiligendResponsesPage(driver);
		Thread.sleep(2000);
		logger.info("verification Response");
		objQRP.ResponsePageVerificationQR();

	}
	@Test(priority=4)
	public void ResponsePageValidationExportResponseQR() throws Exception {

		objQRP = new DiligendResponsesPage(driver);
		logger.info("Export response");
		objQRP.ResponsePageValidationImportResponseQR();
		Thread.sleep(5000);
	
		
	}

}
	
	
	
	
