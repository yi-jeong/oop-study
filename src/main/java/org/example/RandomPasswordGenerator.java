package org.example;

import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

public class RandomPasswordGenerator implements org.example.PasswordGenerator {

    private static final String ALLOWED_SPL_CHARACTERS = "!@#$%^&*()_+";
    private static final String ERROR_CODE = "ERROR_CHARACTER";

    public String generatePassword(){
        PasswordGenerator gen = new PasswordGenerator();

        CharacterData lowerCaseData = EnglishCharacterData.LowerCase;
        CharacterRule lowerCaseRule = new CharacterRule(lowerCaseData);
        lowerCaseRule.setNumberOfCharacters(2);

        CharacterData upperCaseData = EnglishCharacterData.UpperCase;
        CharacterRule upperCaseRule = new CharacterRule(upperCaseData);
        upperCaseRule.setNumberOfCharacters(2);

        CharacterData digitChars = EnglishCharacterData.Digit;
        CharacterRule digitRule = new CharacterRule(digitChars);
        digitRule.setNumberOfCharacters(2);

        CharacterData spacialChars = new CharacterData() {
            @Override
            public String getErrorCode() {
                return ERROR_CODE;
            }

            @Override
            public String getCharacters() {
                return ALLOWED_SPL_CHARACTERS;
            }
        };

        CharacterRule sqlCharRule = new CharacterRule(spacialChars);
        sqlCharRule.setNumberOfCharacters(2);

        return gen.generatePassword((int) (Math.random() * 13), sqlCharRule, lowerCaseRule, upperCaseRule);
    }
}
