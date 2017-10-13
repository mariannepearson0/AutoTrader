/**
 * Created by Administrator on 13/10/2017.
 */

//package Functionality;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Spreadsheet {

        private Workbook workbook;

        public Spreadsheet (String pathName)
        {
            try
            {
                FileInputStream excelFile = new FileInputStream(new File(pathName));
                workbook = new XSSFWorkbook(excelFile);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        public void writeRow(int rowNumber, String sheetName, int cellNumber, String pathname){
            Sheet dataTypeSheet = workbook.getSheet(sheetName);
            Row currentRow = dataTypeSheet.getRow(rowNumber);
            Cell currentCell = currentRow.getCell(cellNumber);
            String emailStart = currentCell.getStringCellValue();
            Integer newEmailno = Integer.parseInt(emailStart) + 1;
            String newEmail = newEmailno.toString();
            currentCell.setCellValue(newEmail);
            FileOutputStream out = null;
            try {
                out = new FileOutputStream(new File(pathname));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                workbook.write(out);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //return currentCell;
        }

        public List<String> readRow(int rowNumber, String sheetName)
        {
            List<String> row = new ArrayList<String>();
            Sheet dataTypeSheet = workbook.getSheet(sheetName);
            Row currentRow = dataTypeSheet.getRow(rowNumber);
            for (Cell currentCell : currentRow)
            {
                switch (currentCell.getCellTypeEnum())
                {
                    case STRING:
                        row.add(currentCell.getStringCellValue());
                        break;
                    case NUMERIC:
                        row.add(String.valueOf(currentCell.getNumericCellValue()));
                        break;
                    case BOOLEAN:
                        row.add(String.valueOf(currentCell.getBooleanCellValue()));
                        break;
                    case FORMULA:
                        row.add(currentCell.getCellFormula());
                        break;
                    case ERROR:
                        System.out.println("Error In Cell");
                        break;
                    case BLANK:
                        row.add(currentCell.getStringCellValue());
                        break;
                    case _NONE:
                        System.out.println("No Value In Cell");
                        break;
                }
            }
            return row;
        }
}

