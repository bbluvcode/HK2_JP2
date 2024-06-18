import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class I18NTime {
    static void printTime(Locale locale) {
        DateFormat formatter = DateFormat.getTimeInstance(DateFormat.LONG, locale);
        Date currentDate = new Date();
        String time = formatter.format(currentDate);
        System.out.println(time + " in locale: " + locale);
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
                    printTime(Locale.ENGLISH);
                    break;
                case 2:
                    printTime(new Locale("vi", "VN"));
                    break;
            }
        } while (region != 3);
    }
}
