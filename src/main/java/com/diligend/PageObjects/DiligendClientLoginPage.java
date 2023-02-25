package com.diligend.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.diligend.BaseClass.DiligendBaseClass;
import com.diligend.actiondriver.Common;

public class DiligendClientLoginPage extends DiligendBaseClass {

	WebDriver driver;

	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public DiligendClientLoginPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(d, this);
	}

	// Locator for WebElements

	@FindBy(id = "login-email")
	WebElement LoginUserName;

	@FindBy(id = "login-password")
	WebElement LoginPassword;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement LoginContinue;
	
	@FindBy(xpath = "//button[normalize-space()='Accept']")
	WebElement loginTCpopup;

	@FindBy(xpath = "//button[normalize-space()='No']")
	WebElement homePasswordChangePopup;
	
	
	// Action Methods
	public void EnterUserNameForLogin(String User_name) {
		
		LoginUserName.clear();
		LoginUserName.sendKeys(User_name);
	}

	public void EnterPasswordforLogin(String Password_P) {
		LoginPassword.clear();
		LoginPassword.sendKeys(Password_P);
	}

	public void ClickLoginContinue() {

		LoginContinue.click();
	}
	
	public void LoginHomePopup() {
		Common.softAssert.assertAll();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		try {
			DiligendClientLoginPage objLP = new DiligendClientLoginPage(driver);
			Common.clickOnlyifExists(loginTCpopup, 2, driver);
			Common.clickOnlyifExists(homePasswordChangePopup, 2, driver);
			logger.info("User cicked on Questionnaire Module");
		} catch (Exception e) {
			System.out.println("No popup displayed on login page");
			logger.info("No popup displayed on login page");
		} finally {
			Common.softAssert.assertAll();
		}
	}
}