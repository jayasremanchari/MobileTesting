package com.appium.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// TODO: Auto-generated Javadoc
/**
 * The Class ExcelUtils.
 */
public class ExcelUtils {

	/** The Excel w sheet. */
	private static XSSFSheet ExcelWSheet;

	/** The Excel w book. */
	private static XSSFWorkbook ExcelWBook;

	/** The Cell. */
	private static XSSFCell Cell;

	/**
	 * Load excel data.
	 *
	 * @param Path the path
	 * @param SheetName the sheet name
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void loadExcelData(String Path, String SheetName) throws IOException {

		FileInputStream file = new FileInputStream(new File(Path));

		ExcelWBook = new XSSFWorkbook(file);

		ExcelWSheet = ExcelWBook.getSheet(SheetName);

	}

	/**
	 * Gets the cell value.
	 *
	 * @param RowNum the row num
	 * @param ColNum the col num
	 * @return the cell value
	 */
	public static String getCellValue(int RowNum, int ColNum) {

		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

		String CellData = Cell.getStringCellValue();

		return CellData;

	}

}
