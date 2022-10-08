package com.mav.practice.Basic_code;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLXS_writer_skeleton {

	private static void writeData() throws IOException {
		File f = new File(
				"C:\\Users\\VIGNESH S\\OneDrive\\Desktop\\TOOLS FOR STUDY\\Data Driven for Facebook\\Facebook data.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.createSheet("write data");
		Row r = s.createRow(0);
		Cell c = r.createCell(0);
		c.setCellValue("v");
		w.getSheet("write data").createRow(1).createCell(1).setCellValue("i");
		w.getSheet("write data").createRow(2).createCell(2).setCellValue("k");
		w.getSheet("write data").createRow(3).createCell(3).setCellValue("i");

		FileOutputStream fo = new FileOutputStream(f);
		w.write(fo);
		w.close();
	}

	public static void main(String[] args) throws IOException {
		writeData();
	}
}
