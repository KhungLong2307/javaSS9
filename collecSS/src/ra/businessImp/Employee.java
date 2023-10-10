package ra.businessImp;

import ra.business.IEmployee;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Employee implements IEmployee {
    private String id;
    private String name;
    private int year;
    private float rate;
    private float commission;
    private float salary;
    private boolean status;

    public Employee(String id, String name, int year, float rate, float commission, float salary, boolean status) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.rate = rate;
        this.commission = commission;
        this.salary = salary;
        this.status = status;
    }

    public Employee() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(Scanner sc, List<Employee> employeeList){
        do {
            boolean isCheck = false;
            System.out.println("Hãy nhập mã nhân viên");
            System.out.println("(Gồm 4 ký tự, chữ cái đầu viết hoa)");
            this.id = sc.nextLine();
            if(this.id.length()!=4||!Pattern.matches("[A-Z]",this.id.substring(0,1))){
                System.err.println("Mã nhân viên không hợp lệ!");
                System.out.println();
            }
            else {
                for(int i=0;i<employeeList.size();i++){
                    Employee employee1 = employeeList.get(i);
                    if(employee1.getId().equals(this.id)){
                        isCheck = true;
                        break;
                    }
                }
                if(isCheck){
                    System.err.println("Mã nhân viên đã tồn tại!");
                    System.out.println();
                }
                else {
                    break;
                }
            }
        }while (true);
        do{
            System.out.println("Hãy nhập tên nhân viên");
            this.name = sc.nextLine();
            if(this.name.length()>50||this.name.length()<10){
                System.err.println("Tên nhân viên nằm trong khoảng 10-50 ký tự!");
                System.out.println();
            }
            else{
                break;
            }
        }while (true);
        do{
            System.out.println("Hãy nhập năm sinh");
            String inputData = sc.nextLine();
            SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy");
            Calendar c = Calendar.getInstance();
            int curr_date = Integer.parseInt(DateFormat.format(c.getTime()));
            if(!Pattern.matches("\\d+",inputData)||Integer.parseInt(inputData)>=curr_date){
                System.err.println("Năm sinh không hợp lệ");
                System.out.println();
            }
            else {
                this.year = Integer.parseInt(inputData);
                break;
            }
        }while (true);
        do{
            System.out.println("Hãy nhập hệ số lương nhân viên!");
            String inputData = sc.nextLine();
            if(Pattern.matches("\\d+[.]\\d+",inputData)||Pattern.matches("\\d+",inputData)){
                this.rate = Float.parseFloat(inputData);
                break;
            }
            else {
                System.err.println("Hệ số lương không hợp lệ!");
                System.out.println();
            }
        }while (true);
        do{
            System.out.println("Hãy nhập hoa hông nhân viên hàng tháng!");
            String inputData = sc.nextLine();
            if(Pattern.matches("\\d+[.]\\d+",inputData)||Pattern.matches("\\d+",inputData)){
                this.commission = Float.parseFloat(inputData);
                break;
            }
            else {
                System.err.println("Hoa hồng không hợp lệ!");
                System.out.println();
            }
        }while (true);
        do{
            System.out.println("Trạng thái nhân viên!");
            System.out.println("1. Đang làm viên");
            System.out.println("2. Nghỉ việc");
            String inputData= sc.nextLine();
            if(!Pattern.matches("[12]",inputData)){
                System.err.println("Trạng thái không hợp lệ!");
                System.out.println();
            }
            else {
                if(Integer.parseInt(inputData)==1){
                    this.status = true;
                }
                else {
                    this.status = false;
                }
                break;
            }
        }while (true);
    }
    public void displayData(){
        System.out.printf("|%s|",this.id);
        System.out.printf("%s",this.name);
        for (int i=0;i<(50-this.name.length());i++){
            System.out.print(" ");
        }
        System.out.printf("|%d|",this.year);
        System.out.printf("%.2f|",this.rate);
        System.out.printf("%.7f|",this.commission);
        if(this.status){
            System.out.print("Đang làm việc|");
        }
        else {
            System.out.print("Nghỉ việc    |");
        }
        System.out.println();
        System.out.println("+----+--------------------------------------------------+----+----+---------+-------------+");
    }
    public void calSalary(){
        this.salary= rate*BASIC_SALARY +commission;
        System.out.printf("|%s|",this.id);
        System.out.printf("%s",this.name);
        for (int i=0;i<(50-this.name.length());i++){
            System.out.print(" ");
        }
        System.out.print("|");
        System.out.print(this.salary);
        for(int i=0;i<(30-String.valueOf(this.salary).length());i++){
            System.out.print(" ");
        }
        System.out.print("|");
        System.out.println();
        System.out.println("+----+--------------------------------------------------+------------------------------+");
    }
    public void findName(){
        System.out.printf("|%s|",this.id);
        System.out.printf("%s",this.name);
        for (int i=0;i<(50-this.name.length());i++){
            System.out.print(" ");
        }
        System.out.print("|");
        System.out.println();
        System.out.println("+----+--------------------------------------------------+");
    }
    public void update(Scanner sc){
        do{
            System.out.println("Hãy nhập tên nhân viên");
            this.name = sc.nextLine();
            if(this.name.length()>50||this.name.length()<10){
                System.err.println("Tên nhân viên nằm trong khoảng 10-50 ký tự!");
                System.out.println();
            }
            else{
                break;
            }
        }while (true);
        do{
            System.out.println("Hãy nhập năm sinh");
            String inputData = sc.nextLine();
            SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy");
            Calendar c = Calendar.getInstance();
            int curr_date = Integer.parseInt(DateFormat.format(c.getTime()));
            if(!Pattern.matches("\\d+",inputData)||Integer.parseInt(inputData)>=curr_date){
                System.err.println("Năm sinh không hợp lệ");
                System.out.println();
            }
            else {
                this.year = Integer.parseInt(inputData);
                break;
            }
        }while (true);
        do{
            System.out.println("Hãy nhập hệ số lương nhân viên!");
            String inputData = sc.nextLine();
            if(Pattern.matches("\\d+[.]\\d+",inputData)||Pattern.matches("\\d+",inputData)){
                this.rate = Float.parseFloat(inputData);
                break;
            }
            else {
                System.err.println("Hệ số lương không hợp lệ!");
                System.out.println();
            }
        }while (true);
        do{
            System.out.println("Hãy nhập hoa hông nhân viên hàng tháng!");
            String inputData = sc.nextLine();
            if(Pattern.matches("\\d+[.]\\d+",inputData)||Pattern.matches("\\d+",inputData)){
                this.commission = Float.parseFloat(inputData);
                break;
            }
            else {
                System.err.println("Hoa hồng không hợp lệ!");
                System.out.println();
            }
        }while (true);
        do{
            System.out.println("Trạng thái nhân viên!");
            System.out.println("1. Đang làm viên");
            System.out.println("2. Nghỉ việc");
            String inputData= sc.nextLine();
            if(!Pattern.matches("[12]",inputData)){
                System.err.println("Trạng thái không hợp lệ!");
                System.out.println();
            }
            else {
                if(Integer.parseInt(inputData)==1){
                    this.status = true;
                }
                else {
                    this.status = false;
                }
                break;
            }
        }while (true);
    }
}
