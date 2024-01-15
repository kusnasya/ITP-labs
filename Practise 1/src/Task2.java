import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("Task - 1");
        System.out.println(duplicateChars("Donald"));
        System.out.println(duplicateChars("orange"));
        System.out.println("************");
        System.out.println("Task - 2");
        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(getInitials("Barack Obama"));
        System.out.println("************");
        System.out.println("Task - 3");
        System.out.println(differenceEvenOdd(new int[]{44, 32, 86, 19}));
        System.out.println(differenceEvenOdd(new int[]{22, 50, 16, 63, 31, 55}));
        System.out.println("************");
        System.out.println("Task - 4");
        System.out.println(equalToAvg(new double[]{1, 2, 3, 4, 5}));
        System.out.println(equalToAvg(new double[]{1, 2, 3, 4, 6}));
        System.out.println("************");
        System.out.println("Task - 5");
        System.out.println(Arrays.toString(indexMult(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(indexMult(new int[]{3, 3, -2, 408, 3, 31})));
        System.out.println("************");
        System.out.println("Task - 6");
        System.out.println(reverse("Hello World"));
        System.out.println(reverse("The quick brown fox."));
        System.out.println("************");
        System.out.println("Task - 7");
        System.out.println(Tribonacci(7));
        System.out.println(Tribonacci(11));
        System.out.println("************");
        System.out.println("Task - 8");
        System.out.println(pseudoHash(5));
        System.out.println(pseudoHash(10));
        System.out.println(pseudoHash(0));
        System.out.println("************");
        System.out.println("Task - 9");
        System.out.println(botHelper("Hello, I’m under the water, please help me"));
        System.out.println(botHelper("helper"));
        System.out.println("************");
        System.out.println("Task - 10");
        System.out.println(isAnagram("listen","silent"));
        System.out.println(isAnagram("eleven plus two","twelve plus one"));
        System.out.println(isAnagram("hello","world"));
    }

    public static boolean duplicateChars(String args) {
        char[] myArray = args.toLowerCase().toCharArray();
        boolean result = false;
        for (int i = 0; i < ((myArray.length) - 1); i++) {
            for (int j = i + 1; j < myArray.length; j++) {
                if (myArray[i] == myArray[j]) {
                    result = true;
                }
            }
        }
        return result;
    }

    public static String getInitials(String name) {
        String[] words = name.split(" ");
        String firstLetter = words[0].substring(0, 1);
        String secondLetter = words[1].substring(0, 1);
        return firstLetter + secondLetter;
    }

    public static int differenceEvenOdd(int[] numbers) {
        int chet = 0;
        int nechet = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                chet += numbers[i];
            }
            else {
                nechet += numbers[i];
            }
        }
        if (chet >= nechet) {
            return chet - nechet;
        } else {
            return nechet - chet;
        }
    }

    public static boolean equalToAvg(double[] numbAv) {
        double sum = 0;
        boolean result = false;
        for (int i = 0; i < numbAv.length; i++) {
            sum += numbAv[i];
        }
        double average = sum / numbAv.length;
        for (int j = 0; j < numbAv.length; j++) {
            if (numbAv[j] == average) {
                result = true;
            }
        }
        return result;
    }
    public static int[] indexMult(int[] indNumb){
        int[] MyArray = new int[indNumb.length];
        for (int i = 0; i < indNumb.length; i++){
            MyArray[i] = indNumb[i] * i;
        }
        return MyArray;
    }
    public static String reverse(String sentence){
        String MyArray = "";
        for (int i = sentence.length()-1; i >=0 ; i--){
            MyArray += sentence.charAt(i);
        }
        return MyArray;
    }
    public static int Tribonacci(int numb){
        int[] arr = new int[numb];
        arr[0] = 0;
        arr[1] = 0;
        arr[2] = 1;
        for (int i = 3; i < arr.length; ++i) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }
        return arr[numb-1];
    }
    public static String pseudoHash(int len){
        String result = "";
        for (int i = 0; i < len; i++){
            String s = String.format("%x",(int)(Math.random()*15));
            result += s;
        }
        return result;
    }
    public static String botHelper(String messege){
        String substring = "help";
        String[] words = messege.toLowerCase().split(" ");
        for (int i = 0; i < words.length; i++){
            if (words[i].equals(substring)){
                return "Calling for a staff member";
            }
        }
        return "Keep waiting";
    }
    public static boolean isAnagram(String firstStr, String secondStr){
        char[] c1 = firstStr.toLowerCase().toCharArray();
        char[] c2= secondStr.toLowerCase().toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        String sc1 = new String(c1);
        String sc2 = new String(c2);
        return sc1.equals(sc2);
    }
}