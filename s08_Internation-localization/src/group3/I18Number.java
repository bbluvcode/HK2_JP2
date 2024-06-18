import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class I18Number {
    static void printNumber(Locale locale) {
        System.out.println("enter number");
        double n = new Scanner(System.in).nextDouble();
        NumberFormat formatter = NumberFormat.getNumberInstance(locale);
        String number = formatter.format(n);
        System.out.println(number + " for the locale " + locale);
    }

    public static void main(String[] args) {
        int region;
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("1. England");
            System.out.println("2. Vietnam");
            System.out.println("3. Exit program");

            System.out.print("Please choose your region: ");
            region = s.nextInt();

            switch (region) {
                case 1:
                    printNumber(Locale.ENGLISH);
                    break;
                case 2:
                    printNumber(new Locale("vi", "VN"));
                    break;
            }
        } while (region != 3);
    }
}
