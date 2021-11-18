package data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.Random;

public class GenerateCredentials {


    public static String emailAddressGenerator(){
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZqazwsxedcrfvtgbyhnujmiklop1234567890";
        StringBuilder email = new StringBuilder();
        Random rnd = new Random();
        while (email.length() < 15) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            email.append(chars.charAt(index));
        }
        String emailAddress = email.toString() + "@gmail.com";
        return emailAddress;
    }

    public static String passwordGenerator() {
        String password = new Random().ints(20, 33, 122).collect(StringBuilder::new,
                        StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return password;
    }

    public void enterCredentialsInTxtFile(String emailAddress, String password) throws IOException {
        File file = new File("Emails and Passwords.txt");
        FileWriter fw = new FileWriter(file, true);
        PrintWriter pw = new PrintWriter(fw);

        pw.println("Email address: " + emailAddress+ "    Password: " + password);

        pw.close();
    }

    public String encodePassword(String password){
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return (new String(encodedPassword));
    }

    public String decodePassword(String password){
        byte[] decodedPassword = Base64.getDecoder().decode(password);
        return (new String(decodedPassword));
    }
}

