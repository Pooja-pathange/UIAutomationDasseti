package com.diligend.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.diligend.BaseClass.DiligendBaseClass;
import com.diligend.PageObjects.DiligendClientLoginPage;
import com.diligend.PageObjects.DiligendClientLogoutPage;
import com.diligend.actiondriver.Common;
import com.diligend.utilities.ExcelUtilility;

public class TC_Diligend_Login_LogoutTest extends DiligendBaseClass {

	WebDriver driver;

	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public TC_Diligend_Login_LogoutTest(WebDriver d) {
		driver = d;
		PageFactory.initElements(d, this);
	}

	@Test(priority = 1)
	public void verifyTitle() throws IOException, InterruptedException {
		try {
			logger.info("To verify Diligend Title");

			if (driver.getTitle().equals("Diligend")) {
				Assert.assertTrue(true);
				logger.info("Verified title sucessfully");
				Common.pageLoadTimeOut(driver, 800);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String msg = e.getMessage();
			System.out.println(msg);
			logger.warn("vrification failed");
			Assert.assertTrue(false);

		}
	}

	@Test(priority = 2, dataProvider = "loginData")
	public void Logintest(String Username, String Password) throws InterruptedException, IOException {
		logger.info("To verify login with credentials");

		try {

			System.out.println(Username + " | " + Password);

			// Creating object of Login page
			DiligendClientLoginPage objLP = new DiligendClientLoginPage(driver);

			Thread.sleep(2000);
			// Enter username & password
			logger.info("To verifying with new user");
			objLP.EnterUserNameForLogin(Username);
			objLP.EnterPasswordforLogin(Password);

			Thread.sleep(300);
			// Click on login button
			objLP.ClickLoginContinue();
			logger.info("Logged in sucessfully");
			Thread.sleep(2000);

			logger.info("validation started....");
			try {

				boolean res = driver.findElement(By.xpath("/html/body/app-root/app-portal/div/app-sidebar"))
						.isDisplayed();
				Thread.sleep(2000);

				if (res) {
					Assert.assertTrue(true);
					logger.info("user login passed....");
					// LogoutPage();// navigating to logout screen only if login is passed
					Thread.sleep(1000);

				}
			} catch (Exception e) {
				// TODO: handle exception
				logger.warn("user login failed....");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			// TODO: handle exception
			// ScreenshotUtility.getScreenShot(driver,"logintest");
			logger.warn("user login failed due to invalid username and password");
			Assert.assertTrue(false);
		}
	}

	// This logic will read data from excel with validation of browser validation on
	// excel so that script can be open on multiple browser simultaniously and login
	// with different users

	@DataProvider(name = "loginData", parallel = true)
	public String[][] getdata(String browser2,String role2) throws IOException {
		
		
		//Reading Role data from testNg.xml and passing on excel read methods to read User name and password

		String sheetName = role2 + "-Login";
		// get the data from excel

		String path = System.getProperty("user.dir") + "//src//test//resources//TestData//UserLogin.xlsx";

		System.out.println(path);

		ExcelUtilility xlutility = new ExcelUtilility(path);

		
		int totalrow = xlutility.getRowCount(sheetName);
		int totalcols = xlutility.getCellCount(sheetName, 1);

		String loginData[][] = new String[1][2];
		for (int i = 1; i <= totalrow; i++) {

			/*
			 * for (int j = 0; j < totalcols; j++) { loginData[i - 1][j] =
			 * xlutility.getCellData("Sheet1", i, j); }
			 */
			// comparing role
			//String role = ExcelUtilility.getCellData("Manager-Login", i, 3);

			//if (role.equals("Investor")) {

				// comparing browser value
				String browser = ExcelUtilility.getCellData(sheetName, i, 2);
				if (driver instanceof ChromeDriver && browser.equals("Chrome")) {
					loginData[0][0] = ExcelUtilility.getCellData(sheetName, i, 0);
					loginData[0][1] = ExcelUtilility.getCellData(sheetName, i, 1);
				}
				if (driver instanceof EdgeDriver && browser.equals("Edge")) {
					loginData[0][0] = ExcelUtilility.getCellData(sheetName, i, 0);
					loginData[0][1] = ExcelUtilility.getCellData(sheetName, i, 1);
				}
			//}

			/*
			 * else if (role.equals("Manager")) { // comparing browser value String browser
			 * = ExcelUtilility.getCellData("Manager-Login", i, 2); if (driver instanceof
			 * ChromeDriver && browser.equals("Chrome")) { loginData[0][0] =
			 * ExcelUtilility.getCellData("Manager-Login", i, 0); loginData[0][1] =
			 * ExcelUtilility.getCellData("Manager-Login", i, 1); } if (driver instanceof
			 * EdgeDriver && browser.equals("Edge")) { loginData[0][0] =
			 * ExcelUtilility.getCellData("Manager-Login", i, 0); loginData[0][1] =
			 * ExcelUtilility.getCellData("Manager-Login", i, 1); } }
			 */
		}

		return loginData;

	}
	
	@Test(priority = 3)
	public void LogoutPage() throws Exception {
		logger.info("To verify logout functionality");
			DiligendClientLogoutPage objout = new DiligendClientLogoutPage(driver);
			objout.Logout();
			

	}

}
