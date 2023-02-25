package com.diligend.PageObjects.Questionnaires;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.diligend.actiondriver.Common;

public class DiligendQuestionnairesCopyPage {

	WebDriver driver;
	

	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public DiligendQuestionnairesCopyPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(d, this);
	}

	// Locators for Copy Existing Questionaries
	
	@FindBy(xpath = "//*[@id=\"burgerFilter\"]/span")
	WebElement MoreButton;

	@FindBy(xpath = "/html/body/app-root/app-portal/div/div/div/app-investor/main/app-questionnaire-list-wrap/app-questionnaires-tab/app-questionnaire-list/div[2]/div/app-burger/div/div[2]/div/div/button/span/span")
	WebElement AddQuestionnaireButton;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-portal[1]/div[1]/div[1]/div[1]/app-investor[1]/main[1]/app-questionnaire-list-wrap[1]/app-questionnaires-tab[1]/app-questionnaire-list[1]/app-modal[1]/div[1]/div[1]/div[1]/div[2]/div[1]/app-create-questionnaire-modal[1]/div[1]/div[1]/div[2]/p-radiobutton[1]/div[1]/div[2]")
	WebElement CopyExisting;

	@FindBy(xpath = "//button[@class='btn btn-short ng-star-inserted']")
	WebElement ClickSelect;

	@FindBy(xpath = "//p-tabpanel[@header='Questionnaires']//app-copy-questionnaire-list-item[1]//div[1]//div[1]//div[1]//button[1]//i[1]")
	WebElement CopyQuest;

	@FindBy(xpath = "//input[@id='description']")
	WebElement CopyQuestDescription;

	@FindBy(xpath = "//button[@class='btn btn-short']")
	WebElement ClickYes;

	@FindBy(xpath = "//span[normalize-space()='Contact Section']")
	WebElement HooverOnFolder;

	
	@FindBy(xpath = "//body/app-root[1]/app-portal[1]/div[1]/div[1]/div[1]/app-investor[1]/main[1]/app-questionnaire-level-wrap[1]/app-designer-tab[1]/app-questionnaire-alt-designer[1]/div[1]/div[3]/app-q-designer-alt-tree-node[1]/div[1]/div[3]/div[1]/div[3]/div[1]")

	WebElement ClickAdd;

	@FindBy(xpath = "//body/div[@class='ng-trigger ng-trigger-animation ng-tns-c213-330 menu-wrap ui-overlaypanel ui-widget ui-widget-content ui-corner-all ui-shadow ng-star-inserted ui-overlaypanel-shifted']/div[@class='ui-overlaypanel-content ng-tns-c213-330']/div[@class='menu ng-tns-c213-330']/ul/li[1]")
	WebElement AddSection;

	@FindBy(xpath = "//span[@class='section-title-input']//input[@type='text']")
	WebElement InputSection;

	@FindBy(xpath = "//button[@class='btn btn-action btn-short ng-star-inserted']")
	WebElement ClickPublish;

	@FindBy(xpath = "//button[normalize-space()='Yes']")
	WebElement ConfirmPublish;
	
	@FindBy(xpath = "//input[@class='form-control ng-pristine ng-valid ng-touched']")
	WebElement QuestionNameSearch;

	// Action classes for Copying existng questionalries

	// If questionnaier page is displayed click on more and Add Questionnaire button
	public void MoreButtonOnPage() {
		try {
			Thread.sleep(500);
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

	// to select "Copy Existing"
	public void CopyExistingQuest() {
		try {
			CopyExisting.click();
			Assert.assertTrue(true);
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.assertTrue(false);
		}

	}
	
	
	public void questionnaire_name() {
		Actions action=new Actions(driver);
		action.moveToElement(QuestionNameSearch).click().perform();
		QuestionNameSearch.sendKeys("data with all type questions");
		
		
	}

	// to select "Click Select"
	public void ClickOnSelect() {
		try {
			ClickSelect.click();
			Assert.assertTrue(true);
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.assertTrue(false);
		}

	}

	// to select "Copy quest"
	public void CopyQuest() {
		try {
			Thread.sleep(300);
			CopyQuest.click();
			Thread.sleep(300);
			Assert.assertTrue(true);
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.assertTrue(false);
		}

	}

	// to select "Copy quest input description"
	public void CopyQuestDescription() {
		try {
			CopyQuestDescription.sendKeys("testing Description");
			Thread.sleep(300);
			Assert.assertTrue(true);
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.assertTrue(false);
		}

	}

	// to select "Click Yes"
	public void ClickYes() {
		try {
			ClickYes.click();
			Assert.assertTrue(true);
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.assertTrue(false);
		}

	}

	// to select "Hoover On Folder"
	public void HooverOnFolder() {
		Actions action = new Actions(driver);

		try {
			Thread.sleep(300);
			HooverOnFolder.click();
			action.moveToElement(HooverOnFolder).perform();
			Thread.sleep(300);
			Assert.assertTrue(true);
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.assertTrue(false);
		}

	}

	// to select "Click Add"
	public void ClickAdd() {
		try {
			ClickAdd.click();
			Assert.assertTrue(true);
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.assertTrue(false);
		}

	}

	// to select "Add Section"
	public void AddSection() {
		try {
			AddSection.click();
			Assert.assertTrue(true);
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.assertTrue(false);
		}

	}

	// to select "Add description to section"
	public void InputSection() {
		try {
			InputSection.sendKeys("TEST SECTION");
			Thread.sleep(300);
			Assert.assertTrue(true);
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.assertTrue(false);
		}

	}

	// to select "Click Publish"
	public void ClickPublish() {
		try {
			ClickPublish.click();
			Assert.assertTrue(true);
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.assertTrue(false);
		}

	}

	// to select "Confirm Publish"
	public void ConfirmPublish() {
		try {
			ConfirmPublish.click();
			Assert.assertTrue(true);
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Assert.assertTrue(false);
		}

	}

}
