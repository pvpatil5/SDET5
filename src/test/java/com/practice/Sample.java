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
			int sal=excelUtil.readNumericdatafromExcel(IAutoConstatnts.excelpath, "Sheet1", i, 1);

			if(sal>=32000) {
				String name=excelUtil.readStringdatafromExcel(IAutoConstatnts.excelpath, "Sheet1", i, 0);

				System.out.println(name);
			}
		}
	}
}
