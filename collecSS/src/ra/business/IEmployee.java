package ra.business;

import ra.businessImp.Employee;

import java.util.List;
import java.util.Scanner;

public interface IEmployee {
    int  BASIC_SALARY = 1300000;
    void inputData(Scanner sc, List<Employee> employee);
    void displayData();

}
