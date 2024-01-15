import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Task5 {

    public static void main(String[] args) {
        System.out.println("Task 1");
        System.out.println(sameLetterPattern("ABAB", "CDCD"));  // true
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));  // true
        System.out.println(sameLetterPattern("FFGG", "CDCD"));  // false
        System.out.println(sameLetterPattern("FEFE", "ABCD"));  // false
        System.out.println();

        System.out.println("Task 2");
        System.out.println(spiderVsFly("H3","E2"));
        System.out.println(spiderVsFly("A4","H4"));
        System.out.println(spiderVsFly("A4","H2"));
        System.out.println(spiderVsFly("A2","H4"));
        System.out.println(spiderVsFly("H4","B4"));
        System.out.println();

        System.out.println("Task 3");
        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount(1289396387328L));
        System.out.println();

        System.out.println("Task 4");
        System.out.println(totalPoints(new String[]{"cat", "create", "sat"}, "caster"));
        System.out.println(totalPoints(new String[]{"trance", "recant"}, "recant"));
        System.out.println(totalPoints(new String[]{"trance"}, "recant"));
        System.out.println(totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));
        System.out.println();

        System.out.println("Task 5");
        System.out.println(sumsUp(new int[]{1, 2, 3, 4, 5}));    // ➞ [[3, 5]]
        System.out.println(sumsUp(new int[]{1, 2, 3, 7, 9}));    // ➞ [[1, 7]]
        System.out.println(sumsUp(new int[]{10, 9, 7, 2, 8}));   // ➞ []
        System.out.println(sumsUp(new int[]{1, 6, 5, 4, 8, 2, 3, 7}));    // ➞ [[1, 7], [2, 6], [3, 5]]
        System.out.println();

        System.out.println("Task 6");
        System.out.println(takeDownAverage(new String[] {"95%", "83%", "90%", "87%", "88%", "93%"}));
        System.out.println(takeDownAverage(new String[] {"10%"}));
        System.out.println(takeDownAverage(new String[] {"53%", "79%"}));
        System.out.println();

        System.out.println("Task 7");
        System.out.println(caesarCipher("encode", "hello world", 3));
        System.out.println(caesarCipher("decode", "EPQSWX PEWX XEWO!", 4));
        System.out.println();

        System.out.println("Task 8");
        System.out.println(setSetup(5,3));
        System.out.println(setSetup(7,3));
        System.out.println();

        System.out.println("Task 9");
        System.out.println(timeDifference("Los Angeles", "April 1, 2012 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));
        System.out.println();

        System.out.println("Task 10");
        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(123));
    }

    public static boolean sameLetterPattern(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        char firctCh = arr1[0];
        char secondCh = arr2[0];
        for (int i = 1; i < s1.length();i++){
            int diff1 = firctCh - arr1[i];
            int diff2 = secondCh - arr2[i];
            if (diff2 != diff1) return false;
            firctCh = arr1[i];
            secondCh = arr2[i];
        }
        return true;
    }
    private static final String RADIALS = "ABCDEFGH"; // Строка для представления радиалов
    public static String spiderVsFly(String spider, String fly){
        int spiderRadial = RADIALS.indexOf(spider.charAt(0));
        int spiderRing = Character.getNumericValue(spider.charAt(1)); //Определяется номер кольца, на котором находится паук
        int flyRadial = RADIALS.indexOf(fly.charAt(0)); // определяется индекс радиала для мухи.
        int flyRing = Character.getNumericValue(fly.charAt(1)); // Определяется номер кольца для мухи
        StringBuilder path = new StringBuilder(spider); // начальная позиция паука
        // Если паук и муха находятся на одном радиале
        if (spiderRadial == flyRadial) {
            for (int i = spiderRing - 1; i >= flyRing; i--) {
                path.append("-").append(RADIALS.charAt(spiderRadial)).append(i);
            }
        }else{// Если паук и муха находятся на разных радиалах
            int angleDistance = Math.min(Math.abs(spiderRadial - flyRadial), RADIALS.length() - Math.abs(spiderRadial - flyRadial));
            // Вычисляется кратчайшее угловое расстояние между радиалами паука и мухи.
            if (angleDistance < 3 || spiderRing == 0 || flyRing == 0) {
                // Спускаемся или поднимаемся по кольцам (true- -1, false-1)
                int ringChange = spiderRing > flyRing ? -1 : 1;
                for (int ring = spiderRing; ring != flyRing; ring += ringChange) {
                    path.append("-").append(RADIALS.charAt(spiderRadial)).append(ring + ringChange);
                }
                // Перемещаемся по кольцу к нужному радиалу
                int radialChange = spiderRadial < flyRadial ? 1 : -1;
                if (Math.abs(spiderRadial - flyRadial) > RADIALS.length() / 2) {
                    radialChange = -radialChange; // Если короче идти в другую сторону
                }
                for (int radial = spiderRadial; radial != flyRadial; radial = (radial + radialChange + RADIALS.length()) % RADIALS.length()) {
                    path.append("-").append(RADIALS.charAt((radial + radialChange + RADIALS.length()) % RADIALS.length())).append(flyRing);
                }
            } else {
                // Спускаемся в центр
                for (int i = spiderRing-1; i > 0; i--) {
                    path.append("-").append(RADIALS.charAt(spiderRadial)).append(i);
                }
                // Перемещаемся по центру к нужному радиалу
                path.append("-A0");
                for (int i = 1; i <= flyRing; i++) {
                    path.append("-").append(RADIALS.charAt(flyRadial)).append(i);
                }
            }
        }
        // Возвращаем путь как строку
        return path.toString();
    }
    public static int digitsCount(long number) {
        if (number < 10) {
            return 1;
        } else {
            return 1 + digitsCount(number / 10);
        }
    }

    public static int totalPoints(String[] guessedWords, String scramble) {
        int totalPoints = 0;
        Map<Character, Integer> letterCount = new HashMap<>();

        for (char letter : scramble.toCharArray()) {
            letterCount.put(letter, letterCount.getOrDefault(letter, 0) + 1);
        }
        boolean flag = false;
        for(int i = 0; i < guessedWords.length; i++){
            if (guessedWords[i].equals(scramble)){
                flag = true;
            }
        }
        for (String word : guessedWords) {
            if (isValidWord(word, letterCount)) {
                int wordLength = word.length();
                int wordPoints = (wordLength >= 3 && wordLength <= 6) ? wordLength - 2 : 0;
                totalPoints += wordPoints; //decrypt +50 to each 6-letter word
                if (flag && wordLength == 6){
                    totalPoints += 50;
                }
            }
        }

        return totalPoints;
    }

    private static boolean isValidWord(String word, Map<Character, Integer> letterCount) {
        Map<Character, Integer> wordCount = new HashMap<>();

        for (char letter : word.toCharArray()) {
            wordCount.put(letter, wordCount.getOrDefault(letter, 0) + 1);
            if (!letterCount.containsKey(letter) || wordCount.get(letter) > letterCount.get(letter)) {
                return false;
            }
        }

        return true;
    }

    static List<List<Integer>> sumsUp(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        //Arrays.sort(arr);
        List<Integer> tmp = new ArrayList<>();
        // Внешний цикл
        for (int i = 0; i < arr.length; i++) {
            tmp.add(arr[i]);
            // Внутренний цикл
            for (int j = 0; j < tmp.size(); j++) {
                // Если найдена пара чисел, дающая в сумме 8, добавляем её в результат
                for (int k = j + 1; k < tmp.size(); k++) {
                    if (tmp.get(j) + tmp.get(k) == 8) {
                        List<Integer> pair = Arrays.asList(tmp.get(j), tmp.get(k));
                        Collections.sort(pair);
                        if (!result.contains(pair)) {
                            result.add(pair);
                        }
                    }
                }
            }
        }
        return result;
    }
    public static String takeDownAverage(String[] input){
            int count = input.length;
            int sum = 0;
            for (int i = 0; i < input.length; i++){
                sum += Integer.parseInt(input[i].replaceAll("[^0-9]",""));
            }
            int result = ((sum - 5*count*(count+1))/count);
            return String.valueOf(result);
    }
    public static String caesarCipher(String mode, String message, int shift) {
        String result = "";
        // Ограничиваем сдвиг до 26, чтобы избежать ошибок
        shift = shift % 26;

        if (mode.equalsIgnoreCase("encode")) {
            //проходимся по всем символам
            for (int i = 0; i < message.length(); i++) {
                char ch = message.toUpperCase().charAt(i);
                if (ch >= 'A' && ch <= 'Z') {
                    //меняем только буквы
                    ch = (char) (ch + shift);
                    while (ch > 'Z') {
                        ch = (char) (ch - 26);
                    }
                }
                result += ch;
            }
        } else if (mode.equalsIgnoreCase("decode")) {
            //здесь всё то же самое, но в обратном порядке
            for (int i = 0; i < message.length(); i++) {
                char ch = message.charAt(i);
                if (ch >= 'A' && ch <= 'Z') {
                    ch = (char) (ch - shift);
                    while (ch < 'A') {
                        ch = (char) (ch + 26);
                    }
                }
                result += ch;
            }
            result = result.toLowerCase();
        }
        return result;
    }

    public static int setSetup(int n, int k) {
        // проверка условия
        if (n < k) {
            throw new IllegalArgumentException("n должно быть больше или равно k");
        }
        if (k == 0 || k == n) {
            return 1;
        }
        // используем рекурсивную функцию для расчёта факториала
        return factorial(n) / factorial(n - k);
    }
    public static int factorial(int num) {
        if (num <= 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }
    public static String timeDifference(String cityA, String timestamp, String cityB) {
        // Создаем словарь с городами и их смещениями
        Map<String, String> cityOffsets = new HashMap<>();
        cityOffsets.put("Los Angeles", "-08:00");
        cityOffsets.put("New York", "-05:00");
        cityOffsets.put("Caracas", "-04:30");
        cityOffsets.put("Buenos Aires", "-03:00");
        cityOffsets.put("London", "00:00");
        cityOffsets.put("Rome", "+01:00");
        cityOffsets.put("Moscow", "+03:00");
        cityOffsets.put("Tehran", "+03:30");
        cityOffsets.put("New Delhi", "+05:30");
        cityOffsets.put("Beijing", "+08:00");
        cityOffsets.put("Canberra", "+10:00");

        // Парсим LocalDateTime используя DateTimeFormatter. Locale.US объявляет, что мы используем формат США.
        // Это нужно чтобы избежать ошибки, которая возникает если не добавить этот параметр.

        LocalDateTime dateTimeA;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d',' yyyy HH':'mm", Locale.US);
            dateTimeA = LocalDateTime.parse(timestamp, formatter);
        } catch (DateTimeParseException e) {
            System.err.println("Error: " + e.getMessage());
            return "error";
        }
        // Получаем смещение для городов A и B из словаря
        String offsetA = cityOffsets.get(cityA);
        String offsetB = cityOffsets.get(cityB);
        // чтобы вычислить, сколько часов прибавить (либо прибавить со знаком минус) к dateTimeA, нужно из смещения B вычесть смещение A.
        // например London GMT = 0, Moscow GMT = 3. delta_hours = 3-0 = 3.

        Integer hours_1;
        Integer minutes_1;
        // парсим смещения часов и минут городов A и B
        if (cityA == "London") {//в строке с GMT лондона нет знака + или -, поэтому substring не работает
            hours_1 = 0;
            minutes_1 = 0;
        } else {
            hours_1 = Integer.parseInt(offsetA.substring(0, 3));
            minutes_1 = Integer.parseInt(offsetA.substring(4));
        }

        Integer hours_2;
        Integer minutes_2;

        if (cityB == "London") {
            hours_2 = 0;
            minutes_2 = 0;
        } else {
            hours_2 = Integer.parseInt(offsetB.substring(0, 3));
            minutes_2 = Integer.parseInt(offsetB.substring(4));
        }

        Integer delta_hrs = hours_2 - hours_1; //вычисляем разницу. Если часы нужно прибавить, delta положительная, если вычесть - отрицательная
        Integer delta_mins = minutes_2 - minutes_1;

        //поэтому мы прибавляем дельту - знак в ней уже учтён
        LocalDateTime gmtDateTimeB = dateTimeA.plusHours(delta_hrs).plusMinutes(delta_mins);

        // Преобразуем в требуемый формат
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-M-d HH:mm", Locale.US);
        String formattedDateTimeB = gmtDateTimeB.format(outputFormatter);

        return formattedDateTimeB;
    }
    public static boolean isNew(int number) {
        // чтобы получить минимальное число из цифр, среди котоых есть нули,
        // нули нужно ставить после первого по счёту символа
        // пример: 23109 -> 10239
        // 8090340 -> 3000489

        // Преобразуем число в строку
        String strNumber = Integer.toString(number);
        // Преобразуем строку в массив
        ArrayList<String> arr = new ArrayList<>();
        for(int i = 0; i < strNumber.length(); i++){
            arr.add(String.valueOf(strNumber.charAt(i)));
        }
        // убираем все нули
        int zeros = 0;
        while (arr.contains("0")) {
            zeros++;
            arr.remove("0");
        }
        // Сортируем массив символов в порядке возрастания
        Collections.sort(arr);
        while (zeros > 0) {
            arr.add(1, "0");
            zeros--;
        }
        // Преобразуем отсортированный массив символов обратно в строку
        String sortedStrNumber = "";
        for(String x : arr) {
            sortedStrNumber += x;
        }
        // Преобразуем отсортированную строку обратно в число
        int sortedNumber = Integer.parseInt(sortedStrNumber);
        // Сравниваем отсортированное число с исходным
        if (sortedNumber == number) {
            return true; // Число является новым
        } else {
            return false; // Число не является новым
        }
    }
}
