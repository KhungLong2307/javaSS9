package ra.presentation;
import ra.businessImp.Employee;
import ra.display.MainDisplay;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EmployeeManagement {
    static List<Employee> employee = new ArrayList<Employee>();
    static MainDisplay display = new MainDisplay();
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        do{
            display.menuDisplay01();
            int choice = display.takeChoice(sc);
            switch (choice){
                case 1:
                    int indexAdd = display.indexAdd(sc);
                    for (int i=0;i<indexAdd;i++){
                        System.out.println("Nhân viên "+(i+1)+":");
                        Employee employee1 = new Employee();
                        employee1.inputData(sc,employee);
                        employee.add(employee1);
                    }
                    break;
                case 2:
                    display.case2Display();
                    employee.forEach(Employee::displayData);
                    break;
                case 3:
                    display.case3Display();
                    employee.forEach(Employee::calSalary);
                    break;
                case 4:
                    String userName = display.case4Display(sc);
                    for(int i=0;i<employee.size();i++){
                     Employee employee1 = new Employee();
                     employee1 = employee.get(i);
                     if(employee1.getName().toLowerCase().contains(userName.toLowerCase())){
                         employee1.findName();
                     }
                    }
                    break;
                case 5:
                    display.case5Display(sc,employee);
                    break;
                case 6:
                    display.case6Display(sc,employee);
                    break;
                case 7:
                    display.case7Display(sc,employee);
                    break;
                case 8:
                    display.case8Display(sc,employee);
                    break;
                case 9:
                    display.case9Display(sc,employee);
                    break;
                case 10:
                    System.exit(0);
            }
        }while (true);
    }
}
