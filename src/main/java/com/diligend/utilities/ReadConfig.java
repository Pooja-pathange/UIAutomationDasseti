package com.diligend.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {
		File src = new File(System.getProperty("user.dir") + "/src/test/resources/testing.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getApplicationURL() {
		String url = pro.getProperty("url");
		return url;
	}

	public String getcientUserName() {
		String url = pro.getProperty("stageUrl");
		return url;
	}

	public String getcientPassword() {
		String url = pro.getProperty("demoUrl");
		return url;
	}
	
	
	
	
	
	

	/**
	 * responsible for fetching any value from property file depending upon the key
	 * argument and from any file depending upon the file name
	 * 
	 * @param propertyFileName
	 * @param key
	 * @return
	 */

	/*
	 * public static String returnPropVal(final String propertyFileName, final
	 * String key) { final Properties properties = new Properties(); String value =
	 * null; { try { properties.load(new FileInputStream(new File(
	 * System.getProperty("user.dir") + "/src/main/resources/" + propertyFileName +
	 * ".properties"))); // get PROPERTY value based on key: value =
	 * properties.getProperty(key);
	 * 
	 * } catch (final FileNotFoundException e) { e.printStackTrace();
	 * 
	 * } catch (final IOException e) { e.printStackTrace(); } } return value; }
	 * 
	 * public static String GetBaseUrl(String property) {
	 * 
	 * try (InputStream input =
	 * ReadConfig.class.getClassLoader().getResourceAsStream("config.properties")) {
	 * 
	 * Properties prop = new Properties();
	 * 
	 * if (input == null) {
	 * System.out.println("Sorry, unable to find config.properties"); return null; }
	 * 
	 * prop.load(input);
	 * 
	 * String url = prop.getProperty(property); return url;
	 * 
	 * } catch (IOException ex) { ex.printStackTrace(); } return null;
	 * 
	 * }
	 */

}
