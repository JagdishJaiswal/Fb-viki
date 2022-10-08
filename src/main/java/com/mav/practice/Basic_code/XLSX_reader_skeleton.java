package com.mav.practice.Basic_code;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSX_reader_skeleton {

	private static void particlarData() throws IOException {
		File f = new File(
				"C:\\Users\\VIGNESH S\\OneDrive\\Desktop\\TOOLS FOR STUDY\\Data Driven for Facebook\\Facebook data.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.getSheet("user&pwd");
		Row r = s.getRow(1);
		Cell c = r.getCell(1);
		CellType ce = c.getCellType();
		if (ce.equals(CellType.STRING)) {
			String st = c.getStringCellValue();
			System.out.println(st);
		} else if (ce.equals(CellType.NUMERIC)) {
			double d = c.getNumericCellValue();
			int a = (int) d;
			System.out.println(a);
		}
	}

	private static void allData() throws IOException {
		File f = new File(
				"C:\\Users\\VIGNESH S\\OneDrive\\Desktop\\TOOLS FOR STUDY\\Data Driven for Facebook\\Facebook data.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.getSheet("user&pwd");
		int rowsize = s.getPhysicalNumberOfRows();
		for (int i = 0; i < rowsize; i++) {
			Row r = s.getRow(i);
			int cellsize = r.getPhysicalNumberOfCells();
			for (int j = 0; j < cellsize; j++) {
				Cell c = r.getCell(j);
				CellType ce = c.getCellType();
				if (ce.equals(CellType.STRING)) {
					String st = c.getStringCellValue();
					System.out.print(st);
				} else if (ce.equals(CellType.NUMERIC)) {
					double d = c.getNumericCellValue();
					int a = (int) d;
					System.out.print(a);
				}
				System.out.print(" | ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		particlarData();
		allData();
	}
}
