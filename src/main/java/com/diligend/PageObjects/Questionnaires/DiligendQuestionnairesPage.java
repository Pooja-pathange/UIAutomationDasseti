package com.diligend.PageObjects.Questionnaires;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.diligend.actiondriver.Common;
import com.diligend.utilities.ExcelUtilility;


public class DiligendQuestionnairesPage {

	WebDriver driver;
	public String SystemPath = System.getProperty("user.dir");
	 int randomNumber = 0;
	
	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public DiligendQuestionnairesPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(d, this);
	}

	// Locator for WebElements
	@FindBy(xpath = "//*[contains(text(),'Questionnaires')]")
	WebElement QuestionnarieMenu;

	@FindBy(id = "//*[@id=\"table-wrapper\"]/p-table/div/div[1]/div/div[2]")
	WebElement QuestionnariePage;

	@FindBy(xpath = "//*[@id=\"burgerFilter\"]/span")
	WebElement MoreButton;

	@FindBy(xpath = "/html/body/app-root/app-portal/div/div/div/app-investor/main/app-questionnaire-list-wrap/app-questionnaires-tab/app-questionnaire-list/div[2]/div/app-burger/div/div[2]/div/div/button/span/span")
	WebElement AddQuestionnaireButton;

	@FindBy(xpath = "/html/body/app-root/app-portal/div/div/div/app-investor/main/app-questionnaire-list-wrap/app-questionnaires-tab/app-questionnaire-list/app-modal[1]/div/div/div/div[2]/div/app-create-questionnaire-modal/div[2]/button")
	WebElement CreatefromScratchoption;
	
	@FindBy(id = "name")
	WebElement QuestionnaierName;

	@FindBy(id = "description")
	WebElement QuestionnaierDiscription;

	@FindBy(xpath = "/html/body/app-root/app-portal/div/div/div/app-investor/main/app-questionnaire-list-wrap/app-questionnaires-tab/app-questionnaire-list/app-modal[2]/div/div/div/div[2]/div/app-create-scratch-questionnaire-modal/div[2]/button")
	WebElement createScratchQuestionnaireButton;

	@FindBy(xpath = "/html/body/app-root/app-portal/div/div/div/app-investor/main/app-questionnaire-level-wrap/app-designer-tab/app-questionnaire-alt-designer/div[1]")
	WebElement QuestionnaireDesignPage_f;

	@FindBy(xpath = "//*[@id=\"719d558d-6ae8-4e26-9897-b796f46bda8d\"]/div[2]/span[2]/span/span/span[1]/input")
	WebElement QuestionDesign;

	@FindBy(xpath = "//*[@id=\"331b46a7-2cee-4f14-8fd4-ed72db1e61de\"]/div[3]/div/i")
	WebElement PlusButtontoAddSection;

	@FindBy(xpath = "//*[@id=\"4e87e57d-e5bf-4c85-b0b6-2fec8fded606\"]/div[3]/div/i")
	WebElement SectionField;

	/*
	 * @FindBy(xpath =
	 * "//*[@id=\"4e87e57d-e5bf-4c85-b0b6-2fec8fded606\"]/div[2]/span[2]/span/span/span[1]/input")
	 * WebElement SectionName;
	 */

	@FindBy(xpath = "/html/body/div[4]/div/div/ul/li[1]")
	WebElement SelectSectionfromDropdown;

	@FindBy(xpath = "")
	WebElement SubSectionField;

	@FindBy(xpath = "")
	WebElement SectionQuestion;

	@FindBy(xpath = "//*[@id=\"0\"]/td[1]/span/span")
	WebElement QDefaultPage;

	@FindBy(xpath = "//*[@id=\"table-wrapper\"]/p-table/div/div[1]/div/div[1]/div/table/thead/tr[2]/th[2]/app-default-filter/div/app-search-input/div/div[1]/input")
	WebElement QSearchField;

	@FindBy(xpath="//label[normalize-space()='Import']")
	WebElement btnRadioImport;
	@FindBy(xpath="//input[@id='fname']")
	WebElement txtAreaQREname;
	@FindBy(xpath="//span[normalize-space()='Choose a file']")
	WebElement linkChooseaFile;
	@FindBy(xpath="//button[normalize-space()='Import']")
	WebElement btnImport;
	//label[normalize-space()='Name']
	@FindBy(xpath="//div[@class='modal-content']//div//div[@class='ng-star-inserted']")
	WebElement popupQreCreate;
	@FindBy(xpath="//app-search-input[@id='assetClass']//div//div//input[@aria-label='Search Input']")
	WebElement txtAreaAssetClass;
	@FindBy(xpath="//app-search-input[@id='q-type']//div//div//input[@aria-label='Search Input']")
	WebElement txtAreaQtype;
	@FindBy(xpath="//input[@id='fdescription']")
	WebElement txtAreadescription;
	
	/*
	 * @description : Navigation to questionnaire page
	 * 
	 * @param : NA
	 * 
	 * @return : NA
	 * 
	 * @date: 17 Mar 2022
	 */
	public void navigationQuestionnairePage() throws Exception {
		try {
			Common.softAssert = new SoftAssert();
			Common.clickElement(QuestionnarieMenu, 0 , driver);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			Common.softAssert.assertAll();
		}

	}
	/*
	 * @description : method to import questionnaire
	 * 
	 * @param : NA
	 * 
	 * @return : NA
	 * 
	 * @date: 17 Mar 2022
	 */
	public void createByImport() throws Exception {
		try {
			Common.softAssert = new SoftAssert();
			Common.clickElement(MoreButton, 0 , driver);
			Common.clickElement(AddQuestionnaireButton, 0 , driver);
			Common.clickElement(btnRadioImport, 0 , driver);
			Common.clickElement(linkChooseaFile, 0 , driver);
			Thread.sleep(5000);
			Common.uploadFile("\\src\\test\\resources\\AutoIT\\Questionnaires\\FileUploadQuestionnaire.exe");
			Thread.sleep(5000);
			//Common.webEditTxtChange(txtAreaQREname, Common.getcellvalue(Common.getProperty("EXCEL_PATH_QUESTIONNAIRE"),"QUESTIONNAIRESIMPORT", 1, 0));
			String exeTime = new SimpleDateFormat("yyyyMMMddhh.mma").format(new Date());
			txtAreaQREname.sendKeys("QRE"+exeTime);
			Common.clickElement(btnImport, 0 , driver);
			Thread.sleep(1000);
			//ScreenshotUtility.getScreenShot("Questionnaire_Import_Success" , driver);
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			Common.softAssert.assertAll();
		}
	}
	
	// Action Methods
	public void QuestionnarieSidemenuClick() {
		try {

			// -------------------------------------------------------------------------------------------------------------------
			int a;
			int z = 20;
			for (a = 1; a <= z; a++) {

				String view = "//span[normalize-space()='Questionnaires']";  
				String result = "";
				String recordname = driver.findElement(By.xpath(view)).getText();
				// System.out.println(recordname);
				if (recordname.equals("Questionnaires")) {
					result = view;
					// System.out.println(result);
					driver.findElement(By.xpath(result)).click();
					break;
				}
			}
			Assert.assertTrue(true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.assertTrue(false);
		}

	}

	// If questionnaier page is displayed click on more and Add Questionnaire button
	public void MoreButtonOnPage() {
		try {
			MoreButton.click();
			Thread.sleep(500);
			AddQuestionnaireButton.click();
			Assert.assertTrue(true);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	// to select "create from scratch"
	public void CreatefromScratch() {
		try {
			CreatefromScratchoption.click();
			Assert.assertTrue(true);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	

	public void CreatePopup(String Name, String Description) {
		try {

			boolean res = driver.findElement(By.xpath(
					"/html/body/app-root/app-portal/div/div/div/app-investor/main/app-questionnaire-list-wrap/app-questionnaires-tab/app-questionnaire-list/app-modal[2]/div/div/div"))
					.isDisplayed();
			// to generate unique script name random numbers are added at end of name	
			Random objGenerator = new Random();
            for (int iCount = 0; iCount< 1; iCount++){
               randomNumber = objGenerator.nextInt(100);
              System.out.println("Random No : " + randomNumber); 
             }
			if (res) {

				QuestionnaierName.click();
				QuestionnaierName.sendKeys(Name + randomNumber);

				QuestionnaierDiscription.click();
				QuestionnaierDiscription.sendKeys(Description);

				Thread.sleep(500);
				createScratchQuestionnaireButton.click();
				Thread.sleep(500);
				Assert.assertTrue(true);
			}
		} catch (Exception e) {
			// TODO: handle exception

			// ScreenshotUtility.getScreenShot(driver,"loginTest");
			Assert.assertTrue(false);
			e.printStackTrace();
		}

	}

	public void DeletingQuestion(String Name) {
		try {
			WebElement CloseScreen = driver.findElement(By.xpath(
					"/html/body/app-root/app-portal/div/div/div/app-investor/main/app-questionnaire-list-wrap/app-questionnaires-tab/app-questionnaire-list/app-modal[2]/div/div/div/div[1]/button"));
			CloseScreen.click();
			Thread.sleep(300);
			QDefaultPage.click();
			Thread.sleep(300);
			QSearchField.click();
			QSearchField.sendKeys(Name + randomNumber);
			Thread.sleep(300);
			// selecting file to delete
			driver.findElement(By.xpath("//*[@id=\"0\"]/td[1]/p-tablecheckbox/div/div[2]")).click();
			Thread.sleep(200);
			MoreButton.click();

			driver.findElement(By.xpath(
					"/html/body/app-root/app-portal/div/div/div/app-investor/main/app-questionnaire-list-by-type/app-questionnaire-list/div[2]/div/app-burger/div/div[4]/div/div/button[2]"))
					.click();
			Thread.sleep(300);
			// Confirming to delete file
			driver.findElement(
					By.xpath("/html/body/app-root/app-confirmation/app-modal/div/div/div/div[2]/div/div[2]/button[1]"))
					.click();

			Assert.assertTrue(true);

		} catch (Exception e) {
			// TODO: handle exception
			Assert.assertTrue(false);
		}
	}

	public void QuestionnaireDesign_Page(String Name, String Description) {

		try {

			/*
			 * boolean Designer = driver.findElement(By.xpath(
			 * "/html/body/app-root/app-p-notify/div/notifier-container/ul/li/notifier-notification/div/div[2]/span"
			 * )) .isDisplayed();
			 * 
			 * if (Designer) {
			 */
			System.out.println("Question is already existing so Deleting question");

			DeletingQuestion(Name + randomNumber);
			System.out.println("Deleted Sucessfully");
			Thread.sleep(1000);
			// Recreating question
			System.out.println("Creating New Question");
			DeafultQuestionPage(Name, Description);
			Assert.assertTrue(true);

		} catch (Exception e) {
			// TODO: handle exception
			Assert.assertTrue(false);
		}

	}

	public void DeafultQuestionPage(String Name, String Description) {
		try {
			System.out.println("Recreating question from scratch");
			MoreButton.click();
			Thread.sleep(500);
			// Clicking on Add Question Button
			driver.findElement(By.xpath(
					" /html/body/app-root/app-portal/div/div/div/app-investor/main/app-questionnaire-list-by-type/app-questionnaire-list/div[2]/div/app-burger/div/div[4]/div/div/button[1]/span/span"))
					.click();
			Thread.sleep(500);

			driver.findElement(By.xpath(
					"/html/body/app-root/app-portal/div/div/div/app-investor/main/app-questionnaire-list-by-type/app-questionnaire-list/app-modal[1]/div/div/div/div[2]/div/app-create-questionnaire-modal/div[2]/button"))
					.click();

			Thread.sleep(500);
			QuestionnaierName.click();
			QuestionnaierName.sendKeys(Name + randomNumber);

			Thread.sleep(500);
			QuestionnaierDiscription.click();
			QuestionnaierDiscription.sendKeys(Description);

			Thread.sleep(100);
			driver.findElement(By.xpath(
					"/html/body/app-root/app-portal/div/div/div/app-investor/main/app-questionnaire-list-by-type/app-questionnaire-list/app-modal[2]/div/div/div/div[2]/div/app-create-scratch-questionnaire-modal/div[2]/button"))
					.click();

			Assert.assertTrue(true);
		} catch (Exception e) {
			// TODO: handle exception
			Assert.assertTrue(false);
		}

	}

	/*
	 * public void DesignerPage() { try { Actions action = new Actions(driver);
	 * 
	 * System.out.println("Creating Designer Page....."); Thread.sleep(500);
	 * WebElement SectionName =
	 * driver.findElement(By.xpath("//span[contains(text(),'DEFAULT SECTION')]"));
	 * Thread.sleep(500); SectionName.click(); SectionName.clear();
	 * SectionName.sendKeys("Section 1 Company");
	 * 
	 * driver.findElement(By.xpath(
	 * "//body/app-root[1]/app-portal[1]/div[1]/div[1]/div[1]/app-investor[1]/main[1]/app-questionnaire-level-wrap[1]/app-designer-tab[1]/app-questionnaire-alt-designer[1]/div[1]/div[3]/app-q-designer-alt-tree-node[1]/div[1]/div[1]/div[1]/div[3]/div[1]/i[1]"
	 * ));
	 * 
	 * Assert.assertTrue(true);
	 * 
	 * } catch (Exception e) { // TODO: handle exception e.printStackTrace();
	 * Assert.assertTrue(false); } }
	 */

}
