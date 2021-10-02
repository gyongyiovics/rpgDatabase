package org.example.model;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetContentFromExcelSheets {
    private Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();

            case BOOLEAN:
                return cell.getBooleanCellValue();

            case NUMERIC:
                return cell.getNumericCellValue();
        }
        return null;
    }

    // Read the excel sheet contents and get the contents in
    // a list
    public List<Employee>
    readBooksFromExcelFile(String excelFilePath) throws IOException {
        List<Employee> listEmployees = new ArrayList<Employee>();
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();

        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator
                    = nextRow.cellIterator();
            Employee emp = new Employee();

            while (cellIterator.hasNext()) {
                Cell nextCell = cellIterator.next();
                int columnIndex = nextCell.getColumnIndex();
                if (columnIndex == 0) {
                    emp.setEmployeeName(getCellValue(nextCell).toString());
                    System.out.println();
                } else if (columnIndex == 1) {
                    emp.setPosition(getCellValue(nextCell).toString());
                } else if (columnIndex == 2) {
                    emp.setSalary(Double.parseDouble(getCellValue(nextCell).toString()));
                } else {
                    //emp.setSalary(getCellValue(nextCell).toString());
                    System.out.println("Could not read!");
                }
                /*switch (columnIndex) {
                    case 1:
                        emp.setEmployeeName(
                                (String) getCellValue(nextCell));
                        break;
                    case 2:
                        emp.setPosition(
                                (String) getCellValue(nextCell));
                        break;
                    //TODO: ez nem tetszik...
                    case 3:
                        emp.setSalary(
                                Double.valueOf((String) getCellValue(nextCell)));
                        break;
                }*/
            }
            listEmployees.add(emp);
        }

        //((FileInputStream) workbook).close();
        inputStream.close();

        return listEmployees;
    }
}