// Class responsible for displaying product sales information to the console
public class PrintProduct {
    //Displays the total number of products sold
    public void printTotalProductSales(int total) {
        System.out.println("TOTAL PRODUCT SALES: " + total);
    }
    //Displays the average product sales, casting the decimal value to a whole number
    public void printAverageProductSales(double average) {
        System.out.println("AVERAGE PRODUCT SALES: " + (int) average);
    }
    //Displays the name of the most popular product
    public void printMostPopularProduct(String product) {
        System.out.println("MOST POPULAR PRODUCT: " + product);
    }
    // Generates and prints the complete sales report using a product object
    public void printFullReport(Product product) {
        System.out.println("\nPRODUCT SALES REPORT - 2026");
        System.out.println("******************************************");
        printTotalProductSales(product.GetTotalProductsSold());
        printAverageProductSales(product.GetAverageProductSold());
        printMostPopularProduct(product.GetMostPopularProduct());
    }
}