package passwordValidation;
import java.util.*;

public class passwordValidation {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter a password.");
        Scanner sc = new Scanner(System.in);

        String password = sc.next();

        try {
            validatePassword(password);
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
        }
    }

    static void validatePassword(String password) throws PasswordException {
        if (password.length() < 10) {
            throw new PasswordException("Password length is less than 10");
        }

        boolean upperCheck = false;
        boolean lowerCheck = false;
        boolean digitCheck = false;
        boolean specialCheck = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c))
            {
                upperCheck = true;
            }

            if (Character.isLowerCase(c))
            {
                lowerCheck = true;
            }
            if (Character.isDigit(c))
            {
                digitCheck = true;
            }

        }
        if(password.matches(".*[@#&%*!].*")){
            specialCheck =true;
        }

        if (!upperCheck) {
            throw new PasswordException("There must be an uppercase character");
        }

        if (!lowerCheck) {
            throw new PasswordException ("There must be a lowercase character");
        }

        if (!digitCheck) {
            throw new PasswordException ("There must a be a digit");
        }
        if (!specialCheck) {
            throw new PasswordException ("There must a be a special Character");
        }


        System.out.println("Valid password.");
    }

    static class PasswordException extends Exception {

        public PasswordException() {
            super("Invalid password");
        }

        public PasswordException(String message) {
            super("Invalid password: " + message);
        }
    }
}
