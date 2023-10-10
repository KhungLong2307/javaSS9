package ra.businessImp;

import java.util.List;
import java.util.Scanner;

public interface IShop {
    float RATE = 1.3f;
    void inputData(Scanner sc,List<Categories> categoriesList,List<Product> productList);
    void displayData();
}
