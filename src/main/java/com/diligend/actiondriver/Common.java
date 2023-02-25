package com.diligend.actiondriver;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.diligend.BaseClass.DiligendBaseClass;


public  class Common extends DiligendBaseClass {

	public static SoftAssert softAssert;
	// public static WebDriverWait wait = WebDriverWait(driver, 30);
	public static Workbook wb;
	public static String SystemPath = System.getProperty("user.dir");
	private static String valueOf;
	
	Class<? extends Common> class1=this.getClass();
	Field[] fields=class1.getDeclaredFields();
	
	
	public void fluentWait(WebDriver driver,WebElement element, int timeOut) {
	    Wait<WebDriver> wait = null;
	    try {
	        wait = new FluentWait<WebDriver>((WebDriver) driver)
	        		.withTimeout(Duration.ofSeconds(20))
	        	    .pollingEvery(Duration.ofSeconds(2))
	        	    .ignoring(Exception.class);
	        wait.until(ExpectedConditions.visibilityOf(element));
	        element.click();
	    }catch(Exception e) {
	    }
	}
	
	public static void implicitWait(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void explicitWait(WebDriver driver, WebElement element, int timeOut ) {
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void pageLoadTimeOut(WebDriver driver, int timeOut) {
		driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
	}
	
	
	
	/*
	 * @description: waits till the element is clickable and clicks the element
	 * 
	 * @param: web element
	 * 
	 * @return:NA
	 * 
	 * @Date:07 Mar 2022
	 */


	public static void clickElement(WebElement element, long timeOutInSeconds, WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			logger.info("PASSED: clickElement " + element + " completed, success");
			extentLog.log(Status.PASS, MarkupHelper.createLabel(element + " - clicked on element", ExtentColor.GREEN));
			softAssert.assertTrue(true, "Clicked");
		}
		catch (Exception e) {
			logger.warn(MarkupHelper.createLabel("FAILED: clickElement Failed " + element, ExtentColor.RED));
			logger.warn(MarkupHelper.createLabel(e.getMessage(), ExtentColor.RED));
			extentLog.log(Status.FAIL,
					MarkupHelper.createLabel(element + " - not clicked on element", ExtentColor.RED));
			softAssert.assertFalse(true, "Not clicked");
		}
	}
	
	/*
	 * 
	 * @description : upload file using the tool AutoIT
	 * 
	 * @param : Relative path of AutoIT executable file
	 * 
	 * @return : NA
	 * 
	 * @date : 16 MAR 2022
		 * 
	 */
	public static void downloadFile(String filePath) throws Exception {
		try {
			Runtime.getRuntime().exec( SystemPath + filePath);
		} catch (Exception e) {
			logger.warn(MarkupHelper.createLabel("uploadFile Failed ", ExtentColor.RED));
			e.printStackTrace();
			throw e;
		}
	}
	
	/*
	 * @description: Click the element only if its present
	 * @param: web element
	 * @return:NA
	 * @Author: Abhilasha
	 * @Date:11 Oct 2022
	 */
	public static void clickOnlyifExists(WebElement element, long timeOutInSeconds, WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			logger.info("PASSED: clickElement " + element + " completed, success");
			extentLog.log(Status.PASS, MarkupHelper.createLabel(element + " - clicked on element", ExtentColor.GREEN));
			softAssert.assertTrue(true, "Clicked");
		}
		catch (Exception e) {
			logger.warn(MarkupHelper.createLabel("FAILED: clickElement Failed " + element, ExtentColor.GREEN));
			logger.info(MarkupHelper.createLabel(e.getMessage(), ExtentColor.RED));
			extentLog.log(Status.PASS,
					MarkupHelper.createLabel(element + " - not clicked on element", ExtentColor.GREEN));
			softAssert.assertTrue(true, "Not clicked");
		}
	}
	/*
	 * 
	 * @description : checks whether a web element is visible
	 * 
	 * @param : web element
	 * 
	 * @return : NA
	 * 
	 *  @Author: Abhilasha
	 * 
	 * @date:28 Nov 2022
	 */
	public static void assertVisibleOnlyifExists(WebElement element) {
		try {
			if (element.isDisplayed()) {
				logger.info("PASSED: Element visibility " + element + " Is visible, success");
				extentLog.log(Status.PASS, MarkupHelper.createLabel(element+ " - is present", ExtentColor.GREEN));
				softAssert.assertTrue(true, "Found");			
			}
		}
		catch (Exception e) {
			logger.info("FAILED:Element visibility " + element + " Not visible, failure");
			extentLog.log(Status.FAIL,
					MarkupHelper.createLabel(element + " - is not present/visible", ExtentColor.GREEN));
			softAssert.assertFalse(true, "Not Found");
		}
	}
	
	public static void assertElementEnabled(WebElement element) {
		try {
			if (element.isEnabled()) {
				logger.info("PASSED: Element visibility " + element + " Is visible, success");
				extentLog.log(Status.PASS, MarkupHelper.createLabel(element+ " - is present", ExtentColor.GREEN));
				softAssert.assertTrue(true, "Found");			
			}
		}
		catch (Exception e) {
			logger.info("FAILED:Element visibility " + element + " Not visible, failure");
			extentLog.log(Status.FAIL,
					MarkupHelper.createLabel(element + " - is not present/visible", ExtentColor.GREEN));
			softAssert.assertFalse(true, "Not Found");
		}
	}

	/*
	 * 
	 * @description : checks whether a web element is visible
	 * 
	 * @param : web element
	 * 
	 * @return : NA
	 * 
	 * @date:08 Mar 2022
	 */
	public static void assertVisible(WebElement element) {
		try {
			if (element.isDisplayed()) {
				logger.info("PASSED: Element visibility " + element + " Is visible, success");
				extentLog.log(Status.PASS, MarkupHelper.createLabel(element + " - is present", ExtentColor.GREEN));
				softAssert.assertTrue(true, "Found");
			}
		} catch (Exception e) {
			logger.warn("FAILED:Element visibility " + element + " Not visible, failure");
			extentLog.log(Status.FAIL,
					MarkupHelper.createLabel(element + " - is not present/visible", ExtentColor.RED));
			softAssert.assertTrue(true, "Not Found");
		}
	}

	/*
	 * 
	 * @description : select visible text from dropdown list box
	 * 
	 * @param : web element,option
	 * 
	 * @return : NA
	 * 
	 * @date:08 Mar 2022
	 */

	public static void selectFromDropdownCV(WebElement element, String option) {

		try {

			Select select = new Select(element);

			select.selectByVisibleText(option);

		} catch (Exception e) {

			logger.warn(MarkupHelper.createLabel("selectFromDropdown Failed ", ExtentColor.RED));

			throw e;

		}

	}
	/*
	 * 
	 * @description : enters value to a text box or text area
	 * 
	 * @param : text element
	 * 
	 * @param : input value
	 * 
	 * @return : NA
	 * 
	 * @date : 09 Mar 2022
	 * 
	 * 
	 */

	public static void webEditTxtChange(WebElement inputObject, String value) {
		try
		{
			if (!value.equals("")) {
				inputObject.clear();
				if (!value.equals("\"\"")) {
					inputObject.sendKeys(value);

					logger.info("webEditTxtChange completed, entered text: " + value);
					extentLog.log(Status.PASS, MarkupHelper
							.createLabel(value + " - is entered in the field" + inputObject, ExtentColor.GREEN));
				}

			} else {

				logger.info("webEditTxtChange skipped");
				extentLog.log(Status.FAIL,
						MarkupHelper.createLabel(value + " - is entered in the field" + inputObject, ExtentColor.RED));
			}

		}

		catch (Exception e)

		{

			logger.warn(MarkupHelper.createLabel("webEditTxtChange Failed " + inputObject, ExtentColor.RED));

			logger.warn(MarkupHelper.createLabel(e.getMessage(), ExtentColor.RED));

			throw e;

		}

	}
	/*
	 * 
	 * @description : scroll to an element
	 * 
	 * @param : element to be displayed
	 * 
	 * @return : NA
	 * 
	 * @date: 10 Mar 2022
	 */

	public static void scrollIntoView(WebElement element, WebDriver driver) {

		try {

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		} catch (Exception e) {

			logger.warn(MarkupHelper.createLabel("scrollToElement Failed ", ExtentColor.RED));

			throw e;

		}

	}

	/*
	 * 
	 * @description : scroll to the top of a web page
	 * 
	 * @param : NA
	 * 
	 * @return : NA
	 * 
	 * @date: 10 Mar 2022
	 */

	public static void scrollToTop(WebDriver driver) {

		try {

			((JavascriptExecutor) driver)

					.executeScript("window.scrollTo(0, 0)");

		} catch (Exception e) {

			logger.warn(MarkupHelper.createLabel("scrollToTop Failed ", ExtentColor.RED));

			throw e;
		}
	}

	/*
	 * 
	 * @description : scroll to the bottom of a web page
	 * 
	 * @param : NA
	 * 
	 * @return : NA
	 * 
	 * @date: 10 Mar 2022
	 */

	public static void scrollToBottom(WebDriver driver) {

		try {

			((JavascriptExecutor) driver)

					.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		} catch (Exception e) {

			logger.warn(MarkupHelper.createLabel("scrollToBottom Failed ", ExtentColor.RED));

			throw e;
		}
	}

	/*
	 * 
	 * @description : upload file using the tool AutoIT
	 * 
	 * @param : Relative path of AutoIT executable file
	 * 
	 * @return : NA
	 * 
	 * @date : 16 MAR 2022
	 * 
	 */
	public static void uploadFile(String filePath) throws Exception {

		try {
			Runtime.getRuntime().exec(SystemPath + filePath);

		} catch (Exception e) {

			logger.warn(MarkupHelper.createLabel("uploadFile Failed ", ExtentColor.RED));

			e.printStackTrace();

			throw e;
		}
	}

	/*
	 * 
	 * @description : Method to Check the file from a specific directory
	 * 
	 * @param : NA
	 * 
	 * @return : NA
	 * 
	 * @date: 21 Mar 2022
	 */
	public static boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().equals(fileName))
				return flag = true;
		}

		return flag;
	}

	/* Check the file from a specific directory with extension */
	public static boolean isFileDownloaded_Ext(String dirPath, String ext) {
		boolean flag = false;
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			flag = false;
		}

		for (int i = 1; i < files.length; i++) {
			if (files[i].getName().contains(ext)) {
				flag = true;
			}
		}
		return flag;
	}

	public static String getcellvalue(String EXCEL_PATH_RESPONSE, String sheet, int row, int column) {
		String value = "";
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(EXCEL_PATH_RESPONSE));
			value = wb.getSheet(sheet).getRow(row).getCell(column).toString();

		} catch (Exception e) {
		}
		return value;
	}

	public static String getProperty(String CONFIG_PATH, String key) {
		String propery = "";
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(CONFIG_PATH));
		} catch (Exception e) {
		}
		return propery;
	}

	/*
	 * 
	 * @description : Method to take Current page screenshot
	 * 
	 * @param : screenshot path
	 * 
	 * @return : screenshot
	 * 
	 * @date: 28 Mar 2022
	 */
	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.focus();");

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		String destination = null;

		// Current page screenshot

		{

			TakesScreenshot ts = (TakesScreenshot) driver;

			File source = ts.getScreenshotAs(OutputType.FILE);

			destination = System.getProperty("user.dir") + "/TestResults/FailedTestsScreenshots/" + screenshotName
					+ dateName + ".png";

			File finalDestination = new File(destination);

			FileUtils.copyFile(source, finalDestination);

		}

//
//         // Full page screenshot
//
//         {
//
//                                         destination = System.getProperty("user.dir") + "/TestResults/FailedTestsScreenshots/"+screenshotName+dateName+".png";
//
//                                         Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
//
//                             ImageIO.write(fpScreenshot.getImage(),"PNG",new File(destination));
//
//         }

		return destination;

	}
}
