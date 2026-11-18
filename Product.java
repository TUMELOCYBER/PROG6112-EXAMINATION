public class Product implements IProduct {
    private String[] productNames;          // Single-dimensional array
    private int[][] monthlySales;           // Two-dimensional array [product][month]
    private int totalProductsSold;
    private double averageProductsSold;
    private String mostPopularProduct;

    public Product(String[] productNames, int[][] monthlySales) {
        this.productNames = productNames;
        this.monthlySales = monthlySales;
        calculateTotals();
    }

    private void calculateTotals() {
        totalProductsSold = 0;
        int maxSales = -1;
        int mostPopularIndex = 0;

        for (int i = 0; i < monthlySales.length; i++) {
            int productTotal = 0;
            for (int j = 0; j < monthlySales[i].length; j++) {
                productTotal += monthlySales[i][j];
            }
            totalProductsSold += productTotal;

            if (productTotal > maxSales) {
                maxSales = productTotal;
                mostPopularIndex = i;
            }
        }

        averageProductsSold = (double) totalProductsSold / productNames.length;
        mostPopularProduct = productNames[mostPopularIndex] + "(" + maxSales + ")";
    }

    @Override
    public int GetTotalProductsSold() {
        return totalProductsSold;
    }

    @Override
    public double GetAverageProductSold() {
        return averageProductsSold;
    }

    @Override
    public String GetMostPopularProduct() {
        return mostPopularProduct;
    }
}