import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("Task 1");
        System.out.println(replaceVovels("apple"));
        System.out.println(replaceVovels("Even if you did this task not by yourself, " +
                "you have to understand every single line of code."));
        System.out.println("****************");

        System.out.println("Task 2");
        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper"));
        System.out.println("****************");

        System.out.println("Task 3");
        System.out.println(doesBlockkFit(1, 3, 5, 4, 5));
        System.out.println(doesBlockkFit(1, 8, 1, 1, 1));
        System.out.println(doesBlockkFit(1, 2, 2, 1, 1));
        System.out.println("****************");

        System.out.println("Task 4");
        System.out.println(numCheck(243));
        System.out.println(numCheck(52));
        System.out.println("****************");

        System.out.println("Task 5");
        System.out.println(countRoots(new int[] {1, -3, 2}));
        System.out.println(countRoots(new int[] {2, 5, 2}));
        System.out.println(countRoots(new int[] {1, -6, 9}));
        System.out.println("****************");

        System.out.println("Task 6");
        System.out.println(Arrays.toString(salesData((new String[][]{{"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4"},
                {"Pear", "Shop2", "Shop4"}}))));
        System.out.println(Arrays.toString(salesData((new String[][]{{"Fridge", "Shop2", "Shop3"},
                {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Laptop", "Shop3", "Shop4"},
                {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}}))));
        System.out.println("****************");

        System.out.println("Task 7");
        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));
        System.out.println("****************");

        System.out.println("Task 8");
        System.out.println(waveForm(new int[] {3, 1, 4, 2, 7, 5}));
        System.out.println(waveForm(new int[] {1, 2, 3, 4, 5}));
        System.out.println(waveForm(new int[] {1, 2, -6, 10, 3}));
        System.out.println("****************");

        System.out.println("Task 9");
        System.out.println(commonVovel("Hello world"));
        System.out.println(commonVovel("Actions speak louder than words."));
        System.out.println("****************");

        System.out.println("Task 10");
        System.out.println(Arrays.deepToString(dataScience(new int[][]{{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {5, 5, 5, 5, 5},
                {7, 4, 3, 14, 2},
                {1, 0, 11, 10, 1}})).replace("], ", "]\n"));
        System.out.println("****************");
        System.out.println(Arrays.deepToString(dataScience(new int[][]{{6, 4, 19, 0, 0},
                {81, 25, 3, 1, 17},
                {48, 12, 60, 32, 14},
                {91, 47, 16, 65, 217},
                {5, 73, 0, 4, 21}})).replace("], ", "]\n"));
    }
    public static String replaceVovels(String word){
        return word.replaceAll("(?i)[aeiouy]","*");
    }
    public static String stringTransform(String word){
        char[] wordIn = word.toCharArray();
        String simb = "";
        for (int i = 1; i < wordIn.length; i++){
            if (wordIn[i] == wordIn[i-1]){
                simb = String.valueOf(wordIn[i]);
                word = word.replace((simb + simb), "Double" + simb.toUpperCase());
            }
        }
        return word;
    }
    public static boolean doesBlockkFit(int a, int b, int c, int w, int h){
        int[] numbs = {a, b, c};
        int[] hole = {w, h};
        Arrays.sort(numbs);
        Arrays.sort(hole);
        if (numbs[0] <= hole[0] && numbs[1] <= hole[1]){
            return true;
        }
        return false;
    }
    public static boolean numCheck(int num){
        int test = num;
        int counter = 0;
        while (test > 0){
            counter += (test % 10) * (test % 10);
            test /= 10;
        }
        return num % 2 == counter % 2;
    }
    public static int countRoots(int[] args){
        int D = args[1] * args[1] - 4 * args[0] * args[2];
        double x1 = (-args[1] + Math.sqrt(D))/(2 * args[0]);
        double x2 = (-args[1] - Math.sqrt(D))/(2 * args[0]);
        if (D >= 0){
            if (x1 == Math.floor(x1) && x2 == Math.floor(x2) && x1 != x2){
                return 2;
            } else if (x1 != Math.floor(x1) && x2 == Math.floor(x2) || x1 == Math.floor(x1) && x2 != Math.floor(x2) || x1 == x2){
                return 1;
            } 
        }
        return 0;
    }
    public static String[] salesData(String[][] salesIn){
        int countSales = 0;
        String nameSale = "";
        for (int i = 0; i < salesIn.length; i++){
            if (countSales <= salesIn[i].length){
                countSales = salesIn[i].length;
            }
        }
        for (int i = 0; i < salesIn.length; i++){
            if (countSales == salesIn[i].length){
                nameSale += salesIn[i][0] + " ";
            }
        }
        return nameSale.split(" ");
    }
    public static boolean validSplit(String sentence) {
        String[] str = sentence.split(" ");
        List<String> cur = new ArrayList<>();
        boolean[] visited = new boolean[str.length];
        List<String[]> allSplits = new ArrayList<>();
        permutations(str, visited, cur, allSplits);
        return !allSplits.isEmpty();
    }

    private static void permutations(String[] words, boolean[] visited, List<String> currentWords, List<String[]> splits){
        if (words.length == currentWords.size()){
            boolean isValid = true;
            for (int i = 0; i < currentWords.size() - 1; i++){
                if (currentWords.get(i).charAt(currentWords.get(i).length() - 1) != currentWords.get(i + 1).charAt(0))
                    isValid = false;
            }
            if (isValid) splits.add(currentWords.toArray(new String[0]));
            return;
        }
        for (int i = 0; i < words.length; i++){
            if(!visited[i]){
                visited[i] = true;
                currentWords.add(words[i]);
                permutations(words, visited, currentWords, splits);
                visited[i] = false;
            }
        }
    }

    public static boolean waveForm (int[] numbs){
        ArrayList<Boolean> bools = new ArrayList<>();
        for (int i = 0; i < numbs.length - 1; i++){
            bools.add(numbs[i] < numbs[i+1]);
        }
        for (int i = 0; i < bools.size() - 1; i++){
            if (bools.get(i) == bools.get(i + 1)) return false;
        }
        return true;
    }
    public static char commonVovel(String sentence){
        sentence = sentence.toLowerCase().replaceAll("(?i)[qwrtpsdfghjklzxcvbnm.?,!]","")
                .replace(" ", "");
        char[] myArray = sentence.toCharArray();
        Arrays.sort(myArray);
        HashMap<Character, Integer> top = new HashMap<>();
        top.put('a',0);
        top.put('e',0);
        top.put('i',0);
        top.put('o',0);
        top.put('u',0);
        top.put('y',0);
        for(int i = 0; i < myArray.length; i++){
            top.put(myArray[i], top.get(myArray[i])+1);
        }
        ArrayList<Integer> values = new ArrayList<>(top.values());
        int maxVovel = 0;
        for (int i = 0; i < values.size(); i++){
            if (values.get(i) >= maxVovel){
                maxVovel = values.get(i);
            }
        }
        ArrayList<Character> keys = new ArrayList<>(top.keySet());
        for(int i = 0; i < keys.size(); i++) {
            if (top.get(keys.get(i)) == maxVovel) {
                return keys.get(i);
            }
        }
        return ' ';
    }
    public static int[][] dataScience(int[][] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            float mid = 0;
            for (int j = 0; j < arrays.length; j++) {
                if (i != j){
                    mid += arrays[j][i];
                }
            }
            mid /= (arrays.length - 1);
            arrays[i][i] = Math.round(mid);
        }
        return arrays;
    }
}