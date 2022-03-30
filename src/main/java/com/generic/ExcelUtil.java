package com.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil 
{

	/**
	 * @author AMAR-G
	 * This me thod willl help u to rad data from excel
	 * @param path
	 * @param name
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 */

	public String readStringdatafromExcel(String path,String name, int rownum, int cellnum) throws Throwable {

		FileInputStream fis = new FileInputStream(path);
		Workbook workbook = WorkbookFactory.create(fis);
		String value = workbook.getSheet(name).getRow(rownum).getCell(cellnum).getStringCellValue();
		return value;

	}

	public int readNumericdatafromExcel(String path,String name, int rownum, int cellnum) throws Throwable {

		FileInputStream fis = new FileInputStream(path);
		Workbook workbook = WorkbookFactory.create(fis);
		int value = (int) workbook.getSheet(name).getRow(rownum).getCell(cellnum).getNumericCellValue();
		return value;

	}

	public int getRowCount(String path,String name) throws Throwable
	{

		FileInputStream fis = new FileInputStream(path);
		Workbook workbook = WorkbookFactory.create(fis);

		return	workbook.getSheet(name).getLastRowNum();

	}
}
