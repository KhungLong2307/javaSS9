package ra.display;

import ra.businessImp.Employee;

import java.util.*;
import java.util.regex.Pattern;

public class MainDisplay {
    public void menuDisplay01(){
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|                      Menu                             |");
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|1. Nhập thông tin cho n nhân viên                      |");
        System.out.println("|2. Hiển thị thông tin nhân viên                        |");
        System.out.println("|3. Tính lương cho các nhân viên                        |");
        System.out.println("|4. Tìm kiếm nhân viên theo tên                         |");
        System.out.println("|5. Cập nhật thông tin nhân viên                        |");
        System.out.println("|6. Xóa nhân viên theo mã nhân viên                     |");
        System.out.println("|7. Sắp xếp nhân viên theo lương tăng dần               |");
        System.out.println("|8. Sắp xếp nhân viên theo tên nhân viên giảm dần       |");
        System.out.println("|9. Sắp xếp nhân viên theo năm sinh tăng dần            |");
        System.out.println("|10. thoát                                              |");
        System.out.println("+-------------------------------------------------------+");
    }
    public int takeChoice(Scanner sc){
        String choice;
        do{
            System.out.print("Lựa chọn chức năng: ");
            choice = sc.nextLine();
            if(!Pattern.matches("\\d+",choice)||Integer.parseInt(choice)>10||Integer.parseInt(choice)<1){
                System.err.println("Chức năng không hợp lệ!");
                System.out.println();
            }else {
                break;
            }
        }while (true);
        return Integer.parseInt(choice);
    }
    public int indexAdd(Scanner sc){
        String indexAdd = "0";
        do{
            System.out.print("Hãy nhập số nhân viên muốn thêm: ");
            indexAdd = sc.nextLine();
            if(!Pattern.matches("\\d+",indexAdd)||Integer.parseInt(indexAdd)<0){
                System.err.println("Số nhân viên nhập vào không hợp lệ!");
                System.out.println();
            }else {
                break;
            }
        }while (true);
        return Integer.parseInt(indexAdd);
    }
    public void case2Display(){
        System.out.println("+----+--------------------------------------------------+----+----+---------+-------------+");
        System.out.println("|ID  |Name                                              |Year|Rate|Commision|Status       |");
        System.out.println("+----+--------------------------------------------------+----+----+---------+-------------+");
    }
    public void case3Display(){
        System.out.println("+----+--------------------------------------------------+------------------------------+");
        System.out.println("|ID  |Name                                              |Salary                        |");
        System.out.println("+----+--------------------------------------------------+------------------------------+");
    }
    public String case4Display(Scanner sc){
        String inputData = "";
        do{
            System.out.print("Hãy nhập tên nhân viên muốn tìm: ");
            inputData = sc.nextLine();
            if(inputData.length()>10||inputData.length()<50){
                break;
            }
        }while (true);
        System.out.println("+----+--------------------------------------------------+");
        System.out.println("|ID  |Name                                              |");
        System.out.println("+----+--------------------------------------------------+");
        return inputData;
    }
    public void case5Display(Scanner sc,List<Employee> employee){
            boolean isExit = true;
            do{
                boolean isCheck = false;
                System.out.print("Nhập mã nhân viên cần cập nhật: ");
                String inputData = sc.nextLine();
                if(inputData.length()!=4){
                    System.err.println("Mã nhân viên không hợp lê!");
                    System.out.println();
                }
                else {
                    isExit = false;
                }
                for (int i=0;i<employee.size();i++){
                    Employee employee1 = employee.get(i);
                    if(employee1.getId().equals(inputData)){
                        System.out.println("+----+--------------------------------------------------+----+----+---------+-------------+");
                        System.out.println("|ID  |Name                                              |Year|Rate|Commision|Status       |");
                        System.out.println("+----+--------------------------------------------------+----+----+---------+-------------+");
                        employee1.displayData();
                        employee1.update(sc);
                        isCheck = true;
                        break;
                    }
                }
                if(!isCheck){
                    System.err.println("Không tìm thấy mã nhân viên");
                    System.out.println();
                }
                else {
                    isExit = false;
                }
            }while (isExit);
    }
    public void case6Display(Scanner sc,List<Employee> employeeList) throws InterruptedException {
        boolean isExit = true;
        do{
            boolean isCheck = false;
            System.out.print("Nhập mã nhân viên muốn xóa!: ");
            String inputData = sc.nextLine();
            if(inputData.length()!=4){
                System.err.println("Mã nhân viên không hợp lê!");
                System.out.println();
            }
            else {
                isExit = false;
            }
            for(int i=0;i<employeeList.size();i++){
                Employee employee1 = employeeList.get(i);
                if(employee1.getId().equals(inputData)){
                    isCheck = true;
                    do{
                        System.out.println("Bạn có chắc muốn xóa nhân viên "+employee1.getName());
                        System.out.println("1. Có");
                        System.out.println("2. Không");
                        String input= sc.nextLine();
                        if(!Pattern.matches("[12]",input)){
                            System.err.println("Không hợp lệ!");
                            System.out.println();
                        }
                        else {
                            if(Integer.parseInt(input)==1){
                                employeeList.remove(i);
                                break;
                            }
                            else {
                                break;
                            }
                        }
                    }while (true);
                }
            }
            if(!isCheck){
                Thread.sleep(1000);
                System.err.println("Không tìm thấy mã nhân viên");
                System.out.println();
            }
        }while (isExit);
    }
    public void case7Display(Scanner sc,List<Employee> employeeList){
        List<Employee> copy = new ArrayList<Employee>();
        copy.addAll(employeeList);
        Comparator<Employee> com = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if(o1.getSalary()>o2.getSalary()){
                    return 1;
                }
                else {
                    return -1;
                }
            }
        };
        Collections.sort(copy,com);
        System.out.println("+----+--------------------------------------------------+------------------------------+");
        System.out.println("|ID  |Name                                              |Salary                        |");
        System.out.println("+----+--------------------------------------------------+------------------------------+");
        copy.forEach(Employee::calSalary);
    }
    public void case8Display(Scanner sc,List<Employee> employeeList){
        List<Employee> copy = new ArrayList<Employee>();
        copy.addAll(employeeList);
        Comparator<Employee> com = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return -o1.getName().compareTo(o2.getName());
            }
        };
        Collections.sort(copy,com);
        System.out.println("+----+--------------------------------------------------+----+----+---------+-------------+");
        System.out.println("|ID  |Name                                              |Year|Rate|Commision|Status       |");
        System.out.println("+----+--------------------------------------------------+----+----+---------+-------------+");
        copy.forEach(Employee::displayData);
        copy.clear();
    }
    public void case9Display(Scanner sc,List<Employee> employeeList){
        List<Employee> copy = new ArrayList<Employee>();
        copy.addAll(employeeList);
        Comparator<Employee> com = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if(o1.getYear()>o2.getYear()){
                    return 1;
                }
                else {
                    return -1;
                }
            }
        };
        Collections.sort(copy,com);
        System.out.println("+----+--------------------------------------------------+----+----+---------+-------------+");
        System.out.println("|ID  |Name                                              |Year|Rate|Commision|Status       |");
        System.out.println("+----+--------------------------------------------------+----+----+---------+-------------+");
        copy.forEach(Employee::displayData);
        copy.clear();
    }
}
