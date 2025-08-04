import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadExcel {

    public static Workbook getAppropriateWorkbook(File file) {
        FileInputStream excelFile = null;
        Workbook workbook = null;
        try {
            excelFile = new FileInputStream(file);
            workbook = new XSSFWorkbook(excelFile);
        } catch (Exception e1) {
            Logger.getLogger(ReadExcel.class.getName()).log(Level.INFO, null, e1);
            try {
                if (workbook != null) {
                    workbook.close();
                }
                if (excelFile != null) {
                    excelFile.close();
                }
                excelFile = new FileInputStream(file);
                workbook = new HSSFWorkbook(excelFile);
                return workbook;
            } catch (Exception e2) {
                Logger.getLogger(ReadExcel.class.getName()).log(Level.SEVERE, null, e2);
            }
        }
        return workbook;
    }

    public static List<Employee> readEmployeesFromExcel(File file) throws Exception {
        List<Employee> list = new ArrayList<>();
        String[] values = new String[4];
        Workbook workbook = getAppropriateWorkbook(file);
        Sheet datatypeSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = datatypeSheet.iterator();
        boolean isHeaderRow = true;
        while (iterator.hasNext()) {
            Row currentRow = iterator.next();
            if (isHeaderRow) {
                isHeaderRow = false;
                continue;
            }
            Iterator<Cell> cellIterator = currentRow.iterator();
            int i = 0;
            while (cellIterator.hasNext()) {
                Cell currentCell = cellIterator.next();
                if (currentCell.getCellType() == CellType.NUMERIC) {
                    values[i++] = String.valueOf((int) currentCell.getNumericCellValue());
                } else {
                    values[i++] = currentCell.getStringCellValue();
                }
            }
            if (values[0] == null || values[0].equals("")) {
                break;
            }
            Employee a = new Employee();
            a.setId(Integer.parseInt(values[0]));
            a.setName(values[1]);
            a.setDepartment(values[2]);
            a.setSalary(Double.parseDouble(values[3]));
            list.add(a);
        }
        return list;
    }
}
