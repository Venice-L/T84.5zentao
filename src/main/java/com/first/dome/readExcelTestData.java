package com.first.dome;

import java.util.List;

import com.first.utils.ExeclUtils;
import com.first.utils.TestCase;

public class readExcelTestData {

	public static void main(String[] args) {
		String filePath=System.getProperty("user.dir")+"/testcasedata/UITestData.xlsx";
       
		List<TestCase> testcase=ExeclUtils.getUITestData(filePath);
		System.out.println(testcase.get(0).getCaseName());
		System.out.println(testcase.get(0).getTestdata().get("username"));
		System.out.println(testcase.get(0).getTestdata().get("password"));
	}

}
