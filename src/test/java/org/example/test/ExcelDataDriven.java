package org.example.test;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelDataDriven {

    public ArrayList<String> getData(String sheetName, String headerRow, String rowName) throws Exception {

        String filePath = "E://Selenium Tools//Selenium Excel Data//DataDriven.xlsx";

        ArrayList<String> arrayList = new ArrayList<String>();

        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int sheets = workbook.getNumberOfSheets();

        for (int i = 0; i < sheets; i++) { // For Sheet Name

            if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                Iterator<Row> rows = sheet.iterator();
                Row rrow = rows.next();
                Iterator<Cell> cell = rrow.cellIterator();
                int k = 0;
                int column = 0;

                while (cell.hasNext()) { // For Header Row Name
                    Cell cellValue = cell.next();
                    if (cellValue.getStringCellValue().equalsIgnoreCase(headerRow)) {
                        column = k;
                    }
                    k++;
                }
                System.out.println("Column: " + column);

                while (rows.hasNext()) { // For Row Name
                    Row r = rows.next();
                    if (r.getCell(column).getStringCellValue().equalsIgnoreCase(rowName)) {
                        Iterator<Cell> c = r.cellIterator();


                        while (c.hasNext()) {  // For Cell Data
                            Cell cellValue = c.next();
                            if (cellValue.getCellType().equals(CellType.STRING)) {
                                arrayList.add(cellValue.getStringCellValue());
                            } else {
                                arrayList.add(NumberToTextConverter.toText(cellValue.getNumericCellValue()));
                            }
                        }
                    }
                }

            }
        }
        return arrayList;
    }
}