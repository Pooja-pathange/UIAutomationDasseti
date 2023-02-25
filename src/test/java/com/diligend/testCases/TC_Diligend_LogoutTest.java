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

public class TC_Diligend_LogoutTest extends DiligendBaseClass {

	DiligendClientLogoutPage objLo=new DiligendClientLogoutPage(driver);

	//@Test(priority = 1, dependsOnMethods = { "Logintest" })
	@Test
	public void LogoutPage() throws Exception {
		logger.info("To verify logout functionality");
			DiligendClientLogoutPage objout = new DiligendClientLogoutPage(driver);
			objout.Logout();
			

	}

}
