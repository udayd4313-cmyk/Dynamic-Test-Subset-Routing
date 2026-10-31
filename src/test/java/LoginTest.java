
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    Login login = new Login();

    @Test
    public void testValidLogin() {
        assertTrue(login.validateLogin("uday", "welcome123"));
    }

    @Test
    public void testEmptyUsername() {
        assertFalse(login.validateLogin("", "welcome123"));
    }

    @Test
    public void testShortPassword() {
        assertFalse(login.validateLogin("uday", "abc"));
    }
}
