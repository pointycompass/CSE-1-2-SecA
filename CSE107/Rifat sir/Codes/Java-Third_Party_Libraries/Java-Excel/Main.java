import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        File fileToRead = new File("employees.xlsx");
        List<Employee> employeeList = ReadExcel.readEmployeesFromExcel(fileToRead);
        employeeList.forEach(e -> System.out.println(e));
        File fileToWrite = new File("employees-generated.xlsx");
        WriteExcel.writeEmployeesToExcel(employeeList, fileToWrite);
    }
}
