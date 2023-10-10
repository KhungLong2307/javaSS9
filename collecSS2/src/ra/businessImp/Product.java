package ra.businessImp;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Product implements IShop{
    private String id;
    private String name;
    private int catalogId = 0;
    private float importPrice;
    private float exportPrice = this.importPrice*RATE;
    private boolean status;

    public Product() {
    }

    public Product(String id, String name, int catalogId, float importPrice, float exportPrice, boolean status) {
        this.id = id;
        this.name = name;
        this.catalogId = catalogId;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.status = status;
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

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public void inputData(Scanner sc) throws InterruptedException{

    }

    @Override
    public void inputData(Scanner sc, List<Categories> categoriesList,List<Product> productList){
        System.out.println("Hãy chọn danh mục sản phẩm cần thêm vào");
        for(int i=0;i<categoriesList.size();i++){
            Categories output = categoriesList.get(i);
            System.out.printf("%d-%s%n",output.getId(),output.getName());
        }
        do{
            System.out.print("Lựa chọn: ");
            String inputData = sc.nextLine();
            if(!Pattern.matches("\\d+",inputData)||Integer.parseInt(inputData)<=0||Integer.parseInt(inputData)>categoriesList.size()){
                System.out.println("\u001B{31m"+"Lựa chọn không hợp lệ! Hãy chọn lại"+"\u001B[0m");
            }
            else {
                Categories output = categoriesList.get(Integer.parseInt(inputData)-1);
                this.catalogId = output.getId();
                int incre = output.getIsNum()+1;
                output.setIsNum(incre);
                break;
            }
        }while (true);
        do{
            System.out.println("Hãy nhập mã sản phẩm!");
            this.id = sc.nextLine();
            if(this.id.length()!=4||!Pattern.matches("[P]",this.id.substring(0,1))){
                System.out.println("\u001B[31m"+"Mã sản phẩm không hợp lệ!"+"\u001B[0m");
            }else {
                boolean isCheck = true;
                for(int i=0;i<productList.size();i++){
                    Product check = productList.get(i);
                    if(check.getId().equals(this.id)){
                        System.out.println("\u001B[31m"+"Mã sản phẩm đã tồn tại! Hãy nhập lại!"+"\u001B[0m");
                        isCheck = false;
                        break;
                    }
                }
                if (isCheck) {
                    break;
                }
            }
        }while (true);
        do{
            System.out.println("Hãy nhập tên sản phẩm");
            this.name = sc.nextLine();
            if(this.name.length()<=0||this.name.length()>30){
                System.out.println("\u001B[31m"+"Tên sản phẩm quá dài hoặc quá ngắn"+"\u001B[0m");
            }
            else {
                break;
            }
        }while (true);
        do{
            System.out.println("Hãy nhập giá nhập sản phẩm");
            String inputData = sc.nextLine();
            if(Pattern.matches("\\d+",inputData)||Pattern.matches("\\d+[.]\\d{2}",inputData)){
                this.importPrice = Float.parseFloat(inputData);
                exportPrice = this.importPrice*RATE;
                break;
            }
            else {
                System.out.println("\u001B[31m"+"Giá nhập vào không hợp lệ! Hãy nhập lại"+"\u001B[0m");
                System.out.println("\u001B[31m"+"VD: 3.1=>3.10 hoặc 3.123123=>3.12"+"\u001B[0m");
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
        System.out.printf("|%s",this.id);
        System.out.printf("|%s",this.name);
        for(int i=0;i<(30-this.name.length());i++){
            System.out.printf(" ");
        }
        System.out.printf("|    %d",this.catalogId);
        for(int i=0;i<(6-String.valueOf(this.catalogId).length());i++){
            System.out.print(" ");
        }
        System.out.print("|");

        System.out.printf("%.2f",this.importPrice);
        for(int i=0;i<(16-String.valueOf((int)this.importPrice).length()-3);i++){
            System.out.print(" ");
        }
        System.out.print("|");
        System.out.printf("%.2f",this.exportPrice);
        for(int i=0;i<16-String.valueOf((int)calExportPrice()).length()-3;i++){
            System.out.print(" ");
        }
        System.out.print("|");
        if(this.status){
            System.out.print("Hoạt động      |");
        }else {
            System.out.print("Không hoạt động|");
        }
        System.out.println();
        System.out.println("+----+------------------------------+----------+----------------+----------------+---------------+");

    }
    public float calExportPrice(){
        return this.exportPrice;
    }
    public void updateData(Scanner sc){
        do{
            System.out.println("Hãy nhập tên sản phẩm");
            this.name = sc.nextLine();
            if(this.name.length()<=0||this.name.length()>30){
                System.out.println("\u001B[31m"+"Tên sản phẩm quá dài hoặc quá ngắn"+"\u001B[0m");
            }
            else {
                break;
            }
        }while (true);
        do{
            System.out.println("Hãy nhập giá nhập sản phẩm");
            String inputData = sc.nextLine();
            if(Pattern.matches("\\d+",inputData)||Pattern.matches("\\d+[.]\\d{2}",inputData)){
                this.importPrice = Float.parseFloat(inputData);
                exportPrice = this.importPrice*RATE;
                break;
            }
            else {
                System.out.println("\u001B[31m"+"Giá nhập vào không hợp lệ! Hãy nhập lại"+"\u001B[0m");
                System.out.println("\u001B[31m"+"VD: 3.1=>3.10 hoặc 3.123123=>3.12"+"\u001B[0m");
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
