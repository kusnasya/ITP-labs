import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpChecker {
    public static void main(String args[]){
        String ipAddress = "192.168.1.1";
        String regex = "((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[0-9][0-9]?)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ipAddress);
        if (matcher.matches()) {
            System.out.println("Valid IP address!");
        } else {
            System.out.println("Invalid IP address!");
        }
    }
}
