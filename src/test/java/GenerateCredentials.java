import java.util.Random;

public class GenerateCredentials {

    public static void main(String[] args) {

        String a = new GenerateCredentials().emailAddressGenerator();
        String b = new GenerateCredentials().passwordGenerator();
        System.out.println(a);
        System.out.println(b);
    }


    protected String emailAddressGenerator() {
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

    protected String passwordGenerator() {
        String password = new Random().ints(10, 33, 122).collect(StringBuilder::new,
                        StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return password;
    }
}

