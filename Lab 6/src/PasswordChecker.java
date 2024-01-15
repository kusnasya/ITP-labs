import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordChecker {
    public static void main(String[] args){
        String text = "3Adddfafssfsfs52";
        Pattern pattern = Pattern.compile("(?=.*[A-Z])(?=.*\\d)[A-Za-z]{8,16}");
        Matcher mather = pattern.matcher(text);
        if (mather.matches()){
            System.out.println("Correct");
        } else {
            System.out.println("Error");
        }
    }
}
