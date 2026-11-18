package product;

public class PrintProduct {
    
    public void printTotalSales(int total){
        System.out.println("TOTAL PRODUCT SALES: " + total);
    }
    
    public void printAverageSales(double average){
        System.out.println("AVERAGE PRODUCT SALES: " + Math.round(average));
    }
    
    public void printMostPopular(String popularProduct){
        System.out.println("MOST POPULAR PRODUCT: " + popularProduct);
    }
}