package data;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18nDemo {

    public static void main(String[] args) {
        // Xác định ngôn ngữ và khu vực
        Locale currentLocale = new Locale("en", "US"); 

        // Tải bundle nguồn phù hợp
        ResourceBundle messages = ResourceBundle.getBundle("data.messages", currentLocale);

        // In ra các chuỗi được địa phương hóa
        System.out.println(messages.getString("greeting")); 
        System.out.println(messages.getString("farewell")); 

        // Chuyển sang tiếng Việt
        currentLocale = new Locale("vi", "VN"); // Tiếng Việt, Việt Nam
        messages = ResourceBundle.getBundle("data.messages", currentLocale);

        System.out.println(messages.getString("greeting")); 
        System.out.println(messages.getString("farewell")); 

        // Chuyển sang tiếng Trung Quốc đơn giản hóa
        currentLocale = new Locale("zh", "CN");
        messages = ResourceBundle.getBundle("data.messages", currentLocale);

        System.out.println(messages.getString("greeting")); 
        System.out.println(messages.getString("farewell")); 
    }
}
