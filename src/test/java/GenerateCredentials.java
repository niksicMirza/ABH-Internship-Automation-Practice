import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class GenerateCredentials {

    public static void main(String[] args) throws IOException {
        enterCredentialsInTxtFile();
    }

    public static String emailAddressGenerator(){
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZqazwsxedcrfvtgbyhnujmiklop1234567890";
        StringBuilder email = new StringBuilder();
        Random rnd = new Random();
        while (email.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            email.append(chars.charAt(index));
        }
        String emailAddress = email.toString() + "@gmail.com";
        return emailAddress;
    }

    public static String passwordGenerator() {
        String password = new Random().ints(10, 33, 122).collect(StringBuilder::new,
                        StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return password;
    }

    public static void enterCredentialsInTxtFile() throws IOException {
        File file = new File("Emails and Passwords.txt");
        FileWriter fw = new FileWriter(file, true);
        PrintWriter pw = new PrintWriter(fw);

        pw.println("Email address: " + emailAddressGenerator() + "    Password: " + passwordGenerator());

        pw.close();
    }
}

