package org.example.fetchData;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.model.Employee;
import org.example.model.GetContentFromExcelSheets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Fetch {
    public void printSimply () throws IOException {
        File f = new File("src/main/resources/names.xlsx");
        FileInputStream fis = new FileInputStream(f);
        XSSFWorkbook excelWorkbook = new XSSFWorkbook(fis);
        XSSFSheet excelSheet = excelWorkbook.getSheetAt(0);
        int rows = excelSheet.getPhysicalNumberOfRows();//3
        int cols = excelSheet.getRow(0).getPhysicalNumberOfCells();//2
        String data[][]= new String[rows][cols];
        XSSFCell cell;
        for(int i =0 ; i< rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                cell = excelSheet.getRow(i).getCell(j);
                String cellContents=cell.getStringCellValue();
                data[i][j] = cellContents;
                System.out.println(data[i][j]);
            }
        }
        fis.close();
    }

    public void printWithMethod() {
        GetContentFromExcelSheets GCFE = new GetContentFromExcelSheets();
        List<Employee> employeeList = new ArrayList<Employee>();
        try {
            employeeList = GCFE.readBooksFromExcelFile("src/main/resources/names_salary.xlsx");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(employeeList);
    }

}
