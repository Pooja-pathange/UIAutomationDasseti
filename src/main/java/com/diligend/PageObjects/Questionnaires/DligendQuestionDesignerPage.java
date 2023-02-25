package com.diligend.PageObjects.Questionnaires;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import com.diligend.actiondriver.Common;

//Author Pooja
//date 24-03-2022

public class DligendQuestionDesignerPage {

	WebDriver driver;

	

	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public DligendQuestionDesignerPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(d, this);
	}

	// Locator for WebElements

	@FindBy(xpath = "//span[normalize-space()='Expand']")
	WebElement Expand;

	@FindBy(xpath = "(//i[@class='fa fa-caret-down'])[1]")
	WebElement Dropdown_button;

	@FindBy(xpath = "//i[@class='fas fa-cog']")
	WebElement SettingsButton;

	@FindBy(xpath = "//div[@class='settings-column__content']")
	WebElement settingsPage;

	@FindBy(xpath = "//textarea[@id='name']")
	WebElement QuestionnaireNameUpdate;

	@FindBy(xpath = "//i[@class='far fa-copy']")
	WebElement Questionnairelink;

	@FindBy(id = "mat-input-7")
	WebElement TagsName;

	@FindBy(xpath = "//i[@class='fas fa-check ng-star-inserted']")
	WebElement selectTags;

	// =========================question page

	@FindBy(xpath = "//span[normalize-space()='Preview']")
	WebElement PreviewButton;
	
	@FindBy(xpath = "//button[normalize-space()='Expand All']")
	WebElement PreviewExpandButton;
	
	@FindBy(xpath = "//i[@class='fa fa-chevron-left']")
	WebElement BacktoQuestionnairePage;
	
	@FindBy(xpath = "//button[@id='burgerFilter']")
	WebElement QDMoreButton;

	
	@FindBy(xpath = "//body//app-root//button[5]")
	WebElement QDExportButton;

	@FindBy(xpath = "//button[normalize-space()='Publish']")
	WebElement PublishQuestionnaire;
	
	@FindBy(xpath = "//button[normalize-space()='Yes']")
	WebElement PublishYesButton;

	public void QuestionDesignerPageValidation() {
		try {
			Common.softAssert = new SoftAssert();
			Common.clickElement(Expand, 10 , driver);
			Common.assertVisible(Dropdown_button);
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			Common.softAssert.assertAll();
		}

	}

	public void QuestionDesignerSettingValidation() {
		try {
			Common.softAssert = new SoftAssert();
			Common.clickElement(SettingsButton, 10 , driver);
			Common.assertVisible(settingsPage);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			Common.softAssert.assertAll();
		}
	}

	public void UpdateQuestionnairename() {
		try {
			Common.softAssert = new SoftAssert();

			//Common.clickElement(TagsName, 2);
			//TagsName.sendKeys("Automation Tags");
			//Common.clickElement(selectTags, 10);
			Common.clickElement(QuestionnaireNameUpdate, 2 , driver);
			QuestionnaireNameUpdate.sendKeys("" + "Updated Q name");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			Common.softAssert.assertAll();
		}
	}

	public void designPagevalidation() {
		try {
			Common.softAssert = new SoftAssert();
			Actions actions = new Actions(driver);
			// Create object 'action' of an Actions class

			actions.moveToElement(QDMoreButton);

			Common.clickElement(QDMoreButton, 5 , driver);
			actions.moveToElement(PreviewButton);
			Common.clickElement(PreviewButton, 10 , driver);
			actions.moveToElement(PreviewExpandButton);
			Common.clickElement(PreviewExpandButton, 4 , driver);
			actions.moveToElement(BacktoQuestionnairePage);
			Common.clickElement(BacktoQuestionnairePage, 4 , driver);
			actions.moveToElement(QDExportButton);
			actions.moveToElement(QDMoreButton);
			Common.clickElement(QDMoreButton, 5 , driver);
			Common.clickElement(QDExportButton, 5 , driver);
			actions.moveToElement(PublishQuestionnaire);
			Common.clickElement(PublishQuestionnaire, 5 , driver);
			actions.moveToElement(PublishYesButton);
			Common.clickElement(PublishYesButton, 5 , driver);
			

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			Common.softAssert.assertAll();
		}

	}

}
