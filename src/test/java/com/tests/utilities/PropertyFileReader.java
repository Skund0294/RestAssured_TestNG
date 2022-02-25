package com.tests.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

	public static String readPropertyFile(String key) {

		String result = "";
		FileInputStream fis = null;

		Properties prop = new Properties();
		String filename = "config.properties";
		String filepath = "src/test/resources/Resources/";
		
		try {
			fis = new FileInputStream(filepath + filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		result = prop.getProperty(key);

		return result;

	}

}