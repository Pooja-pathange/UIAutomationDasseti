package com.diligend.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.diligend.BaseClass.DiligendBaseClass;
import com.diligend.actiondriver.Common;

public class DiligendClientLogoutPage extends DiligendBaseClass {
	
	WebDriver driver;

	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public DiligendClientLogoutPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(d, this);
	}

	// Locator for WebElements

	@FindBy(xpath = "//i[@class='fas fa-chevron-down']")
	WebElement UserAccount;

	@FindBy(xpath = "//span[normalize-space()='Logout']")
	WebElement Logout;

	@FindBy(xpath = "//div[@class='logo']")
	WebElement logoDiligend;
	
	
	

	/*
	 * @description : Used to logout user
	 * 
	 * @param : NA
	 * 
	 * @return : NA
	 * 
	 * @author : Abhilasha
	 * 
	 * @date: 23 DEC 2022
	 */
	public void Logout() {
		Common.softAssert = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			driver.navigate().refresh();
			wait.until(ExpectedConditions.visibilityOf(UserAccount));
			Common.clickElement(UserAccount, 0, driver);
			Common.clickElement(Logout, 0, driver);
			wait.until(ExpectedConditions.visibilityOf(logoDiligend));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		finally {
			Common.softAssert.assertAll();
		}
	}
}
