public class Palindrome {
    public class Palindrome {
        public static void main(String[] args) {
            for (int i = 0; i < args.length; i++) {
                String s = args[i];
                System.out.println((isPalindrome(s)));
            }

        }
        public static String reverseString(String s){
            String reverse = "";
            for (int i = s.length()-1; i >= 0 ; i--){
                reverse += s.charAt(i);
            }
            return reverse.toLowerCase();
        }
        public static boolean isPalindrome(String s){
            if (s.toLowerCase().equals(reverseString(s))){
                return true;
            } else {
                return false;
            }
        }
    }
}
