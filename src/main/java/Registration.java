
public class Registration {

    public boolean registerUser(String name, String email) {

        if (name == null || name.isBlank()) {
            return false;
        }

        if (email == null || !email.contains("@")) {
            return false;
        }

        return true;
    }
}
