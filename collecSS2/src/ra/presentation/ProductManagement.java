package ra.presentation;

import ra.businessImp.Categories;
import ra.businessImp.Product;

import java.util.*;
import java.util.regex.Pattern;

public class ProductManagement {
    public void caseDisplay(Scanner sc, List<Categories> categoriesList, List<Product> productList){
        boolean isExit = false;
        do{
            System.out.println("+--------------------------------------+");
            System.out.println("|           PRODUCT MENU               |");
            System.out.println("+--------------------------------------+");
            System.out.println("|1. Danh sách sản phẩm                 |");
            System.out.println("|2. Thêm mới sản phẩm                  |");
            System.out.println("|3. Cập nhật thông tin sản phẩm        |");
            System.out.println("|4. Xóa sản phẩm                       |");
            System.out.println("|5. Sắp xếp theo giá bán tăng dần      |");
            System.out.println("|6. Sắp xếp theo giá nhập giảm dần     |");
            System.out.println("|7. Tìm kiếm sản phẩm theo tên sản phẩm|");
            System.out.println("|8. Thoát                              |");
            System.out.println("+--------------------------------------+");
            String choice = "";
            do{
                System.out.print("Lựa chon: ");
                choice = sc.nextLine();
                if(!Pattern.matches("[12345678]",choice)){
                    System.err.println("Lựa chọn không hợp lệ!");
                    System.out.println();
                }
                else {
                    break;
                }
            }while (true);
            switch (Integer.parseInt(choice)){
                case 1:
                    if(productList.size()==0){
                        System.out.println("\u001B[31m"+"Không tồn tại sản phẩm"+"\u001B[0m");
                    }
                    else {
                        System.out.println("+----+------------------------------+----------+----------------+----------------+---------------+");
                        System.out.println("|ID  |Name                          |Catalog Id|Import Price    |Export Price    |Status         |");
                        System.out.println("+----+------------------------------+----------+----------------+----------------+---------------+");
                        productList.forEach(Product::displayData);
                    }
                    break;
                case 2:
                    if(categoriesList.size()==0){
                        System.out.println("\u001B[31m"+"Danh mục sản phẩm đang trống! Không thể thêm"+"\u001B[0m");
                    }
                    else {
                        Product input = new Product();
                        input.inputData(sc,categoriesList,productList);
                        productList.add(input);
                    }
                    break;
                case 3:
                    do{
                        System.out.println("Hãy nhập mã sản phẩm cần cập nhật");
                        String inputData = sc.nextLine();
                        if(inputData.length()!=4){
                            System.out.println("\u001B[31m"+"Mã sản phẩm không hợp lệ!"+"\u001B[0m");
                        }else {
                            boolean isCheck = false;
                            for(int i=0;i<productList.size();i++){
                                Product check = productList.get(i);
                                if(check.getId().equals(inputData)){
                                    check.updateData(sc);
                                    isCheck = true;
                                    break;
                                }
                            }
                            if(!isCheck){
                                System.out.println("\u001B[31m"+"Không tìm thấy mã sản phẩm cần cập nhật"+"\u001B[0m");
                            }
                            break;
                        }
                    }while (true);
                    break;
                case 4:
                    do{
                        System.out.println("Hãy nhập mã sản phẩm cần xóa");
                        String inputData = sc.nextLine();
                        if(inputData.length()!=4){
                            System.out.println("\u001B[31m"+"Mã sản phẩm không hợp lệ!"+"\u001B[0m");
                        }else {
                            boolean isCheck = false;
                            for(int i=0;i<productList.size();i++){
                                Product check = productList.get(i);
                                if(check.getId().equals(inputData)){
                                    isCheck = true;
                                    do {
                                        System.out.println("Bạn có muốn xóa sản phẩm " + check.getName());
                                        System.out.println("1. Có");
                                        System.out.println("2. Không");
                                        inputData = sc.nextLine();
                                        if (!Pattern.matches("[12]", inputData)) {
                                            System.out.println("\u001B[31m" + "Lụa chọn không hợp lệ!" + "\u001B[0m");
                                        } else {
                                            if(Integer.parseInt(inputData)==1){
                                                productList.remove(i);
                                                break;
                                            }
                                            else {
                                                break;
                                            }
                                        }
                                    }while (true);
                                    break;
                                }
                            }
                            if (!isCheck) {
                                System.out.println("\u001B[31m" + "Không tìm thấy mã sản phẩm cần xóa" + "\u001B[0m");
                            }
                            break;
                        }
                    }while (true);
                    break;
                case 5:
                    List<Product> copy = new ArrayList<Product>();
                    copy.addAll(productList);
                    Comparator<Product> case5 = new Comparator<Product>(){
                      public int compare(Product o1,Product o2){
                          if(o1.getExportPrice()>o2.getExportPrice()){
                              return 1;
                          }
                          else {
                              return -1;
                          }
                      }
                    };
                    Collections.sort(copy,case5);
                    System.out.println("+----+------------------------------+----------+----------------+----------------+---------------+");
                    System.out.println("|ID  |Name                          |Catalog Id|Import Price    |Export Price    |Status         |");
                    System.out.println("+----+------------------------------+----------+----------------+----------------+---------------+");
                    copy.forEach(Product::displayData);
                    copy.clear();
                    break;
                case 6:
                    List<Product> case6 = new ArrayList<Product>();
                    case6.addAll(productList);
                    Comparator<Product> case6sort = new Comparator<Product>(){
                        public int compare(Product o1,Product o2){
                            if(o1.getImportPrice()>o2.getImportPrice()){
                                return -1;
                            }
                            else {
                                return 1;
                            }
                        }
                    };
                    Collections.sort(case6,case6sort);
                    System.out.println("+----+------------------------------+----------+----------------+----------------+---------------+");
                    System.out.println("|ID  |Name                          |Catalog Id|Import Price    |Export Price    |Status         |");
                    System.out.println("+----+------------------------------+----------+----------------+----------------+---------------+");
                    case6.forEach(Product::displayData);
                    case6.clear();
                    break;
                case 7:
                    do{
                        System.out.println("Hãy nhập tên sản phẩm bạn muốn tìm");
                        String inputData = sc.nextLine();
                        if(inputData.length()<-0||inputData.length()>30){
                            System.out.println("\u001B[31m"+"Tên sản phẩm không hợp lệ! Hãy nhập lại!"+"\u001B[0m");
                        }
                        else {
                            boolean isCheck = false;
                            boolean isFirst = true;
                            for (int i=0;i<productList.size();i++){
                                Product check = productList.get(i);
                                if(check.getName().contains(inputData)){
                                    if(isFirst){
                                        System.out.println("+----+------------------------------+----------+----------------+----------------+---------------+");
                                        System.out.println("|ID  |Name                          |Catalog Id|Import Price    |Export Price    |Status         |");
                                        System.out.println("+----+------------------------------+----------+----------------+----------------+---------------+");
                                    }
                                    isFirst = false;
                                    isCheck = true;
                                    check.displayData();
                                }
                            }
                            if(!isCheck){
                                System.out.println("\u001B[31m"+"Không tìm thấy tên sản phẩm"+"\u001B[0m");
                            }
                            break;
                        }
                    }while (true);
                    break;
                case 8:
                    isExit = true;
            }
        }while (!isExit);
    }
}
