package lab1.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Product {
    String productName;
    
    public Product(String productName) {
        this.productName = productName;
    }

    public static List<String> productNames = new ArrayList<String>(
        Arrays.asList("Flour", "Sugar", "Water")
    );

    public static ArrayList<Product> createProducts() {
        ArrayList<Product> productList = new ArrayList<Product>();
        for (String product : Product.productNames) {
            Product new_product = new Product(product);
            productList.add(new_product);
        }
        return productList;
    }

    @Override
    public String toString() {
        return "Product: " + this.productName;
    }
}
