package ra.businessImp;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Categories implements IShop{
    private int id = 0;
    private String name;
    private String descriptions;
    private boolean status = false;
    private int isNum = 0;

    public Categories() {
    }

    public Categories(int id, String name, String descriptions, boolean status) {
        this.id = id;
        this.name = name;
        this.descriptions = descriptions;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getIsNum() {
        return isNum;
    }

    public void setIsNum(int isNum) {
        this.isNum = isNum;
    }

    public void inputData(Scanner sc, List<Categories> categoriesList,List<Product> productList){
        this.id = categoriesList.size()+1;
        do{
            boolean isCheck = true;
            System.out.println("Hãy nhập tên danh mục!");
            this.name = sc.nextLine();
            if(this.name.length()<=0||this.name.length()>30){
                System.out.println("\u001B[31m"+"Tên danh mục đang để trống hoặc quá dài! Hãy nhập lại"+"\u001b[0m");
                isCheck = false;
            }
            else {
                for(int i=0;i<categoriesList.size();i++){
                    Categories check = categoriesList.get(i);
                    if(check.getName().equals(this.name)){
                        System.out.println("\u001B[31m"+"Tên danh mục đã tồn tại"+"\u001B[0m");
                        isCheck = false;
                        break;
                    }
                }
            }
            if(isCheck){
                break;
            }
        }while (true);
        do{
            System.out.println("Hãy nhập mô tả!");
            this.descriptions = sc.nextLine();
            if(this.descriptions.length()<=0||this.descriptions.length()>40){
                System.out.println("\u001B[31m"+"Mổ tả đang để trống hoặc quá dài!"+"\u001B[0m");
            }else {
                break;
            }
        }while (true);
        do{
            System.out.println("Hãy chọn trạng thái!");
            System.out.println("1. Hoạt động");
            System.out.println("2. Không hoạt động");
             String inputData = sc.nextLine();
             if(!Pattern.matches("[12]",inputData)){
                 System.out.println("\u001B[31m"+"Lựa chọn không hợp lệ!"+"\u001B[0m");
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
        if(this.id>=1000){
            System.out.printf("|%d|",this.id);
        }
        else if(this.id>=100){
            System.out.printf("| %d|",this.id);
        } else if (this.id>=10) {
            System.out.printf("|  %d|",this.id);
        }
        else {
            System.out.printf("|   %d|",this.id);
        }
        System.out.printf("%s",this.name);
        for(int i=0;i<(30-this.name.length());i++){
            System.out.print(" ");
        }
        System.out.printf("|%s",this.descriptions);
        for(int i=0;i<(40-this.descriptions.length());i++){
            System.out.print(" ");
        }
        if(isStatus()){
            System.out.println("|Hoạt động      |");
        }
        else {
            System.out.println("|Không hoạt động|");
        }
        System.out.print("+----+------------------------------+----------------------------------------+---------------+");
        System.out.println();
    }
    public void updateData(Scanner sc){
        do{
            System.out.println("Hãy nhập mô tả!");
            this.descriptions = sc.nextLine();
            if(this.descriptions.length()<=0||this.descriptions.length()>40){
                System.out.println("\u001B[31m"+"Mổ tả đang để trống hoặc quá dài!"+"\u001B[0m");
            }else {
                break;
            }
        }while (true);
        do{
            System.out.println("Hãy chọn trạng thái!");
            System.out.println("1. Hoạt động");
            System.out.println("2. Không hoạt động");
            String inputData = sc.nextLine();
            if(!Pattern.matches("[12]",inputData)){
                System.out.println("\u001B[31m"+"Lựa chọn không hợp lệ!"+"\u001B[0m");
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
