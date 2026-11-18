package test;

import org.junit.Test;
import static org.junit.Assert.*;
import product.Product;

public class ProductTest {
    
    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue(){
        int[][] testSales = {{25,18,20},{15,10,12},{18,15,20}};
        String[] testNames = {"A","B","C"};
        Product p = new Product(testSales, testNames);
        assertEquals(153, p.GetTotalProductsSold());
    }
    
    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue(){
        int[][] testSales = {{25,18,20},{15,10,12},{18,15,20}};
        String[] testNames = {"A","B","C"};
        Product p = new Product(testSales, testNames);
        assertEquals(17, p.GetAverageProductSold(), 0.01);
    }
}