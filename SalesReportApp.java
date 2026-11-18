import java.util.Scanner;

public class SalesReportApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Single-dimensional array for product names
        String[] productNames = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        // Two-dimensional array [3 products][3 months]
        int[][] monthlySales = new int[3][3];

        // Capture sales data
        for (int i = 0; i < productNames.length; i++) {
            for (int month = 0; month < 3; month++) {
                System.out.print("Enter number of sales for month " + (month + 1) +
                                 " for " + productNames[i] + " mattress: ");
                monthlySales[i][month] = input.nextInt();
            }
            System.out.println();
        }

        // Create Product object (uses both arrays)
        Product product = new Product(productNames, monthlySales);

        // Print the report
        PrintProduct printer = new PrintProduct();
        printer.printFullReport(product);

        input.close();
    }
}