package ra.presentation;

import ra.businessImp.Categories;
import ra.businessImp.Product;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CategoriesManagement {
    public void caseDisplay(Scanner sc, List<Categories> categories,List<Product> product){
        boolean isExit = true;
        do{
            System.out.println("+---------------------+");
            System.out.println("|      Menu           |");
            System.out.println("+---------------------+");
            System.out.println("|1. Danh sách danh mục|");
            System.out.println("|2. Thêm mới danh mục |");
            System.out.println("|3. Cập nhật danh mục |");
            System.out.println("|4. Xóa danh mục      |");
            System.out.println("|5. Thoát             |");
            System.out.println("+---------------------+");
            String choice = "";
            do{
                System.out.print("Lựa chon: ");
                choice = sc.nextLine();
                if(!Pattern.matches("[12345]",choice)){
                    System.err.println("Lựa chọn không hợp lệ!");
                    System.out.println();
                }
                else {
                    break;
                }
            }while (true);
            switch (Integer.parseInt(choice)){
                case 1:
                    System.out.println("+----+------------------------------+----------------------------------------+---------------+");
                    System.out.println("|ID  |Name                          |Descriptions                            |Status         |");
                    System.out.println("+----+------------------------------+----------------------------------------+---------------+");
                    categories.forEach(Categories::displayData);
                    break;
                case 2:
                    Categories input = new Categories();
                    input.inputData(sc,categories,product);
                    categories.add(input);
                    break;
                case 3:
                    do {
                        System.out.println("Hãy nhập mã danh mục cần cập nhật");
                        String inputData = sc.nextLine();
                        if(inputData.length()<=0){
                            System.out.println("\u001B[31m"+"Mã danh mục đang để trống! Hãy nhập lại"+"\u001B[0m");
                        }
                        else {
                            if(!Pattern.matches("\\d+",inputData)){
                                System.out.println("\u001B[31m"+"Mã danh mục không hợp lệ!"+"\u001B[0m");
                            }
                            else {
                                boolean isCheck = false;
                                for (int i = 0; i < categories.size(); i++) {
                                    Categories check = categories.get(i);
                                    if (check.getId() == Integer.parseInt(inputData)) {
                                        check.updateData(sc);
                                        isCheck = true;
                                        break;
                                    }
                                    else {
                                        isCheck = false;
                                    }
                                }
                                if (!isCheck) {
                                    System.out.println("\u001B[31m"+"Mã dang mục không tồn tại"+"\u001B[0m");
                                    break;
                                }
                                else {
                                    break;
                                }
                            }
                        }

                    }while (true);
                    break;
                case 4:
                    do{
                        System.out.println("Hãy nhập mã danh mục cần xóa");
                        String inputData= sc.nextLine();
                        if(inputData.length()<=0){
                            System.out.println("\u001B[31m"+"Mã số danh mục đang bỏ trống"+"\u001B[0m");
                        }
                        else {
                            if(!Pattern.matches("\\d+",inputData)){
                                System.out.println("\u001B[31m"+"Mã danh mục không hợp lệ!"+"\u001B[0m");
                            }
                            else{
                                boolean isCheck = false;
                                for(int i=0;i<categories.size();i++){
                                    Categories check = categories.get(i);
                                    if(check.getId()==Integer.parseInt(inputData)){
                                        if(check.getIsNum()!=0){
                                            System.out.println("\u001B[31m"+"Danh mục đang có sản phẩm! Không thể xóa"+"\u001B[0m");
                                            break;
                                        }
                                        else {
                                            do{
                                                System.out.println("Bạn có muốn xóa danh mục "+check.getName());
                                                System.out.println("1. Có");
                                                System.out.println("2. Không");
                                                inputData = sc.nextLine();
                                                if(!Pattern.matches("[12]",inputData)){
                                                    System.out.println("\u001B[31m"+"Lụa chọn không hợp lệ!"+"\u001B[0m");
                                                }
                                                else {
                                                    if(Integer.parseInt(inputData)==1){
                                                        categories.remove(i);
                                                        break;
                                                    }
                                                    else {
                                                        break;
                                                    }
                                                }
                                            }while (true);
                                        }
                                    }
                                }
                                break;
                            }

                        }
                    }while (true);
                    break;
                case 5:
                    isExit = false;
                    break;
            }
        }while (isExit);
    }
}
