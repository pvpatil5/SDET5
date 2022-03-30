package com.practice;

import org.testng.annotations.Test;

import com.generic.ExcelUtil;
import com.generic.IAutoConstatnts;

public class Sample {

	@Test
	public void launchbrowser() throws Throwable 
	{
		ExcelUtil excelUtil = new ExcelUtil();
		int lastrow=excelUtil.getRowCount(IAutoConstatnts.excelpath, "Sheet1");

		for (int i = 0; i <= lastrow; i++) 
		{
			System.out.println(excelUtil.readStringdatafromExcel(IAutoConstatnts.excelpath, "Sheet1", i, 0));
		}
	}
}
