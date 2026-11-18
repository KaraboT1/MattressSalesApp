package gui;

public interface IProductCalculation {
    double calculateVAT(double price);
    double calculateCommission(double price);
    double calculateTotalSale(double price);
}
