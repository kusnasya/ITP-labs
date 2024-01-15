import java.util.*;

public class Task4 {
    public static void main (String[] args){
        //1
        System.out.println("---1---");
        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi"));
        //2
        System.out.println("---2---");
        System.out.println(generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));
        //3
        System.out.println("---3---");
        System.out.println(binarySystem(3));
        System.out.println(binarySystem(4));
        //4
        System.out.println("---4---");
        System.out.println(alphabeticRow("ababa"));
        System.out.println(alphabeticRow("abcdjuwx"));
        System.out.println(alphabeticRow("klmabzyxw"));
        //5
        System.out.println("---5---");
        System.out.println(compressAndSort("aaabbcdd"));
        System.out.println(compressAndSort("vvvvaajaaaaa"));
        //6
        System.out.println("---6---");
        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));
        //7
        System.out.println("---7---");
        System.out.println(uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("111111"));
        System.out.println(uniqueSubstring("77897898"));
        //8
        System.out.println("---8---");
        int[][] matrix1 = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(shortestWay(matrix1));
        int[][] matrix2 = {
                {2, 7, 3},
                {1, 4, 8},
                {4, 5, 9}
        };
        System.out.println(shortestWay(matrix2));
        //9
        System.out.println("---9---");
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));
        //10
        System.out.println("---10---");
        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));
    }
//1
    public static String nonRepeatable(String s)
    {
        String lastChar = s.substring(s.length()-1,s.length());
        if (s.length() <= 1) return s;
        if(s.substring(0,s.length()-1).contains(lastChar)){
            return nonRepeatable(s.substring(0,s.length()-1));
        }
        else return nonRepeatable(s.substring(0,s.length()-1)) + lastChar;
    }
//2
    private static List<String> generateBrackets(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, String string, int open, int close, int max) {
        if (string.length() == max * 2) {
            result.add(string);
            return;
        }
        if (open < max) {
            backtrack(result, string + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(result, string + ")", open, close + 1, max);
        }
    }
//3
    public static List<String> binarySystem(int n) {
        List<String> result = new ArrayList<>();
        generateCombinations(result, n, "");
        return result;
    }
    private static void generateCombinations(List<String> result, int n, String current) {
        if (current.length() == n) {
            result.add(current);
            return;
        }
        // Добавляем "0", только если последний символ не "0"
        if (current.isEmpty() || current.charAt(current.length() - 1) != '0') {
            generateCombinations(result, n, current + "0");
        }
        // Всегда можно добавить "1"
        generateCombinations(result, n, current + "1");
    }
//4
    public static String alphabeticRow(String str) {
        String longest = "", current = str.substring(0, 1);
        str += " ";
        for (int i = 1; i < str.length()-1; i++) {
            if (str.charAt(i) - str.charAt(i - 1) == 1 && str.charAt(i) - str.charAt(i + 1) == -1) {
                current += str.charAt(i);
            } else if (str.charAt(i) - str.charAt(i - 1) == -1 && str.charAt(i) - str.charAt(i + 1) == 1){
                current += str.charAt(i);
            } else {
                current += str.charAt(i);
                longest = current.length() > longest.length() ? current : longest;
                current = String.valueOf(str.charAt(i));
            }
        }
        return current.length() > longest.length() ? current : longest;
    }
//5
    public static String compressAndSort(String str) {
        StringBuilder result = new StringBuilder();
        ArrayList<String> segments = new ArrayList<>();

        int count = 1;
        for (int i = 1; i <= str.length(); i++) {
            if (i == str.length() || str.charAt(i) != str.charAt(i - 1)) {
                segments.add(str.charAt(i - 1) + String.valueOf(count));
                count = 1;
            } else {
                count++;
            }
        }

        Comparator<String> sortByCount = (s1, s2) -> {
            int count1 = Integer.parseInt(s1.substring(1));
            int count2 = Integer.parseInt(s2.substring(1));
            int countComparison = Integer.compare(count1, count2);
            if (countComparison == 0) {
                return s1.substring(0, 1).compareTo(s2.substring(0, 1));
            }
            return countComparison;
        };
        Collections.sort(segments, sortByCount);

        for (String segment : segments) {
            result.append(segment);
        }
        return result.toString();
    }
//6
    public static int convertToNum(String s) {
        Map<String, Integer> numberWords = new HashMap<>();
        initializeNumberWordsMap(numberWords);

        String[] words = s.split(" ");
        int result = 0;
        int currentNumber = 0;

        for (String word : words) {
            int num = numberWords.get(word);
            if (num == 100) {
                currentNumber *= num;
            } else if (num == 1000) {
                currentNumber *= num;
                result += currentNumber;
                currentNumber = 0;
            } else {
                currentNumber += num;
            }
        }
        result += currentNumber;
        return result;
    }

    private static void initializeNumberWordsMap(Map<String, Integer> map) {
        map.put("zero", 0); map.put("one", 1); map.put("two", 2);
        map.put("three", 3); map.put("four", 4); map.put("five", 5);
        map.put("six", 6); map.put("seven", 7); map.put("eight", 8);
        map.put("nine", 9); map.put("ten", 10); map.put("eleven", 11);
        map.put("twelve", 12); map.put("thirteen", 13); map.put("fourteen", 14);
        map.put("fifteen", 15); map.put("sixteen", 16); map.put("seventeen", 17);
        map.put("eighteen", 18); map.put("nineteen", 19); map.put("twenty", 20);
        map.put("thirty", 30); map.put("forty", 40); map.put("fifty", 50);
        map.put("sixty", 60); map.put("seventy", 70); map.put("eighty", 80);
        map.put("ninety", 90); map.put("hundred", 100); map.put("thousand", 1000);
    }
//7
    public static String uniqueSubstring(String input) {
        int maxLength = 0;
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            StringBuilder currentSubstring = new StringBuilder();
            for (int j = i; j < input.length(); j++) {
                char currentChar = input.charAt(j);
                if (currentSubstring.indexOf(String.valueOf(currentChar)) == -1) {
                    currentSubstring.append(currentChar);
                    if (currentSubstring.length() > maxLength) {
                        maxLength = currentSubstring.length();
                        result = currentSubstring.toString();
                    }
                } else {
                    break;
                }
            }
        }
        return result;
    }
//8
    public static int shortestWay(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];

        dp[0][0] = matrix[0][0];

        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        for (int j = 1; j < cols; j++) {
            dp[0][j] = dp[0][j - 1] + matrix[0][j];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        }
        return dp[rows - 1][cols - 1];
    }
//9
    public static String numericOrder(String input) {
        String[] words = input.split(" ");
        String[] orderedWords = new String[words.length];

        for (String word : words) {
            int order = Integer.parseInt(word.replaceAll("[^0-9]", ""));
            orderedWords[order - 1] = word.replaceAll("[0-9]", "").trim();
        }
        String result = new String();
        for (String word : orderedWords) {
            result += word + " ";
        }
        return result;
    }
//10
    public static int switchNums(int num1, int num2) {
        char[] num1Digits =  Integer.toString(num1).toCharArray();
        char[] num2Digits = Integer.toString(num2).toCharArray();
        boolean[] used = new boolean[num1Digits.length];

        for (int i = 0; i < num2Digits.length; i++) {
            char currentDigit = num2Digits[i];
            char maxDigit = '0';
            int maxDigitIndex = -1;
            for (int j = 0; j < num1Digits.length; j++) {
                if (!used[j] && num1Digits[j] >= maxDigit) {
                    maxDigit = num1Digits[j];
                    maxDigitIndex = j;
                }
            }
            if (maxDigitIndex != -1 && maxDigit > currentDigit) {
                num2Digits[i] = maxDigit;
                used[maxDigitIndex] = true;
            }
        }
        String resultStr = new String(num2Digits);
        return  Integer.parseInt(resultStr);
    }
}
