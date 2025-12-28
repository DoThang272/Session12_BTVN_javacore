import java.util.Scanner;

public class ProductBusiness {

    public static Product[] products = new Product[100];
    public static int currentIndex = 0;

    public static int getNextId() {
        int maxId = 0;
        for (int i = 0; i < currentIndex; i++) {
            if (products[i].getProductId() > maxId) {
                maxId = products[i].getProductId();
            }
        }
        return maxId + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("***************PRODUCTS MANAGEMENT*****************");
            System.out.println("1. Add the product");
            System.out.println("2. Display product list");
            System.out.println("3. Update product by id");
            System.out.println("4. Delete product by id");
            System.out.println("5. Search the product by name");
            System.out.println("6. Sort product in creasing order of price");
            System.out.println("7. Sort product in decreasing order of quantity");
            System.out.println("8. Exit");
            System.out.println("***************************************************");
            System.out.print("Your choice:");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addProduct(sc);
                    break;
                case 2:
                    displayProduct();
                    break;
                case 3:
                    updateProduct(sc);
                    break;
                case 4:
                    deletePById(sc);
                    break;
                case 5:
                    searchProductByName(sc);
                    break;
                case 6:
                    sortProductESCPrice();
                    break;
                case 7:
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.err.println("You must choice from 1 to 8.");

            }
        } while (true);


    }

    public static void displayProduct() {
        if (currentIndex == 0) {
            System.out.println("Hava 0 product, Let add product.");
        }
        for (int i = 0; i < currentIndex; i++) {
            products[i].displayData();
        }
    }

    public static void addProduct(Scanner sc) {
        Product p = new Product();
        p.setProductId(getNextId());
        p.inputData(sc);
        products[currentIndex] = p;
        currentIndex++;
    }

    public static int findIndexById(int productID) {
        for (int i = 0; i < currentIndex; i++) {
            if (productID == products[i].getProductId()) {
                return i;
            }
        }
        return -1;
    }

    public static void deletePById(Scanner sc) {
        System.out.print("Enter the id of product you want to delete: ");
        int idToDelete = Integer.parseInt(sc.nextLine());
        int idxProductDelete = findIndexById(idToDelete);
        if (idxProductDelete == -1) {
            System.err.println("Not found!");
            return;
        }
        for (int i = idxProductDelete; i < currentIndex; i++) {
            products[i] = products[i + 1];
        }
        currentIndex--;
    }

    public static void updateProduct(Scanner sc) {
        System.out.print("Enter the id of product you want to update: ");
        int idToUpdate = Integer.parseInt(sc.nextLine());
        int idxProductUpdate = findIndexById(idToUpdate);
        if (idxProductUpdate == -1) {
            System.err.println("Not found this product.");
            return;
        }
        System.out.println("------------UPDATE PRODUCT-------------");
        System.out.println("Choose value to update");
        System.out.println("1. Name of product.");
        System.out.println("2. Price of product.");
        System.out.println("3. Type of category.");
        System.out.println("4. Quantity in stock.");
        System.out.println("5. Exit");
        System.out.print("Your choice: ");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1:
                products[idxProductUpdate].setProductName(updateName(sc));
                break;
            case 2:
                products[idxProductUpdate].setPrice(updatePriceOProduct(sc));
                break;
            case 3:
                products[idxProductUpdate].setCategory(updateCategory(sc));
                break;
            case 4:
                products[idxProductUpdate].setQuantity(updateQuantity(sc));
                break;
            case 5:
                break;
            default:
                System.err.println("You must choose from 1 to 5.");
        }


    }

    public static String updateName(Scanner sc) {
        System.out.print("Input new name of product: ");
        return sc.nextLine();
    }

    public static float updatePriceOProduct(Scanner sc) {
        System.out.print("Input new price of product: ");
        return Integer.parseInt(sc.nextLine());
    }

    public static String updateCategory(Scanner sc) {
        System.out.print("Input new category: ");
        return sc.nextLine();
    }

    public static int updateQuantity(Scanner sc) {
        System.out.print("Input new quantity in stock: ");
        return Integer.parseInt(sc.nextLine());
    }

    public static void searchProductByName(Scanner sc) {
        System.out.print("Enter the name product you want to search: ");
        String nameSearch = sc.nextLine();
        for (int i = 0; i < currentIndex; i++) {
            if (products[i].toString().toLowerCase().contains(nameSearch)) {
                products[i].displayData();
            }
        }
    }

    public static void sortProductESCPrice() {
        for (int i = 0; i < currentIndex; i++) {
            float temp;
            if (products[i].getPrice() > products[i + 1].getPrice()) {
                temp = products[i].getPrice();
                products[i].setPrice(products[i + 1].getPrice());
                products[i + 1].setPrice(temp);
            }
        }
        for (int i = 0; i < currentIndex; i++) {
            products[i].displayData();
        }
    }
}
