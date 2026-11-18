package product;

import iproduct.IProduct;

public class Product implements IProduct {
    
    private int[][] salesData;
    private String[] productNames;
    
    public Product(int[][] salesData, String[] productNames) {
        this.salesData = salesData;
        this.productNames = productNames;
    }
    
    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for(int i = 0; i < salesData.length; i++){
            for(int j = 0; j < salesData[i].length; j++){
                total = total + salesData[i][j];
            }
        }
        return total;
    }
    
    @Override
    public double GetAverageProductSold() {
        int totalEntries = salesData.length * salesData[0].length;
        return (double) GetTotalProductsSold() / totalEntries;
    }
    
    @Override
    public String GetMostPopularProduct() {
        int highestTotal = 0;
        String topProduct = "";
        
        for(int i = 0; i < salesData.length; i++){
            int productTotal = 0;
            for(int j = 0; j < salesData[i].length; j++){
                productTotal = productTotal + salesData[i][j];
            }
            
            if(productTotal > highestTotal){
                highestTotal = productTotal;
                topProduct = productNames[i] + " (" + highestTotal + ")";
            }
        }
        return topProduct;
    }
}
