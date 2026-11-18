import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductCalculationsTest {

    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calc = new ProductCalculations(3500.0);
        assertEquals(525.0, calc.GetVat(), 0.01);
    }

    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calc = new ProductCalculations(3500.0);
        // VAT = 525, Commission = 175, Total = 3500 + 525 + 175 = 4200
        assertEquals(4200.0, calc.GetTotal(), 0.01);
    }
}