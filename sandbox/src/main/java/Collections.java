import java.util.Arrays;
import java.util.List;

public class Collections {
    public static void main(String[] args) {
        String[] langs = {"Java", "C#", "Python", "PHP"};
        //аналог преобразования массива в список
        List<String> Languches = Arrays.asList("Java", "C#", "Python", "PHP");
        for (String l : Languches) {
            System.out.println("Я хочу выучить " + l);
        }
    }
}
