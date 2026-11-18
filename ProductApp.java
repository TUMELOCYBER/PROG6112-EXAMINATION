import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

 // Class: ProductApp
  //This is the main GUI application for Question 2.
 // It allows the user to enter customer details, select a product,
  // enter a price, calculate VAT/Commission/Total, display results
 // in a MessageBox, and save the data to a text file.
//Source:Grok(https://Grok.com)
// Date:18 November, 2026
// Prompt: "Please debug and clean my code so that it can run properly and fix where i did mistakes"

public class ProductApp extends JFrame {

    // GUI Components
    private JTextField txtCustomerName;
    private JComboBox<String> cmbProduct;
    private JTextField txtPrice;
    private JButton btnProcess;

    //Constructor - Builds the entire GUI
    public ProductApp() {
        // Window settings
        setTitle("Product App");
        setSize(450, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window on screen
        setLayout(new BorderLayout());

        // ====================== MENU BAR ======================
        // Reference: Q.2.4 - Menu system required
        JMenuBar menuBar = new JMenuBar();

        // ----- File Menu -----
        JMenu menuFile = new JMenu("File");
        JMenuItem mnuExit = new JMenuItem("Exit");
        // When Exit is clicked, close the application
        mnuExit.addActionListener(e -> System.exit(0));
        menuFile.add(mnuExit);

        // ----- Tools Menu -----
        JMenu menuTools = new JMenu("Tools");
        JMenuItem mnuProcess = new JMenuItem("Process");
        JMenuItem mnuClear = new JMenuItem("Clear");

        // Tools → Process calls the same logic as the Process button
        mnuProcess.addActionListener(e -> processSale());
        
        // Tools → Clear clears all fields and resets combo box
        mnuClear.addActionListener(e -> clearFields());

        menuTools.add(mnuProcess);
        menuTools.add(mnuClear);

        // Add menus to the menu bar
        menuBar.add(menuFile);
        menuBar.add(menuTools);
        setJMenuBar(menuBar);

        // ====================== FORM PANEL ======================
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding between components
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // --- Customer Name ---
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Customer Name:"), gbc);

        gbc.gridx = 1;
        txtCustomerName = new JTextField(18);
        panel.add(txtCustomerName, gbc);

        // --- Product ComboBox ---
        // Reference: Q.2.2 - ComboBox with the three mattress products
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Select Product:"), gbc);

        gbc.gridx = 1;
        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };
        cmbProduct = new JComboBox<>(products);
        panel.add(cmbProduct, gbc);

        // --- Price Text Field ---
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Enter Price:"), gbc);

        gbc.gridx = 1;
        txtPrice = new JTextField(18);
        panel.add(txtPrice, gbc);

        // --- Process Button ---
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2; // Span across both columns
        btnProcess = new JButton("PROCESS");
        btnProcess.addActionListener(e -> processSale());
        panel.add(btnProcess, gbc);

        // Add the panel to the frame
        add(panel, BorderLayout.CENTER);
    }

    /**
     * This method is called when the Process button or Tools → Process is clicked.
     * It captures the data, calculates values, shows a MessageBox,
     * and saves the information to data.txt.
     */
    private void processSale() {
        try {
            // Get values from the form
            String customerName = txtCustomerName.getText().trim();
            String productName = (String) cmbProduct.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText().trim());

            // Validation - customer name cannot be empty
            if (customerName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the customer name.");
                return;
            }

            // Create calculation object (uses the ProductCalculations class)
            ProductCalculations calc = new ProductCalculations(price);

            // Build the message to display (matches sample screenshot)
            String message = String.format(
                "Customer Name: %s\nProduct: %s\nVAT: R %.1f\nCOMMISSION: R %.1f\nTOTAL: R %.1f",
                customerName,
                productName,
                calc.GetVat(),
                calc.GetCommission(),
                calc.GetTotal()
            );

            // Show MessageBox
            JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);

            // Save the data to data.txt
            saveToFile(customerName, productName, calc);

        } catch (NumberFormatException e) {
            // Handles invalid price input (letters instead of numbers)
            JOptionPane.showMessageDialog(this, "Please enter a valid price.");
        }
    }
     //Saves the sale information to a text file named data.txt
     //The file is opened in append mode so previous records are kept
    
    private void saveToFile(String customer, String product, ProductCalculations calc) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt", true))) {
            writer.println("DATA LOG");
            writer.println("******************************************");
            writer.println("Customer Name: " + customer);
            writer.println("Product: " + product);
            writer.printf("VAT: R %.1f%n", calc.GetVat());
            writer.printf("COMMISSION: R %.1f%n", calc.GetCommission());
            writer.printf("TOTAL: R %.1f%n", calc.GetTotal());
            writer.println("******************************************");
            writer.println(); // Empty line between records
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing to file.");
        }
    }

     //Clears all input fields and resets the combo box.
      //Called when Tools → Clear is clicked.
    private void clearFields() {
        txtCustomerName.setText("");
        cmbProduct.setSelectedIndex(0); // Reset to first product
        txtPrice.setText("");
    }

    
    //Main method - Entry point of the application
    public static void main(String[] args) {
        // Ensures the GUI is created on the Event Dispatch Thread (best practice)
        SwingUtilities.invokeLater(() -> {
            new ProductApp().setVisible(true);
        });
    }
}