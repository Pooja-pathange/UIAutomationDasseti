package com.diligend.BaseClass;

import java.io.IOException;
import java.io.PrintStream;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.xmlgraphics.util.WriterOutputStream;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.diligend.actiondriver.Common;
import com.diligend.utilities.EnvironmentConfig;
import com.diligend.utilities.Reporting;


public class DiligendBaseClass {

	/*
	 * public String Username = readconfig.getcientUserName(); public String
	 * Password = readconfig.getcientPassword();
	 */
	// making driver classs public to access driver class in reporting.java class
	public WebDriver driver;
	public static Logger logger;
	protected static ExtentReports extent;
	protected static ExtentTest extentLog;
	protected static String testName = "";
	protected static StringWriter requestWriter;
	protected static PrintStream requestCapture;
	protected String methodName;
	protected String country;
	protected int stockCountReportId;

	@BeforeSuite
	public void setUp() throws IOException {
		extent = Reporting.getExtentReport();
	}

	@Parameters({ "environment", "browser", "role" })
	@BeforeTest
	public void Browser_setup(@Optional("testing") String environemnt, String browser,String role) throws Exception {

		logger = Logger.getLogger("Diligend Portal");
		PropertyConfigurator.configure("Log4j.properties");
		String projectPath = System.getProperty("user.dir");

		ConfigFactory.setProperty("env", environemnt);
		EnvironmentConfig config = ConfigFactory.create(EnvironmentConfig.class);
		System.out.print(config.url());
		String URL = config.url();

		if (browser.equalsIgnoreCase("Chrome")) {
			logger = Logger.getLogger("Automation script execution started with chrome browser");

			System.out.println(" Executing on CHROME");

			System.setProperty("webdriver.chrome.driver", projectPath + "/Webdriver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(URL);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("Edge")) {
			logger = Logger.getLogger("Automation script execution started with Edge browser");
			System.out.println("Executing on IE");
			System.setProperty("webdriver.edge.driver", projectPath + "/Webdriver/msedgedriver.exe");
			driver = new EdgeDriver();
			driver.get(URL);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} else {
			logger.warn("user login failed....");
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
	}
	

	@BeforeMethod
	public void getMethodName(Method m) {
		methodName = m.getName();
		requestWriter = new StringWriter();
		requestCapture = new PrintStream(new WriterOutputStream(requestWriter), true);
		// com.diligend.utilities.TestConstants.REQUESTCAPTURE = requestCapture;
		String packageName = this.getClass().getPackage().getName();
		testName = this.getClass().getSimpleName() + " : " + m.getName();
		extentLog = extent.createTest(testName, m.getAnnotation(Test.class).description())
				.assignCategory(packageName.substring(packageName.lastIndexOf(".") + 1));
	}

	@AfterMethod

	public void getResult(ITestResult result) throws Exception {

		try {

			if (result.getStatus() == ITestResult.SUCCESS) {

				extentLog.pass(MarkupHelper.createLabel(result.getName() + "  PASSED", ExtentColor.GREEN));

				System.out.println("     " + result.getName() + " : PASSED");

			}

			else if (result.getStatus() == ITestResult.FAILURE) {

//                                  	   extentLog.log(Status.FAIL,
//                            					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
//                             			extentLog.log(Status.FAIL,
//                            					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

				extentLog.info(MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));

				extentLog.fail(result.getThrowable());

				// String screenshotPath =
				// ScreenshotUtility.getScreenShot(driver,result.getName());
				String screenshotPath = Common.getScreenshot(driver, result.getName());

				extentLog.addScreenCaptureFromPath(screenshotPath);

				System.out.println("     " + result.getName() + " : FAILED");

			}

			else if (result.getStatus() == ITestResult.SKIP) {

				extentLog.skip(MarkupHelper.createLabel(result.getName() + " SKIPPED", ExtentColor.BLUE));

				System.out.println("     " + result.getName() + " : SKIPPED");

			}

		}

		// fails the execution if IO Exception occurs

		catch (IOException e) {

			e.printStackTrace();

			throw e;

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	@AfterTest
	public void afterTest() {

		try {

			driver.quit(); 

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	/*
	 * @AfterTest public void afterSuite(ITestContext context) { System.out.
	 * println("in after test************************************************"); //
	 * EmailUtility.sendEmail(context); driver.close();
	 * 
	 * }
	 */

	/*
	 * 
	 * @description : publish the extent report, kill the browser threads
	 * 
	 * @param : test result details as ITestResult instance
	 * 
	 * @return : NA
	 * 
	 * @date : 11 Oct 2022
	 * 
	 * @author : Abhilasha
	 * 
	 */

	@AfterSuite

	@Parameters("browser")

	public void tearDownReport(String browser) throws Exception {

		try {

			extent.flush();

			driver.quit();

			if (browser.equalsIgnoreCase("Edge")) {

				Runtime.getRuntime().exec("taskkill /F /IM msedgedriver.exe");

			}

			else if (browser.equalsIgnoreCase("Chrome")) {

				Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");

			}

			else if (browser.equalsIgnoreCase("firefox")) {

				Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");

			}

		}
		// fails the execution if IO Exception occurs

		catch (IOException e) {

			e.printStackTrace();

			throw e;
		}

		catch (Exception e) {

			e.printStackTrace();

			throw e;

		}

	}

}