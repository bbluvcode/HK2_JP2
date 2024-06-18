import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class I18NDate {
    static void printDate(Locale locale) {
        DateFormat formatter = DateFormat.getDateInstance(DateFormat.LONG,
                locale);
        Date currentDate = new Date();
        String date = formatter.format(currentDate);
        System.out.println(locale + " : " + date);
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
                    printDate(Locale.JAPAN);
                    break;
                case 2:
                    printDate(new Locale("vi", "VN"));
                    break;
            }
        } while (region != 3);
    }
}
