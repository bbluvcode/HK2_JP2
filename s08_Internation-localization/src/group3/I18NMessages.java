import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;


public class I18NMessages {
    public static void main(String[] args) {
        int lang = 0;
        Scanner s = new Scanner(System.in);
        ResourceBundle bundle;
        do {
            System.out.println("1. English");
            System.out.println("2. Vietnamese");
            System.out.println("3. Exit program");
            System.out.print("Please choose your language: ");
            lang = s.nextInt();
            switch (lang) {
                case 1:
                    bundle = ResourceBundle.getBundle
                            ("internationalization.message.MessageBundle", Locale.US);
                    System.out.println("Message in " + Locale.US
                            + ": " + bundle.getString("greeting"));
                    break;
                case 2:
                    Locale.setDefault(new Locale("vi", "VN"));
                    bundle = ResourceBundle.getBundle
                            ("internationalization.message.MessageBundle");
                    System.out.println("Message in " + Locale.getDefault()
                            + ": " + bundle.getString("greeting"));
                    break;
            }
        } while (lang != 3);
    }
}