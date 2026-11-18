
 //This interface defines the contract for calculating VAT, Commission and Total Sale.
 //Required by Question 2.5 of the practical assessment.
 
public interface IProductCalculations {
    
    // Returns the calculated VAT amount
    double GetVat();
    
    // Returns the calculated Commission amount
    double GetCommission();
    
    // Returns the calculated Total Sale amount
    double GetTotal();
}