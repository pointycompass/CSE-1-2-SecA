import java.io.File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteExcel {

    public static void writeEmployeesToExcel(List<Employee> list, File file) throws Exception {
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet sheet = workbook.createSheet("LotteryFile");
            int rowNum = 0;
            System.out.println("Creating excel");
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            String[] header = {"Id", "Name", "Department", "Salary"};
            for (String field : header) {
                Cell cell = row.createCell(colNum++);
                cell.setCellValue(field);
            }
            for (Employee a : list) {
                row = sheet.createRow(rowNum++);
                colNum = 0;
                Cell cell = row.createCell(colNum++);
                cell.setCellValue(a.getId());
                cell = row.createCell(colNum++);
                cell.setCellValue(a.getName());
                cell = row.createCell(colNum++);
                cell.setCellValue(a.getDepartment());
                cell = row.createCell(colNum++);
                cell.setCellValue(a.getSalary());
            }
            for (int i = 0; i < header.length; i++) {
                sheet.autoSizeColumn(i);
            }
            FileOutputStream outputStream = new FileOutputStream(file);
            workbook.write(outputStream);
        } catch (Exception e) {
            Logger.getLogger(WriteExcel.class.getName()).log(Level.SEVERE, e.toString());
        }
    }
}
