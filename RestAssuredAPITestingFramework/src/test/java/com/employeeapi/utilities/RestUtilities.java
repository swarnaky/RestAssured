package com.employeeapi.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtilities {
	
	public static String empName() {
		String generatedString = RandomStringUtils.randomAlphanumeric(1);
		return("Testing"+generatedString);
	}
	
	public static String empSal() {
		String generatedString = RandomStringUtils.randomNumeric(5);
		return(generatedString);
	}

	public static String empAge() {
		String generatedString = RandomStringUtils.randomNumeric(2);
		return(generatedString);
	}

	
}
