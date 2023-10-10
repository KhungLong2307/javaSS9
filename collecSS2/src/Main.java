import ra.businessImp.Categories;
import ra.businessImp.Product;
import ra.presentation.CategoriesManagement;
import ra.presentation.ProductManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    static List<Categories> categories = new ArrayList<>();
    static List<Product> products = new ArrayList<>();
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("+----------------------------+");
            System.out.println("|            Menu            |");
            System.out.println("+----------------------------+");
            System.out.println("|1. Quản lý danh mục sản phẩm|");
            System.out.println("|2. Quản lý sản phẩm         |");
            System.out.println("|3. Thoát                    |");
            System.out.println("+----------------------------+");
            String choice = "";
            do{
                System.out.print("Lựa chọn: ");
                choice = sc.nextLine();
                if(!Pattern.matches("[123]",choice)){
                    System.err.println("Lựa chọn không hợp lệ");
                    Thread.sleep(1000);
                    System.out.println();
                }
                else {
                    break;
                }
            }while (true);
            switch (Integer.parseInt(choice)){
                case 1:
                    CategoriesManagement cateDisplay = new CategoriesManagement();
                    cateDisplay.caseDisplay(sc,categories,products);
                    break;
                case 2:
                    ProductManagement caseDisplay = new ProductManagement();
                    caseDisplay.caseDisplay(sc,categories,products);
                    break;

                case 3:
                    System.exit(0);
            }
        }while(true);
    }
}