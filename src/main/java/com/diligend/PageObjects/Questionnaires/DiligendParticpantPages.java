package com.diligend.PageObjects.Questionnaires;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.diligend.actiondriver.Common;


public class DiligendParticpantPages {

	WebDriver driver;

	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public DiligendParticpantPages(WebDriver d) {
		driver = d;
		PageFactory.initElements(d, this);
	}

	// Locators for Copy Existing Questionaries

	@FindBy(xpath = "//span[normalize-space()='Participants']")
	WebElement ParticpantTab;

	@FindBy(xpath = "//span[normalize-space()='Add Participants']")
	WebElement AddParticipants;
	
	@FindBy(id = "search_value")
	WebElement FilterByCompanyNameOrContactName;
	
	@FindBy(xpath = "div[class='check-all-checkbox'] div[role='checkbox']")
	WebElement Selectcompanyfromcheckbox;
	
	@FindBy(xpath = "//span[normalize-space()='Add']")
	WebElement AddButton;
		
	@FindBy(xpath ="//div[@class='ui-table-scrollable-body']")
	WebElement ParticpantspageforouterClick;
	
	@FindBy(css = "div[class='ui-chkbox-box ui-widget ui-state-default ui-state-active'] span[class='ui-chkbox-icon ui-clickable pi pi-check']")
	WebElement SelectParticipntstoInvitefromPage;
	
	@FindBy(xpath = "//button[@id='burgerFilter']")
	WebElement MoreButton_PP;
	
	@FindBy(xpath = "//span[normalize-space()='Invite/Resend']")
	WebElement InviteButton;
	
	@FindBy(xpath = "//span[normalize-space()='Designer']")
	WebElement DesignerPage;
	
	@FindBy(xpath = "//button[normalize-space()='Publish']")
	WebElement PublishButton;
	
	
	//Click on participants screen
	public void ParticipantsFromSidebar() {
		try {
			ParticpantTab.click();
			Thread.sleep(500);
	
			boolean Particpant_page = driver.findElement(By.cssSelector(".ui-table-scrollable-header-box"))
					.isDisplayed();
			Thread.sleep(2000);

			if (Particpant_page) {
				System.out.println("user is on Particpant page ");
			}
			else {
				System.out.println("user is not on Particpant page ");
			}
			
			Thread.sleep(400);
			AddParticipants.click();
			Thread.sleep(300);
			Assert.assertTrue(true);
		} catch (Exception e) {
			// ScreenshotUtility.getScreenShot(driver,"loginTest");
						Assert.assertTrue(false);
						e.printStackTrace();
						System.out.print(e);
		}
	}
	@FindBy(xpath = "//input[@placeholder='Filter By Company Name Or Contact Name']")
	WebElement FilterByCompOrContact;
	
	@FindBy(xpath = "//div[@class='check-all-checkbox']//div[@role='checkbox']")
	WebElement chkboxselectallCompany;
	@FindBy(xpath = "//div[@class='company-wrapper ng-star-inserted']//div[@role='checkbox']")
	WebElement chkboxselectallCompanyspecific;
	
	@FindBy(xpath = "//div[@class='filter-wrapper']//button[1]")
	WebElement btnAdd;
	
	public void AddParticipantsMethod() throws Exception {
		try {
			Common.softAssert = new SoftAssert();
			Common.clickElement(ParticpantTab, 3 , driver);
			Common.clickElement(AddParticipants, 0 , driver);
			Common.clickElement(FilterByCompOrContact, 0 , driver);
			FilterByCompOrContact.sendKeys("Du telecoms");
Common.clickElement(chkboxselectallCompany, 0 , driver);
Common.clickElement(chkboxselectallCompanyspecific, 0 , driver);
Common.clickElement(btnAdd, 0 , driver);
//			WebElement checkBoxDisplayed = driver.findElement(By.id("search_value"));
//			boolean isDisplayed = checkBoxDisplayed.isDisplayed();
	//
//			// performing click operation if element is displayed
//			if (isDisplayed == true) {
//				driver.findElement(By.cssSelector("div[class='check-all-checkbox'] div[role='checkbox']")).click();
//				Thread.sleep(200);
//			}
//			
//			WebElement AddButtonDisplayed = driver.findElement(By.xpath("//span[normalize-space()='Add']"));
//			boolean Addbutton= AddButtonDisplayed.isDisplayed();
	//
//			// performing click operation if element is displayed
//			if (Addbutton == true) {
//				AddButton.click();
//				Thread.sleep(200);
//			}
//			
//			ParticpantspageforouterClick.click();
//			
//			Assert.assertTrue(true);
//			
//			} catch (Exception e) {
//				// ScreenshotUtility.getScreenShot(driver,"loginTest");
//							Assert.assertTrue(false);
//							e.printStackTrace();
//							System.out.print(e);
//			}
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			Common.softAssert.assertAll();
		}
//		try {
//			ParticpantTab.click();
//			AddParticipants.click();
//			
//			FilterByCompanyNameOrContactName.click();
//		Thread.sleep(100);
//		FilterByCompanyNameOrContactName.sendKeys("Du telecoms"+ Keys.ENTER);
//		Thread.sleep(200);
//		
//		WebElement checkBoxDisplayed = driver.findElement(By.id("search_value"));
//		boolean isDisplayed = checkBoxDisplayed.isDisplayed();
//
//		// performing click operation if element is displayed
//		if (isDisplayed == true) {
//			driver.findElement(By.cssSelector("div[class='check-all-checkbox'] div[role='checkbox']")).click();
//			Thread.sleep(200);
//		}
//		
//		WebElement AddButtonDisplayed = driver.findElement(By.xpath("//span[normalize-space()='Add']"));
//		boolean Addbutton= AddButtonDisplayed.isDisplayed();
//
//		// performing click operation if element is displayed
//		if (Addbutton == true) {
//			AddButton.click();
//			Thread.sleep(200);
//		}
//		
//		ParticpantspageforouterClick.click();
//		
//		Assert.assertTrue(true);
//		
//		} catch (Exception e) {
//			// ScreenshotUtility.getScreenShot(driver,"loginTest");
//						Assert.assertTrue(false);
//						e.printStackTrace();
//						System.out.print(e);
//		}
	}
	
		public void inviteParticipantMethod() {
			try {
				
				DesignerPage.click();
				Thread.sleep(200);
				PublishButton.click();
				WebElement publish_pop_upDisplayed = driver.findElement(By.id("search_value"));
				boolean isDisplayed = publish_pop_upDisplayed.isDisplayed();

				// performing click operation if element is displayed
				if (isDisplayed == true) {
					driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
					Thread.sleep(200);
				}
				
				Thread.sleep(300);
				ParticpantTab.click();
				Thread.sleep(300);
				SelectParticipntstoInvitefromPage.click();
				Thread.sleep(300);
				MoreButton_PP.click();
				Thread.sleep(100);
				InviteButton.click();
				
			} catch (Exception e) {
				// ScreenshotUtility.getScreenShot(driver,"loginTest");
							Assert.assertTrue(false);
							e.printStackTrace();
							System.out.print(e);
			}
			
		}
		
	
}
	
	
	
	
	

