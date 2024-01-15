import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FinderWords {
    public static void main(String[] args) {
        String text = "Apple, apricot, and banana are fruits. Avocado is also a fruit. Forward";
        String startingLetter = "fr";
        String regex = "\\b" + startingLetter + "\\w*\\b";
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
