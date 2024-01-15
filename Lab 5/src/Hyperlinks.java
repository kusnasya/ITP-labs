import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hyperlinks {
    public static void main(String[] args) {
        String inputUrl = "javarush.com";
        String outputUrl = addProtocolToUrl(inputUrl, "http");
        System.out.println(outputUrl);
    }
    private static String addProtocolToUrl(String url, String protocol) {
        String regex = "^(http|https)://.*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);

        if (!matcher.matches()) {
            url = protocol + "://" + url;
        }
        return url;
    }
}
