
public class Login {

    public boolean validateLogin(String username, String password) {

        if (username == null || username.isBlank()) {
            return false;
        }

        if (password == null || password.length() < 6) {
            return false;
        }

        return true;
    }
}
