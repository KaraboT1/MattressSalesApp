package gui;

public class ProductCalculation implements IProductCalculation {
    
    @Override
    public double calculateVAT(double price) {
        return price * 0.15;
    }
    
    @Override
    public double calculateCommission(double price) {
        return price * 0.05;
    }
    
    @Override
    public double calculateTotalSale(double price) {
        return price + calculateVAT(price) + calculateCommission(price);
    }
}
