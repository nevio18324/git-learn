public class PasswordValidator {
    public boolean isPasswordValid(String password) {
        if (password != null) {
            if (password.split("").length > 6 || password.split("").length < 18) {
                if (password.matches("^(?=.*[A-Z])(?=.*[!@#$%^&*()-+=<>?]).*$")) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}