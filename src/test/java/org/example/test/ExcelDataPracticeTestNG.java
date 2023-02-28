package org.example.test;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;

public class ExcelDataPracticeTestNG {
    String filePath = "E://Selenium Tools//Selenium Excel Data//DataDriven.xlsx";

    DataFormatter dataFormatter = new DataFormatter();

    @Test(dataProvider = "ExcelData")
    public void testData(String userName, String passWord, String id) {
        System.out.println(userName + " " + passWord + " " + id);

    }

    @DataProvider(name = "ExcelData")
    public Object[][] getData() throws Exception {

        // For Excel File Path
        FileInputStream fileInputStream = new FileInputStream(filePath);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);

        // For Sheet Name and Row Count
        XSSFSheet sheet = xssfWorkbook.getSheetAt(1);
        int rowCount = sheet.getPhysicalNumberOfRows();

        // For Column Count
        XSSFRow row = sheet.getRow(0);
        int columnCount = row.getLastCellNum();

        Object data[][] = new Object[rowCount - 1][columnCount];


        for (int i = 0; i < rowCount - 1; i++) { // rowCount - 1 ( because in 1st row we get Header texts in the row, since its not required.
            row = sheet.getRow(i + 1);   // getRow(i+1) ( because i is 1st row where header texts are located so i + 1, to get the actual row data.

            for (int j = 0; j < columnCount; j++) {
                XSSFCell cell = row.getCell(j);
                data[i][j] = dataFormatter.formatCellValue(cell);

            }
        }
        return data;
    }
}
