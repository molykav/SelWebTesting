package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	public static Workbook wb;
	public static Sheet s;
	public static int rowCount;
	public static int colCount;

	ExcelUtils(String excelPath, String sheetName){

		try {
			FileInputStream fis = new FileInputStream(excelPath); 
			wb = WorkbookFactory.create(fis);
			s = wb.getSheet(sheetName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	public static int getRowCount() {
		rowCount = 0;
		try {
			rowCount = s.getPhysicalNumberOfRows();
			System.out.println("Row count: "+rowCount);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return rowCount;

	}
	public static int getColCount() {
		colCount = 0;
		try {
			colCount = s.getRow(rowCount-1).getPhysicalNumberOfCells();
			System.out.println("Col count: "+colCount);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return colCount;

	}

	public static String getCellValue(int rowNum, int colNum) {
		String cellData=null;
		try {
			cellData = s.getRow(rowNum).getCell(colNum).getStringCellValue();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return cellData;
	}
}