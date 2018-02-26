package com.appium.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	public static void loadExcelData(String Path, String SheetName) throws IOException {

		FileInputStream file = new FileInputStream(new File(Path));

		ExcelWBook = new XSSFWorkbook(file);

		ExcelWSheet = ExcelWBook.getSheet(SheetName);

	}

	public static String getCellValue(int RowNum, int ColNum) {

		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

		String CellData = Cell.getStringCellValue();

		return CellData;

	}

}
