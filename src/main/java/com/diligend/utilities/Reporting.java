package com.diligend.utilities;

//Listener class used to generate Extent reports

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.diligend.BaseClass.DiligendBaseClass;

public class Reporting extends TestListenerAdapter {
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static ExtentTest logger;
	static String timeStamp;
	static String testName = "";
	static String environment;
	static String envUrl;
	final static String current_Platform = System.getProperty("os.name");
	
	
	public static ExtentReports getExtentReport() throws IOException {
		return setExtentReport();
	}


	private static ExtentReports setExtentReport() throws IOException {
		String exeTime = new SimpleDateFormat("yyyyMMMdd_hh.mma").format(new Date());
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/TestResults/"+"TestResults_Diligend-AutomationReport"+exeTime+".html");
        //htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Diligend-AutomationReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Environment", current_Platform);
        htmlReporter.config().setDocumentTitle("DUDE Automation-Report");
        htmlReporter.config().setReportName("DUDE Automation Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setTheme(Theme.DARK);
        return extent;
		
	}
}

