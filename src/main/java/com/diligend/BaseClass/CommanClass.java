package com.diligend.BaseClass;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.diligend.utilities.ExcelUtilility;

public class CommanClass {
	
	
	
	@DataProvider(name = "loginData")
	public String[][] getdata() throws IOException {

		// get the data from excel

		String path = System.getProperty("user.dir") + "//src//test//resources//TestData//UserLogin.xlsx";

		System.out.println(path);

		ExcelUtilility xlutility = new ExcelUtilility(path);

		int totalrow = xlutility.getRowCount("Sheet1");
		int totalcols = xlutility.getCellCount("Sheet1", 1);

		String loginData[][] = new String[totalrow][totalcols];
		for (int i = 1; i <= totalrow; i++) {

			for (int j = 0; j < totalcols; j++) {
				loginData[i - 1][j] = xlutility.getCellData("Sheet1", i, j);
			}
		}
		return loginData;

	}


}
