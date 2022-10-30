package org.example;

public class User {
    private String password;

    public void initPassword(PasswordGenerator passwordGenerator){
        String randomPassword = passwordGenerator.generatePassword();

        /** 8자 이상 12자 이하만 처리 **/
        if(randomPassword.length() >= 8 && randomPassword.length() <= 12){
            this.password = randomPassword;
        }
    }

    public String getPassword(){
        return password;
    }
}
