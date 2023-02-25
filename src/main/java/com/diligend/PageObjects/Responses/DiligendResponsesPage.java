package com.diligend.PageObjects.Responses;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.diligend.actiondriver.Common;
import com.diligend.utilities.ExcelUtilility;

public class DiligendResponsesPage {

	WebDriver driver;
	public String SystemPath = System.getProperty("user.dir");

	public DiligendResponsesPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(d, this);
	}

	@FindBy(xpath = "//*[contains(text(),'Questionnaires')]")
	WebElement QuestionnaireMenu;
	@FindBy(xpath = "//*[text()='Responses']")
	WebElement lblResponses;
	@FindBy(xpath = "//a[@href='/portal/client/questionnaires/responses']")
	WebElement tabResponses;

	@FindBy(xpath = "//*[normalize-space()='Questionnaire Type Name']")
	WebElement lblQuestionnaireType;
	@FindBy(xpath = "//th[normalize-space()='Size']")
	WebElement txtArea;
	@FindBy(xpath = "//th[normalize-space()='Created By']")
	WebElement lblCreatedBy;
	@FindBy(xpath = "//th[normalize-space()='Created On']")
	WebElement lblCreatedOn;

	@FindBy(xpath = "//th[normalize-space()='Questionnaire Type Name']//p-sorticon//i")
	WebElement imgFilterQuestionnaireType;
	@FindBy(xpath = "//th[normalize-space()='Size']//p-sorticon//i")
	WebElement imgFilterSize;
	@FindBy(xpath = "//th[normalize-space()='Created By']//p-sorticon//i")
	WebElement imgFilterCreatedBy;
	@FindBy(xpath = "//th[normalize-space()=' Created On ']//p-sorticon//i")
	WebElement imgFilterCreatedOn;

	@FindBy(xpath = "(//input[@aria-label='Search Input'])[1]")
	WebElement txtAreaQuestionnaireType;
	@FindBy(xpath = "(//input[@aria-label='Search Input'])[2]")
	WebElement txtSearchSize;
	@FindBy(xpath = "(//input[@aria-label='Search Input'])[3]")
	WebElement txtAreaCreatedBy;
	@FindBy(xpath = "//span[contains(text(),'ui-btn')]")
	WebElement txtAreaCreatedOn;

	@FindBy(xpath = "//*[@class='fas fa-folder-open']")
	WebElement imgResponseFolder;
	// table[@class='ui-table-scrollable-body-table
	// ui-table-virtual-table']//tr[1]//td[1]
	@FindBy(xpath = "//*[@class='fas fa-columns']")
	WebElement imgResponseDetailedView;
	@FindBy(xpath = "//table[@class='ui-table-scrollable-body-table ui-table-virtual-table']//tr[1]//td[1]")
	WebElement row1col1data;
	@FindBy(xpath = "//button[@id='burgerFilter']")
	WebElement btnMore;
	@FindBy(xpath = "//button[@aria-label='Create Response']")
	WebElement btnCreateResponse;

	// *[text()='Create Response']
	// span[normalize-space()='File(Word)']
	// span[normalize-space()='Questionnaire']
	// div[normalize-space()='Questionnaire Name']
	@FindBy(xpath = "//input[@name='questionnaireName']")
	WebElement txtAreaQuestionnaireName;

	// *[contains(text(),' Please enter questionnaire name ')]
	// div[normalize-space()='Company']

	@FindBy(xpath = "//label[normalize-space()='Select Company']")
	WebElement dropDownSelectCompany;
	@FindBy(xpath = "//input[@class='ui-dropdown-filter ui-inputtext ui-widget ui-state-default ui-corner-all ng-tns-c233-67']]")
	WebElement txtAreaSearchdropDownSelectCompany;

	// *[@id='ui-tabpanel-24']/app-file-tab/div/form/div[3]/div[2]/p-dropdown/div/div[2]
	/*
	 * @FindBy(xpath =
	 * "//*[@id='ui-tabpanel-24']/app-file-tab/div/form/div[3]/div[2]/p-dropdown/div/div[2]")
	 * WebElement dropDownSelectCompany;
	 */

	// *[contains(text(),' Please select a company ')]
	// div[normalize-space()='Contact']
	@FindBy(xpath = "//label[normalize-space()='Select Contact']")
	WebElement dropDownSelectContact;
	@FindBy(xpath = "//input[@class='ui-dropdown-filter ui-inputtext ui-widget ui-state-default ui-corner-all ng-tns-c233-68']")
	WebElement txtAreaSearchdropDownSelectCompanyContact;
	// *[contains(text(),' Import response from word Template. Please download
	// sample template ')]
	@FindBy(xpath = "//a[@href='https://dev-api.diligend.com/ResponseUploadTemplate.docx']")
	WebElement u;
	@FindBy(xpath = "//span[normalize-space()='Choose a file']")
	WebElement chooseAFile;
	@FindBy(xpath = "//button[conatins(text(),'Upload')]")
	WebElement btnUpload;

	/* ********************QR WebElements******************************** */
	// table[@class='ui-table-scrollable-header-table']
	// table[@class='ui-table-scrollable-body-table ui-table-virtual-table']

	@FindBy(xpath = "//table[@class='ui-table-scrollable-body-table ui-table-virtual-table']//tr//td[2]")
	WebElement tableDataQRE1;
	@FindBy(xpath = "//table[@class='response-table ui-table-scrollable-body-table ui-table-virtual-table']//tr//td[2]")
	WebElement tableDataResponseQR1;
	// *[contains(text(),' No records found... ')]
	@FindBy(xpath = "//span[normalize-space()='My Questions']")
	WebElement btnMyQuestions;
	@FindBy(xpath = "//button[normalize-space()='Comment']")
	WebElement btnComment;
	@FindBy(xpath = "//*[contains(text(),'Side View')]")
	WebElement btnSideView;
	@FindBy(xpath = "//button[normalize-space()='Collapse All']")
	WebElement btnCollapseAll;
	@FindBy(xpath = "//button[@tooltipposition='top']//span//i")
	WebElement btnMoreActions;
	@FindBy(xpath = "//button[normalize-space()='Send Assignment Email']")
	WebElement btnSendAssignmentEmail;
	@FindBy(xpath = "//button[normalize-space()='Send Clarification email']")
	WebElement btnSendClarificationEmail;
	@FindBy(xpath = "//button[normalize-space()='Disclaimer']")
	WebElement btnDisclaimer;
	@FindBy(xpath = "//span[normalize-space()='Mark as Reviewed']")
	WebElement lblMarkAsReviewed;
	@FindBy(xpath = "//span[normalize-space()='Response State']")
	WebElement lblResponseState;
	@FindBy(xpath = "//span[normalize-space()='Responded:']")
	WebElement lblResponded;
	@FindBy(xpath = "//*[contains(text(),'Flags #: ')]")
	WebElement lblFlags;

	@FindBy(xpath = "//span[normalize-space()='Apply Automatic Rules']")
	WebElement btnApplyAutomaticRules;
	@FindBy(xpath = "//span[normalize-space()='Apply Data Transfer']")
	WebElement btnApplydataTransfer;
	@FindBy(xpath = "//span[normalize-space()='Allow resubmitting']")
	WebElement btnAllowResubmitting;
	@FindBy(xpath = "//span[normalize-space()='Export']")
	WebElement btnExport;
	@FindBy(xpath = "//span[normalize-space()='Import']")
	WebElement btnImport;
	@FindBy(xpath = "//span[normalize-space()='Generate Report']")
	WebElement btnGenerateReport;
	@FindBy(xpath = "//span[normalize-space()='Create Flagged Findings']")
	WebElement btnCreateFlaggedFindings;
	@FindBy(xpath = "//button[@class='filter-button']//*[name()='svg']")
	WebElement btnFilter;
	@FindBy(xpath = "//button[@ptooltip='To Top']")
	WebElement btnToTop;
	@FindBy(xpath = "//button[@ptooltip='To Bottom']//i")
	WebElement btnToBottom;

	@FindBy(xpath = "//*[text()=' Import Response ']")
	WebElement lblImportResponse;
	@FindBy(xpath = "//*[contains(text(),'Prepare on excel')]")
	WebElement lblImportResponseNote;
	@FindBy(xpath = "//*[contains(text(),'Download example')]")
	WebElement btnDownloadExample;
	@FindBy(xpath = "//label[@for='dateFormat']")
	WebElement lblDateFormat;
	@FindBy(xpath = "(//div[@class='ui-dropdown-trigger ui-state-default ui-corner-right ng-tns-c233-208'])[1]")
	WebElement dropDownDate;
	@FindBy(xpath = "//app-modal[@header='Import Response']//div[1]//i[1]")
	WebElement imgUpload;
	@FindBy(xpath = "//*[text()='Choose a file']")
	WebElement linkChooseaFile;
	@FindBy(xpath = "//button[contains(text(),'Import')]")
	WebElement btnImportResponse;
	@FindBy(xpath = "//*[contains(text(),'Response has been created)]")
	WebElement msgSuccessResponse;

	@FindBy(xpath = "//span[normalize-space()='Export']")
	WebElement btnExportResponse;

	// span[normalize-space()='Filter']
	// button[@class='close-icon filter_header_close']
	// label[normalize-space()='Display']
	// p-dropdown[@id='displayType']//div//div[@role='button']
	public void ResponsePageNavigationQR() {
		try {
			Common.softAssert = new SoftAssert();
			Common.clickElement(QuestionnaireMenu, 0, driver);
			Common.clickElement(row1col1data, 0, driver);
			Common.clickElement(tableDataQRE1, 0, driver);
			Common.clickElement(lblResponses, 0, driver);
			Common.clickElement(tableDataResponseQR1, 0, driver);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Common.softAssert.assertAll();
		}
	}

	public void ResponsePageVerificationQR() throws Exception {
		try {
			Common.softAssert = new SoftAssert();
//			Common.clickElement(QuestionnaireMenu, 0);
//			Common.clickElement(row1col1data, 0);
//			Common.clickElement(tableDataQRE1, 0);
//			Common.clickElement(lblResponses, 0);
//			Common.clickElement(tableDataResponseQR1, 0);
			Common.assertVisible(btnMyQuestions);
			Common.assertVisible(btnComment);
			Common.assertVisible(btnSideView);
			Common.assertVisible(btnCollapseAll);
			Common.assertVisible(btnMoreActions);
			Common.clickElement(btnMoreActions, 0, driver);
			Common.assertVisible(btnSendAssignmentEmail);
			Common.assertVisible(btnSendClarificationEmail);
			Common.assertVisible(btnDisclaimer);
			Common.assertVisible(lblMarkAsReviewed);
			Common.assertVisible(lblResponseState);
			Common.assertVisible(lblResponded);
			Common.assertVisible(lblFlags);
			Common.clickElement(btnMore, 0, driver);
			Common.assertVisible(btnApplyAutomaticRules);
			Common.assertVisible(btnApplydataTransfer);
			Common.assertVisible(btnAllowResubmitting);
			Common.assertVisible(btnExport);
			Common.assertVisible(btnImport);
			Common.assertVisible(btnGenerateReport);
			Common.assertVisible(btnCreateFlaggedFindings);
			Common.assertVisible(btnToTop);
			Common.assertVisible(btnToBottom);
			Common.clickElement(btnToBottom, 0, driver);
			Common.clickElement(btnToTop, 0, driver);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			Common.softAssert.assertAll();
		}
	}

	public void ResponsePageValidationImportResponseQR() throws Exception {
		try {
			Common.softAssert = new SoftAssert();
			Common.clickElement(btnMore, 0, driver);
			Common.clickElement(btnImport, 0 , driver);
			Common.assertVisible(lblImportResponse);
			Common.assertVisible(lblImportResponseNote);
			Common.assertVisible(btnDownloadExample);
			Common.assertVisible(lblDateFormat);
			Common.assertVisible(dropDownDate);
			Common.scrollIntoView(linkChooseaFile , driver);
			// Common.assertVisible(imgUpload);
			Common.clickElement(linkChooseaFile, 0 , driver);
			Common.uploadFile("\\src\\test\\resources\\AutoIT\\Response\\FileUploadResponse.exe");
			Common.assertVisible(btnImportResponse);
			Common.clickElement(btnImportResponse, 0 , driver);
			Common.clickElement(btnExpand, 0, driver);
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Common.softAssert.assertAll();
		}
	}

	@FindBy(xpath = "//div[@class='modal fade in show']//button[@aria-label='Close']")
	WebElement imgexportWindowPopClose;
	@FindBy(xpath = "//button[normalize-space()='Expand All']")
	WebElement btnExpand;

	public void ResponsePageValidationExportResponseQR() {
		try {
			Common.softAssert = new SoftAssert();
			Common.clickElement(btnMore, 0 , driver);
			Common.clickElement(btnExportResponse, 0 , driver);
			// Common.isFileDownloaded(SystemPath +
			// "\\src\\test\\resources\\TestData\\download\\Responses\\ResponsesExportQR","QuestionnaireAutomation");
			// Common.clickElement(imgexportWindowPopClose, 0);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Common.softAssert.assertAll();
		}
	}

	@FindBy(xpath = "//span[normalize-space()='Create Response']")
	WebElement btbCreateResponse;
	@FindBy(xpath = "//*[text()='Name']")
	WebElement chkboxName;

	@FindBy(xpath = "//div[@role='tabpanel']//app-response-company-contact-tab//div//span[contains(text(),'Create')]")
	WebElement btnCreate;

	public void ResponsePagecreatetResponseQR() {
		try {
			Common.softAssert = new SoftAssert();
			Common.clickElement(QuestionnaireMenu, 5 , driver);
			Common.clickElement(row1col1data, 0 , driver);
			Common.clickElement(tableDataQRE1, 0 , driver);
			Common.clickElement(lblResponses, 0 , driver);
			Common.clickElement(btnMore, 0 , driver);
			Common.clickElement(btbCreateResponse, 0 , driver);
			Common.clickElement(chkboxName, 0 , driver);
			Common.clickElement(btnCreate, 0 , driver);
			Thread.sleep(5000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Common.softAssert.assertAll();
		}
	}

	@FindBy(xpath = "//span[normalize-space()='Attachments']")
	WebElement tabAttachments;
	@FindBy(xpath = "//span[normalize-space()='Add File']")
	WebElement btnAddFile;
	@FindBy(xpath = "//label[normalize-space()='File Name']")
	WebElement lblFileName;
	@FindBy(id = "fname")
	WebElement txtAreaFileName;
	// choose s file
	@FindBy(xpath = "//input[@placeholder='Description']")
	WebElement txtAreaDescription;
	// @FindBy(xpath = "//button[normalize-space()='Upload']")
	// WebElement btnUpload;

	public void attachmentsResponseQR() {
		try {
			Common.softAssert = new SoftAssert();
			Common.clickElement(btnMore, 0 , driver);
			Common.clickElement(btnAddFile, 0 , driver);
			Common.assertVisible(QuestionnaireMenu);
			Common.assertVisible(lblFileName);
			Common.assertVisible(txtAreaFileName);
			Common.getcellvalue(Common.getProperty(" ", "EXCEL_PATH_RESPONSE"), "ResponsesQR", 0, 0);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Common.softAssert.assertAll();
		}
	}

	public void ResponsePageValidationFilterQR() {
		try {
			Common.softAssert = new SoftAssert();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Common.softAssert.assertAll();
		}
	}

	public void ResponsePageValidationCommentQR() {
		try {
			Common.softAssert = new SoftAssert();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Common.softAssert.assertAll();
		}
	}

	public void ResponsePageValidationMyqusetionsQR() {
		try {
			Common.softAssert = new SoftAssert();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Common.softAssert.assertAll();
		}
	}

	public void ResponsePageValidationQR() {
		try {
			Common.softAssert = new SoftAssert();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Common.softAssert.assertAll();
		}
	}

	public void ResponsePageIR() throws Exception {
		try {
			Common.softAssert = new SoftAssert();
			QuestionnaireMenu.click();
			Common.clickElement(tabResponses, 0 , driver);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			Common.softAssert.assertAll();
		}
	}

	public void navigationResponsePage() {
		try {
			Common.softAssert = new SoftAssert();
			Common.clickElement(QuestionnaireMenu, 0 , driver);
			Common.clickElement(tabResponses, 0 , driver);
			Assert.assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		} finally {
			Common.softAssert.assertAll();
		}
	}

	public void verificationFolderViewResponsePage() throws Exception {
		try {
			Common.softAssert = new SoftAssert();
			Common.clickElement(imgResponseFolder, 0 , driver);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(lblQuestionnaireType));
			Common.assertVisible(lblQuestionnaireType);
			Common.assertVisible(txtArea);
			Common.assertVisible(lblCreatedBy);
			Common.assertVisible(lblCreatedOn);
			Common.assertVisible(imgFilterQuestionnaireType);
			Common.assertVisible(imgFilterSize);
			Common.assertVisible(txtAreaCreatedBy);
			Common.assertVisible(txtAreaCreatedOn);
			Common.assertVisible(txtAreaQuestionnaireType);
			Common.assertVisible(txtSearchSize);
			Common.assertVisible(txtAreaCreatedBy);
			Common.assertVisible(txtAreaCreatedOn);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			Common.softAssert.assertAll();
		}
	}

	public void verificationDetailedViewResponsePage() throws Exception {
		try {
			Common.softAssert = new SoftAssert();
			// Common.clickElement(imgResponseDetailedView, stockCountReportId);
			// imgResponseDetailedView.click();
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			Common.softAssert.assertAll();
		}
	}

	public void importResponse() throws Exception {
		try {
			Common.softAssert = new SoftAssert();
			Robot robot = new Robot();
			Common.clickElement(row1col1data, 0 , driver);
			Common.clickElement(btnMore, 0 , driver);
			Common.clickElement(btnCreateResponse, 0 , driver);
			txtAreaQuestionnaireName.sendKeys("new");
			Common.clickElement(dropDownSelectCompany, 0 , driver);
			txtAreaSearchdropDownSelectCompany.sendKeys("etisalat");
//			Common.clickElement(txtAreaSearchdropDownSelectCompany, 0);
//			Common.webEditTxtChange(txtAreaSearchdropDownSelectCompany, "etisalat");
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			Common.clickElement(dropDownSelectContact, 0 , driver);
			txtAreaSearchdropDownSelectCompanyContact.sendKeys("Abhilasha Manager");
//			Common.clickElement(txtAreaSearchdropDownSelectCompanyContact, 0);
//			Common.webEditTxtChange(txtAreaSearchdropDownSelectCompanyContact, "abhilasha manager");
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			chooseAFile.sendKeys("/DiligendAppUIAutomation/src/test/resources/TestData/upload/Responses");
			Common.clickElement(btnUpload, 0 , driver);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			Common.softAssert.assertAll();
		}
	}

	public void createResponseWindowVerification() throws Exception {
		try {
			Common.softAssert = new SoftAssert();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			Common.softAssert.assertAll();
		}
	}

	public void exportResponse() throws Exception {
		try {

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {

		}
	}

	public void deleteResponse() throws Exception {
		try {

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {

		}
	}

}
