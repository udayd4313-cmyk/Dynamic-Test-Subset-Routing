
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegistrationTest {

    Registration registration = new Registration();

    @Test
    public void testValidRegistration() {
        assertTrue(registration.registerUser("Uday", "uday@gmail.com"));
    }

    @Test
    public void testEmptyName() {
        assertFalse(registration.registerUser("", "uday@gmail.com"));
    }

    @Test
    public void testInvalidEmail() {
        assertFalse(registration.registerUser("Uday", "udaygmail.com"));
    }
}
