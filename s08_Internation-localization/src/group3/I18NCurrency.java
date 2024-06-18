import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class I18NCurrency {
    private static void printCurrency(Locale locale) {
        float n = 10500.3245F;
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        String currency = formatter.format(n);
        System.out.println(currency + " for the locale " + locale);
    }

    public static void main(String[] args) {
        int region;
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("1. Japan");
            System.out.println("2. Vietnam");
            System.out.println("3. Exit program");

            System.out.print("Please choose your region: ");
            region = s.nextInt();

            switch (region) {
                case 1:
                    printCurrency(Locale.JAPAN);
                    break;
                case 2:
                    printCurrency(new Locale("vi", "VN"));
                    break;
            }
        } while (region != 3);
    }
}
