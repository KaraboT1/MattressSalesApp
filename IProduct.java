package iproduct;

// This interface defines the required methods for product sales calculations
public interface IProduct {
    
    // Calculate and return the total number of all products sold
    int GetTotalProductsSold();
    
    // Calculate and return the average number of products sold
    double GetAverageProductSold();
    
    // Find and return the name of the best‑selling product
    String GetMostPopularProduct();
    

}
