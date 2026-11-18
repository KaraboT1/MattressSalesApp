package main;

import java.util.Scanner;
import product.Product;
import product.PrintProduct;

// Main application class, this is the entry point for the console program
public class MainApp {
    public static void main(String[] args) {
        
        // Create a scanner object to accept user keyboard input
        Scanner input = new Scanner(System.in);
        
        // Array storing the three mattress product names
        String[] productNames = {
            "Cozy Nights Monarch mattress",
            "Restonic Barbados mattress",
            "Sealy Phuket mattress"
        };
        
        // Create a 3x3 2D array to hold sales figures
        int[][] sales = new int[3][3];
        
        // Nested loop to collect sales input from the user
        for(int i = 0; i < productNames.length; i++){
            for(int month = 0; month < 3; month++){
                System.out.print("Enter number of sales for month " + (month + 1) + " for " + productNames[i] + ": ");
                sales[i][month] = input.nextInt();
            }
        }
        
        // Create instances of the Product and PrintProduct classes
        Product product = new Product(sales, productNames);
        PrintProduct printer = new PrintProduct();
        
        // printed the header for the final sales report
        System.out.println("\nPRODUCT SALES REPORT – 2026");
        System.out.println("****************************************");
        
        // Call the print methods to display all the calculated results
        printer.printTotalSales(product.GetTotalProductsSold());
        printer.printAverageSales(product.GetAverageProductSold());
        printer.printMostPopular(product.GetMostPopularProduct());
        
        // Close the scanner to free up resources
        input.close();
    }
}
