package com.diligend.PageObjects.ManagerQuestionnairePage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.diligend.BaseClass.DiligendBaseClass;
import com.diligend.BaseEnums.ExportType;
import com.diligend.PageObjects.DiligendClientLoginPage;
import com.diligend.actiondriver.Common;

public class DiligendMNCQuestionnairePage extends DiligendBaseClass {

	WebDriver driver;

	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public DiligendMNCQuestionnairePage(WebDriver d) {
		driver = d;
		PageFactory.initElements(d, this);
	}

	@FindBy(xpath = "//*[@id=\"table-wrapper\"]/p-table/div/div[1]/div/div[1]/div/table/thead/tr[2]/th[2]/app-default-filter/div/app-search-input/div/div[1]/span[2]/i")
	WebElement title_closebtn;

	// Locator for WebElements
	@FindBy(xpath = "//span[@class='nav_title'][normalize-space()='Questionnaires']")
	WebElement Click_QuestionnaireModule;

	@FindBy(id = "filter_search_query_1")
	WebElement title;

	@FindBy(xpath = "//div[@class='questionnaire-invitation-text__wrap']")
	WebElement Qn_invitation;

	@FindBy(css = "tr[id='0'] span[class='blue_label ng-star-inserted']")
	WebElement Select_Record;

	@FindBy(xpath = "//th[normalize-space()='Company Status']")
	WebElement Company_status;

	@FindBy(xpath = "//*[@id=\"0\"]/td[1]/p-tablecheckbox/div/div[2]")
	WebElement Qn_checkbox;

	@FindBy(xpath = "//*[@id=\"burgerFilter\"]/span")
	WebElement More_btn_listPage;
	



	public void QuestionnaireModule() {
		Common.softAssert.assertAll();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(Click_QuestionnaireModule));
			Common.clickElement(Click_QuestionnaireModule, 0, driver);
			wait.until(ExpectedConditions.elementToBeClickable(titleQRE));
			System.out.println("User cicked on Questionnaire Module");
			logger.info("User cicked on Questionnaire Module");
		} catch (Exception e) {
			System.out.println("quesionnaire module is not visible");
			logger.info("quesionnaire module is not visible");
		} finally {
			Common.softAssert.assertAll();
		}
	}

	public void titlefilter() {
		Common.softAssert.assertAll();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		try {
			logger.info("Veifying for Title Filter");
			Common.clickOnlyifExists(Click_QuestionnaireModule, 0, driver);
			wait.until(ExpectedConditions.elementToBeClickable(title));
			Common.clickElement(title, 0, driver);
			title.clear();
			title.sendKeys("Annual DDQ 2022 - CDL II");
		} catch (Exception e) {
			System.out.println("Filter could not found searched questionnaire");
			logger.info("Filter could not found searched questionnaire");

			e.printStackTrace();
		} finally {
			Common.softAssert.assertAll();
		}
	}

	// common methods

	@FindBy(xpath = "//span[normalize-space()='Export']")
	WebElement Export_option;

	@FindBy(xpath = "//div[@class='dropdown-menu ng-star-inserted show']")
	WebElement disable_export;

	@FindBy(css = ".dd-rounded-color-btn.mr-1")
	WebElement Export_button;

	@FindBy(css = ".dd-rounded-color-btn.mr-1")
	WebElement Export_Files;

	@FindBy(xpath = "//*[@id='dropdown_selected_export_format']")
	WebElement Export_DD;

	@FindBy(xpath = "//li[@aria-label='PDF']")
	WebElement PDFExport;

	@FindBy(xpath = "//li[@aria-label='Word']")
	WebElement WordExport;
	@FindBy(xpath = "//li[@aria-label='Excel']")
	WebElement ExcelExport;
	@FindBy(xpath = "//app-modal[@header='Export Response']//div[@role='dialog']//div//div//div//button[@aria-label='Close']")
	WebElement IconCloseQREExport;

	public void CommonExport_method() throws InterruptedException {
		// click on
		Common.softAssert.assertAll();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(Qn_checkbox));
			Common.clickOnlyifExists(disable_export, 5, driver);
			Common.clickElement(Qn_checkbox, 2, driver);
			Common.clickElement(More_btn_listPage, 1, driver);
			Common.clickElement(Export_option, 2, driver);
			wait.until(ExpectedConditions.visibilityOf(titleExportQuestionnaire));
			Common.assertVisible(titleExportQuestionnaire);
			Common.assertVisible(Export_Files);
			Common.pageLoadTimeOut(driver, 10);
			logger.info("Automation script for exporting PDF file : Pass");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("User is not able to export Report");
			logger.info("Automation script for exporting file Failed");
			e.printStackTrace();
		} finally {
			Common.softAssert.assertAll();
		}
	}

	@FindBy(xpath = "//h4[normalize-space()='Export Response']")
	WebElement titleExportQuestionnaire;

	public void ExportPDFMethod(ExportType type) throws InterruptedException {
		Common.softAssert.assertAll();
		try {
			// click on
			CommonExport_method();
			Common.clickElement(Export_DD, 2, driver);
			Common.clickElement(PDFExport, 2, driver);//
			Common.clickElement(Export_Files, 0, driver);
			Common.pageLoadTimeOut(driver, 10);
			logger.info("Automation script for exporting PDF file : Pass");
		} catch (Exception e) {
			System.out.println("User is not able to export Report");
			logger.info("Automation script for exporting file" + type + ": Failed");
			e.printStackTrace();
		} finally {
			Common.softAssert.assertAll();
			System.out.println("Exported questionnaire to" + type + "sucessfully");
		}
	}
	@FindBy(xpath = "//*[contains(text(),'Cancel')]")
	WebElement btnCancelQreListExport;
	
	public void ExportWordMethod(ExportType type) throws InterruptedException {
		Common.softAssert.assertAll();
		try {
			CommonExport_method();
			Common.clickElement(Export_DD, 0, driver);
			Common.clickElement(WordExport, 0, driver);
			Common.clickElement(Export_Files, 0, driver);
			Common.pageLoadTimeOut(driver, 10);
			Common.assertVisibleOnlyifExists(btnCancelQreListExport);
			logger.info("Automation script for exporting Word file : Pass");
		} catch (Exception e) {
			System.out.println("User is not able to export Report");
			logger.info("Automation script for exporting file" + type + ": Failed");
			e.printStackTrace();
		} finally {
			Common.softAssert.assertAll();
			System.out.println("Exported questionnaire to" + type + "sucessfully");
		}
	}

	public void ExportExcelMethod(ExportType type) throws InterruptedException {
		Common.softAssert.assertAll();
		try {
			CommonExport_method();
			Common.clickElement(Export_DD, 0, driver);
			Common.clickElement(ExcelExport, 0, driver);//
			Common.clickElement(Export_Files, 0, driver);
			Common.pageLoadTimeOut(driver, 10);
			logger.info("Automation script for exporting Excel file : Pass");
		} catch (Exception e) {
			System.out.println("User is not able to export Report");
			logger.info("Automation script for exporting file" + type + ": Failed");
			e.printStackTrace();
		} finally {
			Common.softAssert.assertAll();
			System.out.println("Exported questionnaire to" + type + "sucessfully");
		}
	}

	@FindBy(xpath = "//span[@class='blue_label ng-star-inserted']")
	WebElement nameQuestionnaire;
	@FindBy(xpath = "//div[@class='ng-tns-c290-69 deep-level-0 qp-row__title text-break-all is-section']")
	WebElement Responsepage;
	@FindBy(xpath = "(//*[@id=\"burgerFilter\"]/span")
	WebElement MoreButton_QnPage;

	/*
	 * @description : Used to verify Import Previous answer Abbreviation:MNC-
	 * Manager non client
	 * 
	 * @param : NA
	 * 
	 * @return : NA
	 * 
	 * @author : Pooja
	 * 
	 * @date: 20 Oct 2022
	 */

	// import Response
	@FindBy(xpath = "//span[normalize-space()='Import']")
	WebElement Import_responseQRE;
	@FindBy(css = ".app-modal-body.ng-tns-c305-23.ng-star-inserted")
	WebElement import_popup;
	@FindBy(xpath = "//*[text()='Choose a file']")
	WebElement linkChooseaFile_import;
	@FindBy(xpath = "//button[contains(text(),'Import')]")
	WebElement btnImportResponse;
	@FindBy(xpath = "//*[contains(text(),'Response has been created)]")
	WebElement msgSuccessResponse;
	@FindBy(xpath = "//div[@class='modal fade in show']//button[@aria-label='Close']")
	WebElement close_popup;
	@FindBy(xpath = "//button[normalize-space()='Expand All']")
	WebElement btnExpand;
	@FindBy(xpath = "//div[@class='modal fade in show']//button[@aria-label='Close']")
	WebElement closeiconImportPopup;

	public void ResponsepageImport() throws Exception {
		Common.softAssert = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			driver.navigate().refresh();
			logger.info("Importing qusetionnaire response");
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(btnMore));
			Common.clickElement(btnMore, 0, driver);
			wait.until(ExpectedConditions.visibilityOf(Import_responseQRE));
			Common.clickElement(Import_responseQRE, 2, driver);
			wait.until(ExpectedConditions.elementToBeClickable(linkChooseaFile_import));
			Common.clickElement(linkChooseaFile_import, 5, driver);
			Common.uploadFile("\\src\\test\\resources\\AutoIT\\Manager\\ManagerResponse.exe");
			wait.until(ExpectedConditions.elementToBeClickable(btnImportResponse));
			Common.clickElement(btnImportResponse, 0, driver);
			Common.clickOnlyifExists(closeiconImportPopup, 0, driver);
		} catch (Exception e) {
			System.out.println("quesionnaire module is not visible");
			e.printStackTrace();
		} finally {
			Common.softAssert.assertAll();
		}
	}

	/*
	 * @description : Used to verify Export response Abbreviation:MNC- Manager non
	 * client
	 * 
	 * @param : NA
	 * 
	 * @return : NA
	 * 
	 * @author : Pooja
	 * 
	 * @date: 20 Oct 2022
	 */

	@FindBy(xpath = "//span[normalize-space()='Export']")
	WebElement ExportQRE;
	@FindBy(xpath = "//h4[normalize-space()='Export Response']")
	WebElement titleExportPopup;
	@FindBy(xpath = "//label[@for='checkbox_table_included-input']//span[@class='mat-checkbox-inner-container']")
	WebElement Export_includeTables;
	@FindBy(xpath = "//label[@for='checkbox_file_included-input']//span[@class='mat-checkbox-inner-container']")
	WebElement Export_includeAttachments;
	@FindBy(xpath = "//div[@role='dialog']/div//button[contains(text(),'Export')]")
	WebElement Export_popupQRE;
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement cancel_popupQRE;
	@FindBy(xpath = "//div[@class='modal fade in show']//button[@aria-label='Close']")
	WebElement close_exportpopup;

	public void ExportResponsepage() throws Exception {
		Common.softAssert = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			Common.clickElement(btnMore, 5, driver);
			Common.clickElement(ExportQRE, 5, driver);
			wait.until(ExpectedConditions.visibilityOf(titleExportPopup));
			Common.assertVisible(titleExportPopup);
			Common.clickElement(Export_includeTables, 0, driver);
			Common.clickElement(Export_includeAttachments, 0, driver);
			Common.clickElement(Export_popupQRE, 3, driver);
			Common.clickOnlyifExists(close_exportpopup, 0, driver);
		} catch (Exception e) {
			System.out.println("unable to execute code for Questionnaire export");
			e.printStackTrace();
		} finally {
			Common.softAssert.assertAll();
		}
	}

	/*
	 * @description : Used to verify copy previous answer Abbreviation:MNC- Manager
	 * non client
	 * 
	 * @param : NA
	 * 
	 * @return : NA
	 * 
	 * @author : Pooja
	 * 
	 * @date: 19 Oct 2022
	 */

	@FindBy(xpath = "//span[normalize-space()='Use previous answer']")
	WebElement UsepreviousAns_btn;
	@FindBy(css = ".col.p-0.questionnaire-container.ng-tns-c301-13.ng-trigger.ng-trigger-slideAnimation.ng-star-inserted")
	WebElement previousQRE;
	@FindBy(xpath = "(//tr//td//p-radiobutton)[1]")
	WebElement previousQRESelectRadio;
	@FindBy(xpath = "//button[normalize-space()='Apply']")
	WebElement useApplybtn;
	@FindBy(xpath = "//button[normalize-space()='Copy All']")
	WebElement CopyAllbtn;
	@FindBy(xpath = "//img[@alt='warning icon']")
	WebElement WarringIcon;
	@FindBy(xpath = "//li[@class='ng-star-inserted']")
	WebElement read_popupMessage;
	@FindBy(xpath = "//button[normalize-space()='Yes']")
	WebElement popup_yes;
	@FindBy(xpath = "//button[normalize-space()='No']")
	WebElement popup_No;
	@FindBy(xpath = "//button[normalize-space()='Back']")
	WebElement Backbtn;

	public void UsePrevious_Answer() {
		Common.softAssert = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		try {
			driver.navigate().refresh();
			logger.info("Validating previous answer from manager side");
			wait.until(ExpectedConditions.visibilityOf(btnMore));
			Common.clickElement(btnMore, 5, driver);
			wait.until(ExpectedConditions.visibilityOf(UsepreviousAns_btn));
			Common.clickElement(UsepreviousAns_btn, 5, driver);
			Common.clickElement(previousQRESelectRadio, 5, driver);
			Common.scrollIntoView(useApplybtn, driver);
			Common.clickElement(useApplybtn, 5, driver);
			wait.until(ExpectedConditions.visibilityOf(CopyAllbtn));
			Common.clickElement(CopyAllbtn, 5, driver);
			wait.until(ExpectedConditions.visibilityOf(popup_yes));
			Common.clickOnlyifExists(popup_yes, 0, driver);
			Common.clickOnlyifExists(popup_No, 2, driver);
			Common.clickOnlyifExists(Backbtn, 2, driver);
		} catch (Exception e) {
			System.out.println("Automation script failed for use previous answer");
			e.printStackTrace();
		} finally {
			Common.softAssert.assertAll();
		}
	}

	/*
	 * @description : Used to verify Generate Report Abbreviation:MNC- Manager non
	 * client
	 * 
	 * @param : NA
	 * 
	 * @return : NA
	 * 
	 * @author : Pooja
	 * 
	 * @date: 20 Oct 2022
	 */

	@FindBy(xpath = "//span[normalize-space()='Generate Report']")
	WebElement GenerateReport;
	@FindBy(css = ".app-modal-body.ng-tns-c301-13.ng-star-inserted")
	WebElement GenerateReport_popup;
	@FindBy(xpath = "//span[normalize-space()='Word']")
	WebElement Generate_word;
	@FindBy(xpath = "//span[normalize-space()='Excel']")
	WebElement Generate_excel;
	@FindBy(xpath = "//span[normalize-space()='PDF']")
	WebElement Generate_Pdf;
	@FindBy(css = ".ui-dropdown-trigger-icon.ui-clickable.ng-tns-c159-47.pi.pi-chevron-down")
	WebElement Generate_DD;
	@FindBy(xpath = "//span[@class='mat-checkbox-inner-container']")
	WebElement Generate_includeAttach;

	@FindBy(xpath = "//tr[1]//td[2]")
	WebElement nameQuestionnaire1;
	@FindBy(xpath = "//td[1]")
	WebElement columns;
	@FindBy(xpath = "//tr[1]")
	WebElement rows;
	@FindBy(xpath = "//input[@class='search-input-control ng-pristine ng-valid ng-touched']")
	WebElement txtAreaTitle;
	@FindBy(xpath = "//button[normalize-space()='Accept']")
	WebElement btnInvitationAccept;
	@FindBy(xpath = "//button[normalize-space()='Reject']")
	WebElement btnInvitationReject;
	@FindBy(xpath = "//span[@class='reset ng-star-inserted']")
	WebElement ResetFilter;

	/*
	 * @description : Used to navigate from questionnaire invitation list to
	 * response page Abbreviation:MNC- Manager non client
	 * 
	 * @param : NA
	 * 
	 * @return : NA
	 * 
	 * @author : Abhilasha
	 * 
	 * @date: 04 Oct 2022
	 */
	public void MNCQuestionnaireNavigation() throws Exception {
		Common.softAssert = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try {
			driver.navigate().refresh();
			wait.until(ExpectedConditions.visibilityOf(nameQuestionnaire1));
			Common.clickElement(nameQuestionnaire1, 5, driver);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Common.softAssert.assertAll();
		}
	}

	@FindBy(xpath = "//span[@tooltipposition='top'][normalize-space()='Questionnaires']")
	WebElement titleQRE;
	@FindBy(xpath = "//span[@class='ng-star-inserted']")
	WebElement nameQRE;
	@FindBy(xpath = "//span[normalize-space()='Questionnaire']")
	WebElement tabQRE;
	@FindBy(xpath = "//span[normalize-space()='Attachments']")
	WebElement tabAttachment;
	@FindBy(xpath = "//span[normalize-space()='Reference Documents']")
	WebElement tabRefDoc;
	@FindBy(xpath = "//span[normalize-space()='Q/A']")
	WebElement tabQA;

	@FindBy(xpath = "//div[@class='timer']")
	WebElement dateDeadline;
	@FindBy(xpath = "//app-filter[1]")
	WebElement iconFilter;
	@FindBy(xpath = "//div[@class='timer animated infinite']")
	WebElement lbltimeLeft;
	@FindBy(xpath = "//img[@class='question-mark-icons']")
	WebElement lblNeedHelp;
	@FindBy(xpath = "//img[@id='notifyButton']")
	WebElement btnNotify;

	@FindBy(xpath = "//span[normalize-space()='Responded']")
	WebElement barResonse;
	@FindBy(xpath = "//button[normalize-space()='Send Assignment Email']")
	WebElement btnSendAssignEmail;
	@FindBy(xpath = "//button[normalize-space()='Send clarification Email']")
	WebElement btnSendClariEmail;
	@FindBy(xpath = "//button[normalize-space()='Open Disclaimer']")
	WebElement btnDisclaimer;
	@FindBy(xpath = "//p[normalize-space()='Expand All']")
	WebElement btnExpandAll;
	@FindBy(xpath = "//button[normalize-space()='Add Colleagues']")
	WebElement btnAddColleagues;
	@FindBy(xpath = "//button[contains(text(),'Export')]")
	WebElement btnExport;
	@FindBy(xpath = "//span[normalize-space()='My Questions']")
	WebElement btnMyQuestions;
	@FindBy(xpath = "//*[text()='Side View']")
	WebElement btnSideView;

	@FindBy(xpath = "//*[contains(text(),'Select Section')]")
	WebElement lblSelectSec;

	@FindBy(id = "sectionSelector")
	WebElement ddSection;
	@FindBy(xpath = "//label[normalize-space()='Select Product/Company']")
	WebElement lblSelectProdComp;
	@FindBy(xpath = "//*[@id='responseView']")
	WebElement ddProdComp;

	@FindBy(xpath = "//span[normalize-space()='Auto Save is active.']")
	WebElement lblAutoSave;
	@FindBy(xpath = "//span[normalize-space()='Know More']")
	WebElement lnkKnowMore;
	@FindBy(xpath = "//button[normalize-space()='Submit']")
	WebElement btnSubmit;
	@FindBy(xpath = "//button[normalize-space()='Sign & Submit']")
	WebElement btnSignSubmit;
	@FindBy(xpath = "//button[@ptooltip='To Top']")
	WebElement iconToTop;
	@FindBy(xpath = "//button[@ptooltip='To Bottom']")
	WebElement iconToBottom;
	@FindBy(xpath = "//span[normalize-space()='More']")
	WebElement btnMore;
	@FindBy(xpath = "//span[normalize-space()='Deadline has expired']")
	WebElement lblDealineExpire;
	@FindBy(xpath = "//img[@alt='close']")
	WebElement imgDeadlineExpireCliseIcon;

	/*
	 * @description : Used to verify all the displayed elements on response web page
	 * Abbreviation:MNC- Manager non client
	 * 
	 * @param : NA
	 * 
	 * @return : NA
	 * 
	 * @author : Abhilasha
	 * 
	 * @date: 07 Oct 2022
	 */
	public void MNCQuestionnaireVerification() throws Exception {
		Common.softAssert = new SoftAssert();
		try {
			
			logger.info("Validating webelemnet inside Questionnaire/Response page");
			Common.assertVisibleOnlyifExists(lblDealineExpire);
			Common.clickOnlyifExists(imgDeadlineExpireCliseIcon, 0, driver);
			Common.assertVisibleOnlyifExists(lblMultipleManagersWorking);
			Common.assertVisible(titleQRE);
			Common.assertVisible(nameQRE);
			Common.assertVisible(iconFilter);
			Common.assertVisible(tabQRE);
			Common.assertVisible(tabAttachment);
			Common.assertVisible(tabRefDoc);
			Common.assertVisible(tabQA);
			Common.assertVisible(dateDeadline);
			Common.assertVisibleOnlyifExists(lbltimeLeft);
			Common.assertVisible(lblNeedHelp);
			Common.assertVisible(btnNotify);
			Common.assertVisible(barResonse);
			Common.assertVisible(btnSendAssignEmail);
			Common.assertVisible(btnSendClariEmail);
			Common.assertVisible(btnDisclaimer);
			Common.assertVisible(btnExpandAll);
			Common.assertVisible(btnAddColleagues);
			Common.assertVisible(btnExport);
			Common.assertVisible(btnMyQuestions);
			Common.assertVisibleOnlyifExists(btnSideView);
			Common.assertVisible(lblSelectSec);
			Common.assertVisibleOnlyifExists(ddSection);
			Common.assertVisibleOnlyifExists(ddProdComp);
			Common.clickElement(lblAutoSave, 0, driver);
			Common.assertVisible(lnkKnowMore);
			Common.assertVisibleOnlyifExists(btnSubmit);
			Common.assertVisibleOnlyifExists(btnSignSubmit);
			Common.assertVisible(iconToTop);
			Common.assertVisible(iconToBottom);
			Common.assertVisible(btnMore);
			Common.clickOnlyifExists(btnExpandAll, 5, driver);
			Common.clickElement(iconToBottom, 5, driver);
			Common.implicitWait(driver, 10);
			Common.clickElement(iconToTop, 5, driver);
			Common.implicitWait(driver, 10);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Common.softAssert.assertAll();
		}
	}

	@FindBy(xpath = "//label[normalize-space()='Also working here at the moment:']")
	WebElement lblMultipleManagersWorking;

	/*
	 * @description : Used to verify whether multiple managers are working for the
	 * same questionniare Abbreviation:MNC- Manager non client
	 * 
	 * @param : NA
	 * 
	 * @return : NA
	 * 
	 * @author : Abhilasha
	 * 
	 * @date: 10 Oct 2022
	 */
	public void MNCMultipleManagersWorkingValidation() throws Exception {
		Common.softAssert = new SoftAssert();
		try {	
			logger.info("Validating Multiple user icon on response screen");
			Common.assertVisibleOnlyifExists(lblMultipleManagersWorking);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Common.softAssert.assertAll();
		}
	}

	@FindBy(xpath = "//span[normalize-space()='Add File']")
	WebElement btnAddFile;
	@FindBy(xpath = "//span[normalize-space()='Download']")
	WebElement btndownloadAttachments;
	@FindBy(xpath = "//span[normalize-space()='Add File']")
	WebElement btndelete;

	// *[normalize-space()='File']
	// label[normalize-space()='File Name']
	@FindBy(xpath = "//input[@id='fname']")
	WebElement nameFile;
	@FindBy(xpath = "//th[@role='columnheader']//p-tableheadercheckbox//div//div[@role='checkbox']")
	WebElement chkboxSelAll;
	@FindBy(xpath = "//div[@id='floating-menu']//div[3]")
	WebElement floatingAttachmentsCount;
	// label[normalize-space()='File']
	// label[normalize-space()='Description']
	// input[@id='document_data_description']
	private String string;

	/*
	 * @description : Used to verify the tab Attachments Abbreviation:MNC- Manager
	 * non client
	 * 
	 * @param : NA
	 * 
	 * @return : NA
	 * 
	 * @author : Abhilasha
	 * 
	 * @date: 10 Oct 2022
	 */
	public void MNCtabAttachmentsVerification() throws Exception {
		Common.softAssert = new SoftAssert();
		try {
			logger.info("Verifying response attchment tab");
			Common.clickOnlyifExists(tabAttachment, 0, driver);
			if (chkboxSelAll.isEnabled()) {
				Common.clickElement(chkboxSelAll, 0, driver);
				String string = driver.findElement(By.xpath("//div[@id='floating-menu']//div[3]")).getText().toString();
				extentLog.log(Status.INFO,
						MarkupHelper.createLabel("Number of attachement records:" + string, ExtentColor.GREEN));
				// System.out.println("Number of attachement records:"+ string);
				Common.clickElement(btnMore, 0, driver);
				Common.assertVisible(btnAddFile);
				Common.assertVisible(btndownloadAttachments);
				Common.assertVisible(btndelete);
				Common.clickElement(btnMore, 0, driver);
				Common.clickOnlyifExists(chkboxSelAll, 0, driver);
			} else {
				extentLog.log(Status.INFO, MarkupHelper.createLabel("No files records were found:", ExtentColor.GREEN));
				System.out.println("No files records were found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Common.softAssert.assertAll();
		}
	}

	@FindBy(xpath = "//*[text()='Choose a file']")
	WebElement linkChooseaFile;
	@FindBy(xpath = "//button[normalize-space()='Upload']")
	WebElement btnUpload;
	@FindBy(xpath = "//div[@class='modal fade in show']//button[@aria-label='Close']")
	WebElement btnCloseUploadPopup;

	/*
	 * @description : Used to navigate to the tab Attachments, Abbreviation:MNC-
	 * Manager non client
	 * 
	 * @param : NA
	 * 
	 * @return : NA
	 * 
	 * @author : Abhilasha
	 * 
	 * @date: 23 DEC 2022
	 */
	public void MNCtabAttachmentsNavigation() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Common.softAssert = new SoftAssert();
		try {
			logger.info("Validating Response export from response page");
			Common.clickElement(tabAttachment, 0, driver);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Common.softAssert.assertAll();
		}
	}

	/*
	 * @description : Used tImport the files under the tab Attachments,
	 * Abbreviation:MNC- Manager non client
	 * 
	 * @param : NA
	 * 
	 * @return : NA
	 * 
	 * @author : Abhilasha
	 * 
	 * @date: 10 Oct 2022
	 */
	public void MNCtabAttachmentsImport() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Common.softAssert = new SoftAssert();
		try {
			logger.info("Validating Response export from response page");
			Common.clickElement(tabAttachment, 0, driver);
			String exeTime = new SimpleDateFormat("yyyyMMMdd_hh.mma").format(new Date());
			Common.clickElement(btnMore, 0, driver);
			Common.clickElement(btnAddFile, 0, driver);
			wait.until(ExpectedConditions.visibilityOf(nameFile));
			Common.webEditTxtChange(nameFile, exeTime + "File");
			Common.clickElement(linkChooseaFile, 10, driver);
			Common.uploadFile("\\src\\test\\resources\\AutoIT\\MNCAttachments\\MNCAttachmentFile.exe");
			wait.until(ExpectedConditions.elementToBeClickable(btnUpload));
			Common.clickElement(btnUpload, 0, driver);
			Common.clickOnlyifExists(btnCloseUploadPopup, 0, driver);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Common.softAssert.assertAll();
		}
	}
	// span[normalize-space()='item selected']

	@FindBy(xpath = "//tr[2]//td[1]")
	WebElement chkboxSelectAll;
	@FindBy(xpath = "//span[normalize-space()='Download']")
	WebElement btnDownload;
	@FindBy(xpath = "(//button[@ptooltip='Download File'])[1]")
	WebElement btnDownload1;

	@FindBy(xpath = "//span[normalize-space()='Download']")
	WebElement btndownload;

	/*
	 * @description : Used to download the files under the tab Attachments,
	 * Abbreviation:MNC- Manager non client
	 * 
	 * @param : NA
	 * 
	 * @return : NA
	 * 
	 * @author : Abhilasha
	 * 
	 * @date: 10 Oct 2022
	 */
	public void MNCAttachmenstdownload() throws Exception {
		Common.softAssert = new SoftAssert();
		try {
			logger.info("Validating response attachment tab download");
			Common.clickElement(chkboxSelAll, 0, driver);
			Common.clickElement(btnMore, 0, driver);
			Common.clickElement(btndownload, 5, driver);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Common.softAssert.assertAll();
		}
	}

	public void Common_Response_GenrateReport() throws Exception {
		Common.softAssert.assertAll();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnMore));
			Common.clickElement(btnMore, 0, driver);
			Common.clickElement(Export_option, 2, driver);
			Common.assertVisible(Export_Files);
			Common.pageLoadTimeOut(driver, 10);
			logger.info("Automation script for exporting PDF file : Pass");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("User is not able to export Report");
			logger.info("Automation script for exporting file Failed");
			e.printStackTrace();
		} finally {
			Common.softAssert.assertAll();
		}
	}

	public void pdf(ExportType type) throws InterruptedException {
		Common.softAssert.assertAll();
		try {
			CommonExport_method();
			Common.clickElement(Export_DD, 2, driver);
			Common.clickElement(PDFExport, 2, driver);
			Common.clickElement(Export_Files, 0, driver);
			Common.pageLoadTimeOut(driver, 10);
			logger.info("Automation script for exporting PDF file : Pass");
		} catch (Exception e) {
			System.out.println("User is not able to export Report");
			logger.info("Automation script for exporting file" + type + ": Failed");
			e.printStackTrace();
		} finally {

			Common.softAssert.assertAll();
			System.out.println("Exported questionnaire to" + type + "sucessfully");
		}
	}

	public void word(ExportType type) throws InterruptedException {
		Common.softAssert.assertAll();
		try {
			CommonExport_method();
			Common.clickElement(Export_DD, 0, driver);
			Common.clickElement(WordExport, 0, driver);
			Common.clickElement(Export_Files, 0, driver);
			Common.pageLoadTimeOut(driver, 10);
			logger.info("Automation script for exporting Word file : Pass");

		} catch (Exception e) {
			System.out.println("User is not able to export Report");
			logger.info("Automation script for exporting file" + type + ": Failed");
			e.printStackTrace();
		} finally {

			Common.softAssert.assertAll();
			System.out.println("Exported questionnaire to" + type + "sucessfully");
		}
	}

	public void excel(ExportType type) throws InterruptedException {
		Common.softAssert.assertAll();
		try {
			CommonExport_method();
			Common.clickElement(Export_DD, 0, driver);
			Common.clickElement(ExcelExport, 0, driver);//
			Common.clickElement(Export_Files, 0, driver);
			Common.pageLoadTimeOut(driver, 10);
			logger.info("Automation script for exporting Excel file : Pass");

		} catch (Exception e) {
			System.out.println("User is not able to export Report");
			logger.info("Automation script for exporting file" + type + ": Failed");
			e.printStackTrace();
		} finally {

			Common.softAssert.assertAll();
			System.out.println("Exported questionnaire to" + type + "sucessfully");
		}
	}

	@FindBy(xpath = "//span[normalize-space()='Delete']")
	WebElement btnDelete;
	@FindBy(xpath = "//div[contains(text(),'Are you sure you want to delete the File?')]")
	WebElement msgConfirmationDelete;
	@FindBy(xpath = "//button[normalize-space()='Yes']")
	WebElement btnConfirmationYes;
	@FindBy(xpath = "//button[normalize-space()='No']")
	WebElement btnConfirmationNo;
	@FindBy(xpath = "//h4[normalize-space()='Delete File']")
	WebElement TitleDeleteFile;

	@FindBy(xpath = "//*[conatins(text(),'File has been deleted')]")
	WebElement msgSuccessDeleteAttachments;
//	/File has been uploaded

	/*
	 * @description : Used to delete the files under attachments tab,
	 * Abbreviation:MNC- Manager non client
	 * 
	 * @param : NA
	 * 
	 * @return : NA
	 * 
	 * @author : Abhilasha
	 * 
	 * @date: 23 DEC 2022
	 */
	public void MNCAttachmenstDelete() throws Exception {
		Common.softAssert = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			logger.info("Validating response attachment tab delete functionaity");
			Common.clickElement(btnMore, 0, driver);
			Common.clickElement(btnDelete, 0, driver);
			wait.until(ExpectedConditions.visibilityOf(msgConfirmationDelete));
			Common.assertVisible(msgConfirmationDelete);
			Common.assertVisible(btnConfirmationNo);
			Common.assertVisible(TitleDeleteFile);
			Common.clickOnlyifExists(btnConfirmationYes, 0, driver);
			Thread.sleep(10000);
			// Common.assertVisibleOnlyifExists(msgSuccessDeleteAttachments);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Common.softAssert.assertAll();
		}
	}

	@FindBy(xpath = "//span[normalize-space()='Generate Report']")
	WebElement btnGenerateReport;
	@FindBy(xpath = "//h4[normalize-space()='Generate Report']")
	WebElement titleGenerateReportPopup;
	@FindBy(xpath = "//label[normalize-space()='Questionnaire']")
	WebElement lblQuestionnaireGenerateReportPopup;
	@FindBy(xpath = "//label[normalize-space()='Export Format']")
	WebElement lblExportFormatGenerateReportPopup;
	@FindBy(xpath = "//*[contains(text(),'Include Attachment')]")
	WebElement chkBoxGenearteReportIncludeAttachments;
	@FindBy(xpath = "//p-dropdown[@inputid='selected_export_report_format']")
	WebElement ddReportFormat;
	@FindBy(xpath = "(//button[contains(text(),'Export')])[2]")
	WebElement btnExportGenerateReortPopup;
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement btnCancelGenerateReortPopup;
	@FindBy(xpath = "//app-modal[@header='Generate Report']//div[@role='dialog']//div//div//div//button[@aria-label='Close']")
	WebElement CloseIconGenerateReportPopup;
	@FindBy(xpath = "//span[normalize-space()='PDF']")
	WebElement ddOptionPDF;
	@FindBy(xpath = "//span[normalize-space()='Word']")
	WebElement ddOptionWord;

	/*
	 * @description : Used to generate the response from manager side in PDF format,
	 * Abbreviation:MNC- Manager non client
	 * 
	 * @param : NA
	 * 
	 * @return : NA
	 * 
	 * @author : Abhilasha
	 * 
	 * @date: 23 DEC 2022
	 */
	public void MNCEResponseGenerateReportPDF() {
		Common.softAssert = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			logger.info("Genearte response report started");
			Common.clickElement(btnMore, 0, driver);
			Common.clickElement(btnGenerateReport, 0, driver);
			wait.until(ExpectedConditions.visibilityOf(titleGenerateReportPopup));
			Common.assertVisible(titleGenerateReportPopup);
			Common.assertVisible(lblQuestionnaireGenerateReportPopup);
			Common.assertVisible(lblExportFormatGenerateReportPopup);
			Common.clickElement(chkBoxGenearteReportIncludeAttachments, 0, driver);
			Common.assertVisible(ddReportFormat);
			Common.clickElement(btnExportGenerateReortPopup, 0, driver);
			logger.info("Pdf report genearted");
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Common.softAssert.assertAll();
		}
	}

	/*
	 * @description : Used to generate the response from manager side in word
	 * format, Abbreviation:MNC- Manager non client
	 * 
	 * @param : NA
	 * 
	 * @return : NA
	 * 
	 * @author : Abhilasha
	 * 
	 * @date: 23 DEC 2022
	 */
	public void MNCEResponseGenerateReportWORD() {
		Common.softAssert = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			logger.info("Genearte response report started");
			Common.clickElement(btnMore, 0, driver);
			Common.clickElement(btnGenerateReport, 0, driver);
			wait.until(ExpectedConditions.visibilityOf(titleGenerateReportPopup));
			Common.assertVisible(titleGenerateReportPopup);
			Common.assertVisible(lblQuestionnaireGenerateReportPopup);
			Common.assertVisible(lblExportFormatGenerateReportPopup);
			Common.clickElement(chkBoxGenearteReportIncludeAttachments, 0, driver);
			Common.clickElement(ddReportFormat, 5, driver);
			wait.until(ExpectedConditions.visibilityOf(ddOptionWord));
			Common.clickElement(ddOptionWord, 0, driver);
			wait.until(ExpectedConditions.visibilityOf(btnExportGenerateReortPopup));
			Common.clickElement(btnExportGenerateReortPopup, 0, driver);
			logger.info("Word report genearted");
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Common.softAssert.assertAll();
		}
	}

	@FindBy(xpath = "//div[contains(text(),'No records found')]")
	WebElement lblNoRecordsFound;
	@FindBy(xpath = "(//*[contains(text(),'Files')])[2]")
	WebElement titleFiles;

	/*
	 * @description : Used to validate Referenece Documents Validation
	 * Abbreviation:MNC- Manager non client
	 * 
	 * @param : NA
	 * 
	 * @return : NA
	 * 
	 * @author : Abhilasha
	 * 
	 * @date: 04 JAN 2023
	 */
	public void MNCERefereneceDocumentsValidation() {
		Common.softAssert = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			logger.info("Referenece documents tab navigation started");
			wait.until(ExpectedConditions.visibilityOf(tabRefDoc));
			Common.clickOnlyifExists(tabRefDoc, 10, driver);
			wait.until(ExpectedConditions.visibilityOf(titleFiles));
			if (driver.findElement(By.xpath("//tr//td")).isDisplayed()) {
				List<WebElement> row = driver.findElements(By.xpath("//table//tbody//tr"));
				int rowcount = row.size();
				for (int i = 1; i <= rowcount; i++) {
					List<WebElement> col = driver.findElements(By.xpath("//table//tbody//tr[" + i + "]//td"));
					for (int j = 1; j <= col.size(); j++) {
						String filename = driver.findElement(By.xpath("//table//tbody//tr[" + i + "]//td[" + j + "]"))
								.getText();
						logger.info("Referenec documents names: " + filename);
						extentLog.log(Status.PASS,
								MarkupHelper.createLabel("File name is:" + filename, ExtentColor.GREEN));
						break;
					}
				}
			}

		} catch (Exception e) {
			if (lblNoRecordsFound.isDisplayed()) {
				logger.info("No Referenece documents found for the selected questionnaire");
				extentLog.log(Status.PASS,
						MarkupHelper.createLabel(
								lblNoRecordsFound + " - No Referenece documents found for the selected questionnaire",
								ExtentColor.GREEN));
			}
		} finally {
			logger.info("Referenece document tab validation ended");
			Common.softAssert.assertAll();
		}
	}

	/*
	 * @description : Used to validate QA tab Validation Abbreviation:MNC- Manager
	 * non client
	 * 
	 * @param : NA
	 * 
	 * @return : NA
	 * 
	 * @author : Abhilasha
	 * 
	 * @date: 04 JAN 2023
	 */
	public void MNCQAtabValidation() {
		Common.softAssert = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			logger.info("QA tab navigation started");
			wait.until(ExpectedConditions.visibilityOf(tabQA));
			Common.clickOnlyifExists(tabQA, 10, driver);
			wait.until(ExpectedConditions.visibilityOf(btnMore));
			if (driver.findElement(By.xpath("//tr//td")).isDisplayed()) {
				List<WebElement> row = driver.findElements(By.xpath("//table//tbody//tr"));
				int rowcount = row.size();
				for (int i = 1; i <= rowcount; i++) {
					List<WebElement> col = driver.findElements(By.xpath("//table//tbody//tr[" + i + "]//td"));
					for (int j = 1; j <= col.size(); j++) {
						String qusetionname = driver
								.findElement(By.xpath("//table//tbody//tr[" + i + "]//td[" + j + "]")).getText();
						String qaLastMessage = driver
								.findElement(By.xpath("//table//tbody//tr[" + i + "]//td[" + (j + 4) + "]")).getText();
						logger.info("qusetion name with last message is-" + qusetionname + ":" + qaLastMessage);
						extentLog.log(Status.PASS,
								MarkupHelper.createLabel(
										"qusetion name with last message is-" + qusetionname + ":" + qaLastMessage,
										ExtentColor.GREEN));
						break;
					}
				}
			}

		} catch (Exception e) {
			if (lblNoRecordsFound.isDisplayed()) {
				logger.info("No QA records found for the selected questionnaire");
				extentLog.log(Status.PASS,
						MarkupHelper.createLabel(
								lblNoRecordsFound + " - No QA records found for the selected questionnaire",
								ExtentColor.GREEN));
			}
		} finally {
			logger.info("QA tab validation ended");

			Common.softAssert.assertAll();
		}
	}

	/*
	 * @description : This is a common method Used to validate Company status, and
	 * navigating inside corresponding questionnaire Abbreviation:MNC- Manager non
	 * client
	 * 
	 * @param : Company status text
	 * 
	 * @return : NA
	 * 
	 * @author : Abhilasha
	 * 
	 * @date: 04 JAN 2023
	 */
	public void MNCQuestionnaireCompanyStatus(String companyStatus) throws Exception {
		Common.softAssert = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			List<WebElement> Actualcell = driver.findElements(By.xpath("//table//tbody//tr//td"));
			List<WebElement> row = driver.findElements(By.xpath("//table//tbody//tr"));
			int rowcount = row.size();
			for (int i = 1; i <= rowcount; i++) {
				List<WebElement> col = driver.findElements(By.xpath("//table//tbody//tr[" + i + "]//td"));
				for (int j = 1; j <= col.size(); j++) {
					String text = driver.findElement(By.xpath("//table//tbody//tr[" + i + "]//td[" + j + "]"))
							.getText();
					if (text.equalsIgnoreCase(companyStatus)) {
						driver.findElement(By.xpath("//table//tbody//tr[" + i + "]//td[" + (j - 1) + "]")).click();
						Thread.sleep(1000);
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info(companyStatus + " - status qusetionnaire not exist for the logged user");
			extentLog.log(Status.PASS, MarkupHelper.createLabel(
					companyStatus + " - status qusetionnaire not exist for the logged user", ExtentColor.GREEN));
			// e.printStackTrace();
		} finally {
			Common.softAssert.assertAll();
		}
	}

	@FindBy(xpath = "//button[normalize-space()='Expand All']")
	WebElement btnExpandAllInvitation;
	@FindBy(xpath = "//a[normalize-space()='Questionnaires']")
	WebElement titleQREpage;
	@FindBy(xpath = "//button[normalize-space()='Accept']")
	WebElement loginTCpopup;

	@FindBy(xpath = "//button[normalize-space()='Accept']")
	WebElement homePasswordChangePopup;
	
	/*
	 * Abbreviation:Used to validate the company status "INVITED" and navigating
	 * inside corresponding questionnaire
	 * 
	 * @param : Company status text
	 * 
	 * @return : NA
	 * 
	 * @author : Abhilasha
	 * 
	 * @date: 04 JAN 2023
	 */
	public void MNCInvitedCompanyStatusValidation() {
		Common.softAssert = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			//Common.clickOnlyifExists(loginTCpopup, 5, driver);
			//Common.clickOnlyifExists(homePasswordChangePopup, 5, driver);
			DiligendClientLoginPage objLP = new DiligendClientLoginPage(driver);
			objLP.LoginHomePopup();
			wait.until(ExpectedConditions.visibilityOf(titleQRE));
			logger.info("MNC  qusetionnaire CompanyStatus INVITED validation started");
			MNCQuestionnaireCompanyStatus("Invited");
			Thread.sleep(10000);
			if(btnInvitationAccept.isDisplayed()) {
			Common.assertVisible(btnInvitationAccept);
			Common.assertVisible(btnInvitationReject);
			Common.scrollIntoView(btnExpandAllInvitation, driver);
			Common.clickOnlyifExists(btnExpandAllInvitation, 10, driver);
			Common.scrollToBottom(driver);
			Common.scrollToTop(driver);
			Common.scrollIntoView(btnInvitationAccept, driver);
			Common.clickElement(btnInvitationAccept, 10, driver);
			wait.until(ExpectedConditions.visibilityOf(btnSubmit));
			if (btnSubmit.isEnabled()) {
				logger.info("Questionnaire has been accepted and its ready to submit with answer: " + btnSubmit
						+ " button is enabled");
				extentLog.log(Status.PASS,
						MarkupHelper.createLabel("Questionnaire has been accepted and its ready to submit with answer: "
								+ btnSubmit + " button is enabled", ExtentColor.GREEN));
				
			}
			}
//			Thread.sleep(10000);
		Common.clickElement(titleQREpage, 5, driver);
			Thread.sleep(10000);
		} catch (Exception e) {
			logger.info("Questionnaire with invited status not found for the logged in user");
			extentLog.log(Status.PASS, MarkupHelper.createLabel(
					"Questionnaire with invited status not found for the logged in user ", ExtentColor.GREEN));
		} finally {
			logger.info("MNC  qusetionnaire CompanyStatus INVITED validation ended");
			Common.softAssert.assertAll();
		}
	}
	
	/*
	 * Abbreviation:Used to validate the company status "RECEIVED" and navigating
	 * inside corresponding questionnaire
	 * 
	 * @param : Company status text
	 * 
	 * @return : NA
	 * 
	 * @author : Abhilasha
	 * 
	 * @date: 04 JAN 2023
	 */
	public void MNCReceivedCompanyStatusValidation() {
		Common.softAssert = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			wait.until(ExpectedConditions.visibilityOf(titleQRE));
			logger.info("MNC  qusetionnaire CompanyStatus RECEIVED validation started");
			MNCQuestionnaireCompanyStatus("Received");
			Thread.sleep(10000);
			if(btnInvitationAccept.isDisplayed()) {
		
				logger.info("As Questionnaire status is Received user is bale to still Accept the qusetionnaire" );
				extentLog.log(Status.PASS,
						MarkupHelper.createLabel("As Questionnaire status is Received user is bale to still Accept the qusetionnaire" , ExtentColor.GREEN));	
			}
		Common.clickElement(titleQREpage, 5, driver);
			Thread.sleep(10000);
		} catch (Exception e) {
			logger.info("Questionnaire status is Received not naviagting to accept/Reject questionnaire");
			extentLog.log(Status.PASS, MarkupHelper.createLabel(
					"Questionnaire status is Received not naviagting to accept/Reject questionnaire", ExtentColor.GREEN));
		} finally {
			logger.info("MNC  qusetionnaire CompanyStatus RECEIVED validation ended");
			Common.softAssert.assertAll();
		}
	}

	/*
	 * Abbreviation:Used to validate the company status "SUBMITTED" and navigating
	 * inside corresponding questionnaire
	 * 
	 * @param : Company status text
	 * 
	 * @return : NA
	 * 
	 * @author : Abhilasha
	 * 
	 * @date: 04 JAN 2023
	 */
	public void MNCsubmittedCompanyStatusValidation() throws InterruptedException {
		Common.softAssert = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		try {
			wait.until(ExpectedConditions.visibilityOf(titleQRE));
			logger.info("MNC  qusetionnaire CompanyStatus SUBMITTED validation  started");
			MNCQuestionnaireCompanyStatus("submitted");
			wait.until(ExpectedConditions.visibilityOf(btnMore));
			if (btnSubmit.isEnabled()) {
				logger.warn("Selected qusetionnaire is not submitted: " + btnSubmit + " button is enabled");
				extentLog.log(Status.FAIL,
						MarkupHelper.createLabel(
								"Selected qusetionnaire is not submitted: " + btnSubmit + " button is enabled",
								ExtentColor.RED));
				
				
			} else {
				logger.info("Questionnaire has been accepted and submitted: " + btnSubmit
						+ " button is disabled");
				extentLog.log(Status.PASS,
						MarkupHelper.createLabel("Questionnaire has been accepted and submittedr: "
								+ btnSubmit + " button is disabled", ExtentColor.GREEN));
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Common.clickElement(titleQREpage, 5, driver);
			Thread.sleep(10000);
			logger.info("MNC  qusetionnaire CompanyStatus SUBMITTED validation ended");
			Common.softAssert.assertAll();
		}
	}

	/*
	 * Abbreviation:Used to validate the company status "Accepted" and navigating
	 * inside corresponding questionnaire
	 * 
	 * @param : Company status text
	 * 
	 * @return : NA
	 * 
	 * @author : Abhilasha
	 * 
	 * @date: 04 JAN 2023
	 */
	public void MNCacceptedCompanyStatusValidation() {
		Common.softAssert = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			logger.info("MNC  qusetionnaire CompanyStatus ACCEPTED validation started");
			
			MNCQuestionnaireCompanyStatus("accepted");
			// submit or sign and submit
			logger.info("MNC  qusetionnaire CompanyStatus ACCEPTED Navigation completed");
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Common.softAssert.assertAll();
		}
	}
}