package example;

import org.example.PasswordGenerator;

public class CorrectFixed implements PasswordGenerator {

    @Override
    public String generatePassword() {
        return "testtesta";
    }

}
