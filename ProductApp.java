package gui;

import javax.swing.JOptionPane;

public class ProductApp {

    private javax.swing.JFrame frame;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JComboBox<String> cboProduct;
    private javax.swing.JButton btnProcess;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnExit;
    
    // Instance of calculation class
    private ProductCalculation calculator;

    public ProductApp() {
        calculator = new ProductCalculation();
        frame = new javax.swing.JFrame("Product App");
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

        jLabel1 = new javax.swing.JLabel("Customer Name:");
        jLabel2 = new javax.swing.JLabel("Select Product:");
        jLabel3 = new javax.swing.JLabel("Enter Price:");

        txtCustomerName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();

        cboProduct = new javax.swing.JComboBox<>();
        cboProduct.addItem("Cozy Nights Monarch");
        cboProduct.addItem("Restonic Barbados");
        cboProduct.addItem("Sealy Phuket");

        btnProcess = new javax.swing.JButton("PROCESS");
        btnClear = new javax.swing.JButton("CLEAR");
        btnExit = new javax.swing.JButton("EXIT");

        btnProcess.addActionListener(e -> {
            if(txtCustomerName.getText().isBlank()){
                JOptionPane.showMessageDialog(frame, "Please enter the customer name!");
                return;
            }
            if(txtPrice.getText().isBlank()){
                JOptionPane.showMessageDialog(frame, "Please enter the product price!");
                return;
            }
            double price;
            try{
                price = Double.parseDouble(txtPrice.getText());
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(frame, "Price must be a valid number!");
                return;
            }

            String customerName = txtCustomerName.getText();
            String productName = cboProduct.getSelectedItem().toString();

            // Use ProductCalculation class for all calculations
            double vat = calculator.calculateVAT(price);
            double commission = calculator.calculateCommission(price);
            double totalSale = calculator.calculateTotalSale(price);

            String result = "CUSTOMER NAME: " + customerName +
                    "\nPRODUCT NAME: " + productName +
                    "\nVAT AMOUNT: R" + vat +
                    "\nCOMMISSION AMOUNT: R" + commission +
                    "\nTOTAL SALE AMOUNT: R" + totalSale;

            JOptionPane.showMessageDialog(frame, result);
        });

        btnClear.addActionListener(e -> {
            txtCustomerName.setText("");
            txtPrice.setText("");
            cboProduct.setSelectedIndex(0);
            txtCustomerName.requestFocus();
        });

        btnExit.addActionListener(e -> {
            System.exit(0);
        });

        javax.swing.JPanel panel = new javax.swing.JPanel();
        panel.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.insets = new java.awt.Insets(8,8,8,8);

        gbc.gridx = 0; gbc.gridy = 0; panel.add(jLabel1, gbc);
        gbc.gridx = 1; gbc.gridy = 0; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL; gbc.weightx = 1; panel.add(txtCustomerName, gbc);

        gbc.gridx = 0; gbc.gridy = 1; panel.add(jLabel2, gbc);
        gbc.gridx = 1; gbc.gridy = 1; panel.add(cboProduct, gbc);

        gbc.gridx = 0; gbc.gridy = 2; panel.add(jLabel3, gbc);
        gbc.gridx = 1; gbc.gridy = 2; panel.add(txtPrice, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.fill = java.awt.GridBagConstraints.NONE; panel.add(btnProcess, gbc);
        gbc.gridx = 1; gbc.gridy = 3; panel.add(btnClear, gbc);
        gbc.gridx = 2; gbc.gridy = 3; panel.add(btnExit, gbc);

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    public void showWindow(){
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new ProductApp().showWindow();
        });
    }
}
