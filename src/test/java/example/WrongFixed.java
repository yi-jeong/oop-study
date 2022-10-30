package example;

import org.example.PasswordGenerator;

public class WrongFixed implements PasswordGenerator {

    @Override
    public String generatePassword() {
        return "ts";
    }

}
