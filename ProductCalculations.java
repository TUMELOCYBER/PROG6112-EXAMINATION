//Class: ProductCalculations
//This class implements the IProductCalculations interface.
//It calculates VAT (15%), Commission (5%) and Total Sale Amount.
 
public class ProductCalculations implements IProductCalculations {

    // Private attributes (encapsulation)
    private double price;
    private double vat;
    private double commission;
    private double total;

     // Constructor
     // Receives the product price and immediately calculates all values.
    public ProductCalculations(double price) {
        this.price = price;
        calculate(); // Calls the calculation method
    }

    //Private method that performs all calculations.
    private void calculate() {
        vat = price * 0.15;              // 15% VAT
        commission = price * 0.05;       // 5% Commission
        total = price + vat + commission;
    }

    
     //Returns the VAT amount
     //Required by the interface
    @Override
    public double GetVat() {
        return vat;
    }

    
      //Returns the Commission amount
      //Required by the interface
    @Override
    public double GetCommission() {
        return commission;
    }

      //Returns the Total Sale amount
      //Required by the interface
    @Override
    public double GetTotal() {
        return total;
    }
}