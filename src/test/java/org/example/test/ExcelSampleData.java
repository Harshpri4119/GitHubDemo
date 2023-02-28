package org.example.test;

import java.util.ArrayList;

public class ExcelSampleData {
    public static void main(String[] args) throws Exception {

        ExcelDataDriven excelDataDriven = new ExcelDataDriven();

        ArrayList<String> data = excelDataDriven.getData("Test Data", "TestCases", "Login");

        for (int i =0; i<data.size(); i++){
            System.out.println(data.get(i));
        }
    }
}
