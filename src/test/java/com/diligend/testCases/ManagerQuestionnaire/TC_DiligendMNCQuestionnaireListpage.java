package com.diligend.testCases.ManagerQuestionnaire;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.diligend.BaseClass.DiligendBaseClass;
import com.diligend.BaseEnums.ExportType;
import com.diligend.PageObjects.DiligendClientLogoutPage;
import com.diligend.PageObjects.ManagerQuestionnairePage.DiligendMNCQuestionnairePage;
import com.diligend.actiondriver.Common;
import com.diligend.testCases.TC_Diligend_Login_LogoutTest;

// code update on 25/02/2023
public class TC_DiligendMNCQuestionnaireListpage extends DiligendBaseClass {

	public DiligendMNCQuestionnairePage objMNCQRP;
	TC_Diligend_Login_LogoutTest objLP = new TC_Diligend_Login_LogoutTest(driver);
	public DiligendClientLogoutPage objLo;

	@Parameters({ "browser", "role" })
	@Test(priority = 0)
	public void LoginClass(String browser, String role) {
		System.out.println(browser + " " + role);
		objMNCQRP = new DiligendMNCQuestionnairePage(driver);
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
	public void MNCInvitedCompanyStatusValidation() throws Exception {
		objMNCQRP.MNCInvitedCompanyStatusValidation();
	}
	@Test(priority = 3)
	public void MNCReceivedCompanyStatusValidation() throws Exception {
		objMNCQRP.MNCsubmittedCompanyStatusValidation();
	}

	@Test(priority = 4)
	public void MNCsubmittedCompanyStatusValidation() throws Exception {
		objMNCQRP.MNCsubmittedCompanyStatusValidation();
	}

	@Test(priority = 5)
	public void MNCacceptedCompanyStatusNavigation() throws Exception {
		objMNCQRP.MNCacceptedCompanyStatusValidation();

	}

@Test(dependsOnMethods = "MNCacceptedCompanyStatusNavigation", priority = 7)
	public void MNCResposneVerification() throws Exception {
		objMNCQRP.MNCQuestionnaireVerification();
	}


	@Test(dependsOnMethods = "MNCacceptedCompanyStatusNavigation", priority = 8)
	public void MNCUsePreviousAnswer() throws Exception {
		objMNCQRP.UsePrevious_Answer();
	}

	@Test(dependsOnMethods = "MNCacceptedCompanyStatusNavigation", priority = 9)
	public void ResponsePageValidationImportResponse() throws Exception {
		objMNCQRP.ResponsepageImport();
	}

	@Test(dependsOnMethods = "MNCacceptedCompanyStatusNavigation", priority = 10)
	public void MNC_ExportResponse() throws Exception {
		objMNCQRP.ExportResponsepage();

	}

	@Test(dependsOnMethods = "MNCacceptedCompanyStatusNavigation", priority = 11)
	public void MNCEResponseGenerateReportpdf() throws Exception {
		objMNCQRP.MNCEResponseGenerateReportPDF();

	}

	@Test(dependsOnMethods = "MNCacceptedCompanyStatusNavigation", priority = 12)
	public void MNCEResponseGenerateReportword() throws Exception {
		objMNCQRP.MNCEResponseGenerateReportWORD();

	}

	@Test(dependsOnMethods = "MNCacceptedCompanyStatusNavigation", priority = 13)
	public void MNCtabAttachmentsNavigation() throws Exception {
		objMNCQRP.MNCtabAttachmentsNavigation();
	}

	@Test(dependsOnMethods = "MNCacceptedCompanyStatusNavigation", priority = 14)
	public void MNCAttachmentsImport() throws Exception {
		objMNCQRP.MNCtabAttachmentsImport();
	}

	@Test(dependsOnMethods = "MNCAttachmentsImport", priority = 15)
	public void MNCAttachmentsVerification() throws Exception {
		objMNCQRP.MNCtabAttachmentsVerification();
	}

	@Test(dependsOnMethods = "MNCAttachmentsImport", priority = 16)
	public void MNCAttachmenstdownload() throws Exception {
		objMNCQRP.MNCAttachmenstdownload();
	}

	@Test(dependsOnMethods = "MNCAttachmentsImport", priority = 17)
	public void MNCAttachmenstDelete() throws Exception {
		objMNCQRP.MNCAttachmenstDelete();
	}

	@Test(priority = 18)
	public void MNCERefereneceDocumentsValidation() throws Exception {
		objMNCQRP.MNCERefereneceDocumentsValidation();
	}

	@Test(priority = 19)
	public void MNCQAtabValidation() throws Exception {
		objMNCQRP.MNCQAtabValidation();
	}

	@Test(priority = 20)
	public void MNCQuestionnaireLisPage() {
		try {
			logger.info("Automation script for validating questionnaire List Page");
			logger.info("Verifying for title filter");
			objMNCQRP.titlefilter();
			logger.info("Verifying for Export functionality on manager questionnaire List screen");
			objMNCQRP.ExportPDFMethod(ExportType.PDF);
			Common.pageLoadTimeOut(driver, 100);
			objMNCQRP.ExportExcelMethod(ExportType.EXCEL);
			Common.pageLoadTimeOut(driver, 100);
			objMNCQRP.ExportWordMethod(ExportType.WORD);
			Common.pageLoadTimeOut(driver, 300);		
			Assert.assertTrue(true); // Navigate inside Questionnaire
		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
			logger.warn("questionnaire List page validating Failed");
			Assert.assertTrue(false);
		}
	}

	//@Test(priority = 21)
	public void Logout() throws Exception {
		objLo.Logout();
	}
}