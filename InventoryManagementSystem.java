
import java.util.ArrayList;

public class InventoryManagementSystem {
    final private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(String name, int price){
        Product product = new Product(name, price);
        this.products.add(product);

        System.out.println("Product added: " + name + " SRP: " + price);
    }
    
    public void displayProducts(){
        if (this.products.isEmpty()){
            System.out.println("No products added");
        } else {
            System.out.println("Products Avaible:");
            for (Product product : this.products){
                System.out.println("Product Name: " + product.getName() + " SRP: " + product.getPrice());
            }
        }
    }
}
