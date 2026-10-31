
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {

    Payment payment = new Payment();

    @Test
    public void testValidPayment() {
        assertTrue(payment.processPayment(500));
    }

    @Test
    public void testZeroPayment() {
        assertFalse(payment.processPayment(0));
    }

    @Test
    public void testNegativePayment() {
        assertFalse(payment.processPayment(-100));
    }
}
