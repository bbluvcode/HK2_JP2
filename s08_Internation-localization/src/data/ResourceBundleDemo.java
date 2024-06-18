package data;

import java.util.ResourceBundle;
import java.util.Locale;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class ResourceBundleDemo {

    public static void main(String[] args) {
        //====== Xác định ngôn ngữ và khu vực
        Locale currentLocale = new Locale("en", "US"); // Tiếng Anh, Hoa Kỳ

        //=========== Tải bundle
        ResourceBundle messages = ResourceBundle.getBundle("resources.messages", currentLocale);
        ResourceBundle numbers = ResourceBundle.getBundle("resources.messages", currentLocale);
        ResourceBundle dates = ResourceBundle.getBundle("resources.messages", currentLocale);

        // ============= Tiếng anh
        System.out.println("-----English");
        System.out.println(messages.getString("greeting"));
        System.out.println(messages.getString("farewell"));

        // In ra các số
        System.out.println(numbers.getString("one"));
        System.out.println(numbers.getString("two"));
        System.out.println(numbers.getString("three"));

        // In ra ngày hôm nay
        String todayPattern = dates.getString("today");
        String formattedToday = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String formattedMessage = MessageFormat.format(todayPattern, formattedToday);
        System.out.println(formattedMessage);
        System.out.println(todayPattern);

        //============ Chuyển sang tiếng Việt
        System.out.println("\n-----Chuyển sang tiếng Việt");
        Locale currentLocale2 = new Locale("vi", "VN");
        messages = ResourceBundle.getBundle("resources.messages", currentLocale2);
        numbers = ResourceBundle.getBundle("resources.messages", currentLocale2);
        dates = ResourceBundle.getBundle("resources.messages", currentLocale2);

        System.out.println(messages.getString("greeting"));
        System.out.println(messages.getString("farewell"));
        System.out.println(numbers.getString("one"));
        System.out.println(numbers.getString("two"));
        System.out.println(numbers.getString("three"));

        formattedToday = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        formattedMessage = MessageFormat.format(dates.getString("today"), formattedToday);
        System.out.println(formattedMessage);

        //============= Chuyển sang tiếng Trung Quốc đơn giản hóa
        System.out.println("\n-----Chuyển sang tiếng Trung");
        Locale currentLocale3 = new Locale("zh", "CN");
        messages = ResourceBundle.getBundle("resources.messages", currentLocale3);
        numbers = ResourceBundle.getBundle("resources.messages", currentLocale3);
        dates = ResourceBundle.getBundle("resources.messages", currentLocale3);

        System.out.println(messages.getString("greeting"));
        System.out.println(messages.getString("farewell"));
        System.out.println(numbers.getString("one"));
        System.out.println(numbers.getString("two"));
        System.out.println(numbers.getString("three"));

        formattedToday = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日"));
        formattedMessage = MessageFormat.format(dates.getString("today"), formattedToday);
        System.out.println(formattedMessage);

        //==========Locale Default
        currentLocale = Locale.getDefault();

        // Tải bundle nguồn phù hợp
        messages = ResourceBundle.getBundle("resources.messages", currentLocale);
        numbers = ResourceBundle.getBundle("resources.messages", currentLocale);
        dates = ResourceBundle.getBundle("resources.messages", currentLocale);

        // In ra các chuỗi bằng ngôn ngữ và định dạng mặc định của máy
        System.out.println("\n-----Default");
        System.out.println(messages.getString("greeting"));
        System.out.println(messages.getString("farewell"));

        System.out.println(numbers.getString("one"));
        System.out.println(numbers.getString("two"));
        System.out.println(numbers.getString("three"));

        // In ra ngày hôm nay
        // Lấy ngày hiện tại theo định dạng của Locale mặc định
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.getDefault());
        formattedToday = LocalDate.now().format(dateFormatter);

        // Sử dụng ngày định dạng để tạo chuỗi thông điệp
        formattedMessage = MessageFormat.format(dates.getString("today"), formattedToday);
        System.out.println(formattedMessage);
    }
}
