import java.util.Scanner;
import java.util.regex.Pattern;

public class Product {
    private int productId ;
    private String productName;
    private float price;
    private String category;
    private int quantity;

    public Product() {
    }

    public Product(int productId, String productName, float price, String category, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void inputData(Scanner sc) {
        this.productName = inputName(sc);
        this.price = inputPrice(sc);
        this.category = inputCategory(sc);
        this.quantity = inputQuantity(sc);
    }

    public void displayData(){
        System.out.println("------------------------------");
        System.out.printf("ID: %d  -  Name: %s  -  Quantity: %d\n",this.productId,this.productName,this.quantity);
        System.out.printf("Category: %s  -  Price: %.2f\n",this.category, this.price);
    }



    public String inputName(Scanner sc) {
        System.out.print("Input the product name: ");
        do {
            String regName = ".{3,50}";
            String name = sc.nextLine();
            if (Pattern.matches(regName, name)) {
                boolean isExit = false;
                for (int i = 0; i < ProductBusiness.currentIndex; i++) {
                    if (ProductBusiness.products[i].productName.equals(name)) {
                        isExit = true;
                        break;
                    }
                }
                if (!isExit) {
                    return name;
                }
                System.err.println("This name already exists, please re-enter");
            }
            else {
                System.err.println("The product name must contain 20-50 characters, re-enter");
            }
        } while (true);

    }

    public float inputPrice(Scanner sc) {
        System.out.print("inpuut the product price: ");
        do {
            if (sc.hasNextFloat()) {
                float price = Float.parseFloat(sc.nextLine());
                if (price > 0) {
                    return price;
                }
                System.err.println("The price must be greater than 0");

            } else {
                System.err.println("The price must be a real number");
                sc.nextLine();
            }
        } while (true);
    }

    public String inputCategory(Scanner sc) {
        System.out.print("Input the type of category: ");
        do {
            String category = sc.nextLine();
            String regCate = ".{0,200}";
            if (Pattern.matches(regCate, category)) {
                return category;
            }
            System.err.println("The type of category can only contain a maximum 200 character.");
        } while (true);
    }

    public int inputQuantity(Scanner sc) {
        System.out.print("Intput the quantity of products: ");
        do {
            if (sc.hasNextInt()) {
                int quantity = Integer.parseInt(sc.nextLine());
                if (quantity > 0) {
                    return quantity;
                }
                System.err.println("The quantity must be greater than 0");
            } else {
                System.err.println("The quantity must be a integer");
                sc.nextLine();
            }
        } while (true);
    }

}
