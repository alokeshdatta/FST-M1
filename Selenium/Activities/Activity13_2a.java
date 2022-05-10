package selenium_activities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Activity13_2a {

	public void writeExcel(String filePath) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("Sheet1");

		List<String[]> data = new ArrayList<String[]>();
		String[] heading = { "ID", "First Name", "Last Name", "Email", "Ph.No." };
		String[] row1 = { "1", "Test", "Cust1", "testcust1@example.com", "1112223331" };
		String[] row2 = { "2", "Test", "Cust2", "testcust2@example.com", "1112223332" };
		String[] row3 = { "3","Test", "Cust3", "testcust3@example.com", "1112223333"  };

		data.add(heading);
		data.add(row1);
		data.add(row2);
		data.add(row3);

		// Iterate read write
		int rownum = 0;
		for (String[] rowData : data) {
			// Creates a new row in the sheet
			Row row = sheet.createRow(rownum++);
			int cellnum = 0;
			for (String cellData : rowData) {
				// Creates a cell in the next column of that row
				Cell cell = row.createCell(cellnum++);
				cell.setCellValue(cellData);
			}
		}
		try {

			FileOutputStream out = new FileOutputStream(new File(filePath));
			workbook.write(out);
			out.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readExcel(String filePath) {
		try {
			FileInputStream file = new FileInputStream(filePath);

			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {
					case NUMERIC:
						System.out.print(cell.getNumericCellValue() + " \t ");
						break;
					case STRING:
						System.out.print(cell.getStringCellValue() + " \t ");
						break;
					default:
						System.out.println("Invalid value");
						break;
					}
				}
				System.out.println("");
			}
			file.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) throws IOException {

		String filePath = "src/resources/sampleReadTest.xlsx";

		Activity13_2a objExcelFile = new Activity13_2a();

		objExcelFile.writeExcel(filePath);

		objExcelFile.readExcel(filePath);
	}

}