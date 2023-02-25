package com.diligend.testCases.InvestorQuestionnaire;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.diligend.BaseClass.DiligendBaseClass;
import com.diligend.PageObjects.DiligendClientLogoutPage;
import com.diligend.PageObjects.Questionnaires.DiligendParticpantPages;
import com.diligend.PageObjects.Questionnaires.DiligendQuestionnairesCopyPage;
import com.diligend.PageObjects.Questionnaires.DiligendQuestionnairesPage;
import com.diligend.PageObjects.Responses.DiligendResponsesPage;
import com.diligend.actiondriver.Common;
import com.diligend.testCases.TC_Diligend_Login_LogoutTest;


// Author Pooja
//date 24-03-2022

public class TC_DiligendCopyQuestionary extends DiligendBaseClass {

	TC_Diligend_Login_LogoutTest objLP = new TC_Diligend_Login_LogoutTest(driver); // interface class
	TC_CreateQuestionnariefromscratch objQPs = new TC_CreateQuestionnariefromscratch();
	TC_DesignerPage_003 obDP = new TC_DesignerPage_003();
	TC_Diligend_Participants_005 obAPP = new TC_Diligend_Participants_005();
	public DiligendClientLogoutPage objLo;
	
	DiligendQuestionnairesCopyPage obQCP;
	DiligendQuestionnairesPage objQP;
	DiligendResponsesPage objQRP = new DiligendResponsesPage(driver);

	   //Creating the JavascriptExecutor interface object by Type casting		
   
    
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
	

	@Test(priority = 2)
	public void CopyExistingQuestionnarie() {
		try {
			logger.info("Creating Copy Questionnaire");
			obQCP = new DiligendQuestionnairesCopyPage(driver);
			logger.info("Verifying Questionnaire from sidemenu");
			objQPs.QuestionnariePageFromSidemenu();
			Thread.sleep(700);
			logger.info("Verifying for click on more button");
			obQCP.MoreButtonOnPage();
			
			logger.info("verify for Copy existing Questionnarie");
			obQCP.CopyExistingQuest();
			logger.info("verify for Questionnarie popup");
			Thread.sleep(500);
			logger.info("Click Select");
			obQCP.ClickOnSelect();
			logger.info("Copy question from list");
			Thread.sleep(300);
			logger.info("Copy quest");
			obQCP.CopyQuest();
			// WebDriverWait wait = new WebDriverWait(driver,30);
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[normalize-space()='Copy
			// confirmation']")));
			logger.info("EnterDescription");
			obQCP.CopyQuestDescription();
			logger.info("Click yes");
			obQCP.ClickYes();
			Thread.sleep(3000);
			Assert.assertTrue(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.warn(e);
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 3)
	public void QuestionnarieDesignerPage() throws InterruptedException {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@class='questionnaire-tree-container']")));
			obDP.QuestionPageValidation();
			Thread.sleep(500);
			obDP.QuestionDesignnerPage();
			Thread.sleep(2000);
			Assert.assertTrue(true);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.warn(e);
			Assert.assertTrue(false);

		}

	}
	
	
	
	@Test (priority = 4)
	public void createQuestionnaire() {
		try {
			logger.info("Creating Questionnaire from scratch");
			objQPs.QuestionnariePageFromSidemenu();
			Thread.sleep(200);
			String[][] data = objQPs.getdata();
			objQPs.CreateQuestionnariefromScratch(data[0][0], data[0][1]);
			Thread.sleep(500);
			Assert.assertTrue(true);
		}catch(Exception e) {
			e.printStackTrace();
			logger.warn(e);
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority=5)
	public void Importquestionnaire() throws Exception {
		
		DiligendQuestionnairesPage objqre = new DiligendQuestionnairesPage(driver);
		logger.info("Import qusetionnaire");
		Thread.sleep(500);
		objqre.navigationQuestionnairePage();
		Thread.sleep(500);
		objqre.createByImport();
		Thread.sleep(800);
		logger.info("Designner page validation");
		QuestionnarieDesignerPage();
		
	}
	
	@Test(priority = 6)
	public void addparticipant() throws Exception {
		
		DiligendParticpantPages objpart = new DiligendParticpantPages(driver);
		objpart.AddParticipantsMethod();
		Thread.sleep(500);
		
		
	}
	
	
	/*
	 * @Test(priority = 6) public void importQuestionnarie() throws Exception { objQP
	 * = new DiligendQuestionnairesPage(driver);
	 * logger.info("Import qusetionnaire"); objQP.navigationQuestionnairePage();
	 * objQP.createByImport(); }
	 */
	
	
	
	/*
	 * @Test(priority = 5) public void AddParticipantsPage() { try {
	 * obAPP.Particpants_Page(); obAPP.AddParticipantsPage();
	 * obAPP.InviteParticpants_Page();
	 * 
	 * } catch (Exception e) { // TODO: handle exception e.printStackTrace(); } }
	 */
	
	
	@Test(priority=7)
	public void ResponsePageCreateResponseResponseQR() throws Exception {
		
		objQRP = new DiligendResponsesPage(driver);
		logger.info("creating response");
		objQRP.ResponsePagecreatetResponseQR();
		Thread.sleep(500);
		
	}
	
		
	
	

	@Test(priority = 8)
	public void verificationResponseQR() throws Exception {
	
		objQRP = new DiligendResponsesPage(driver);
		Thread.sleep(2000);
		logger.info("verification Response");
		objQRP.ResponsePageVerificationQR();
		Thread.sleep(500);
		
		
	}
	
	@Test(priority=9)
	public void ResponsePageValidationImportResponseQR() throws Exception {
	
		objQRP = new DiligendResponsesPage(driver);
		logger.info("Importing response");
		objQRP.ResponsePageValidationImportResponseQR();
		Thread.sleep(500);
		
	}
	
	
	@Test(priority=10)
	public void ResponsePageValidationExportResponseQR() throws Exception {
		
		objQRP = new DiligendResponsesPage(driver);
		logger.info("Export response");
		objQRP.ResponsePageValidationExportResponseQR();
		Thread.sleep(5000);
		
	}
	
	
	@Test(priority = 11)
	public void LogoutPage() throws Exception {
		logger.info("To verify logout functionality");

		objLo.Logout();
			
		
	
	}


}