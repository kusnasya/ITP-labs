import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Task1 {
    public static void main(String[] args) {
        System.out.println("Task - 1");
        System.out.println("************");
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));
        System.out.println("************");

        System.out.println("Task - 2");
        System.out.println("************");
        System.out.println(fitCalc(15,1));
        System.out.println(fitCalc(24,2));
        System.out.println(fitCalc(41,3));
        System.out.println("************");

        System.out.println("Task - 3");
        System.out.println("************");
        System.out.println(containers(3,4,2));
        System.out.println(containers(5,0,2));
        System.out.println(containers(4,1,4));
        System.out.println("************");

        System.out.println("Task - 4");
        System.out.println("************");
        System.out.println(triangleType(5, 5, 5));
        System.out.println(triangleType(5, 4, 5));
        System.out.println(triangleType(3, 4, 5));
        System.out.println(triangleType(5, 1, 1));
        System.out.println("************");

        System.out.println("Task - 5");
        System.out.println("************");
        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9));
        System.out.println("************");

        System.out.println("Task - 6");
        System.out.println("************");
        System.out.println(howManyItems(22, 1.4f, 2));
        System.out.println(howManyItems(45, 1.8f, 1.9f));
        System.out.println(howManyItems(100, 2, 2));
        System.out.println("************");

        System.out.println("Task - 7");
        System.out.println("************");
        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));
        System.out.println("************");

        System.out.println("Task - 8");
        System.out.println("************");
        System.out.println(gcd(48,18));
        System.out.println(gcd(52,8));
        System.out.println(gcd(259,28));
        System.out.println("************");

        System.out.println("Task - 9");
        System.out.println("************");
        System.out.println(ticketSaler(70,1500));
        System.out.println(ticketSaler(24,950));
        System.out.println(ticketSaler(53,1250));
        System.out.println("************");

        System.out.println("Task - 10");
        System.out.println("************");
        System.out.println(tables(5,2));
        System.out.println(tables(31,20));
        System.out.println(tables(123,58));
        System.out.println("************");
    }
    public static float convert(int x){
        return x * 3.785f;
    }
    public static int fitCalc(int time, int intensity){
        return time * intensity;
    }
    public static int containers(int box, int bag, int barrel){
        return box * 20 + bag * 50 + barrel * 100;
    }
    public static String triangleType(int side1, int side2, int side3){
        int[] sides = {side1, side2, side3};
        Arrays.sort(sides);
        if (sides[2] < sides[0] + sides[1]) {
            if (sides[0] == sides[1] && sides[1] == sides[2]) {
                return "isosceles";
            } else if (sides[0] == sides[1] || sides[1] == sides[2]) {
                return "equilateral";
            } else {
                return "different-sided";
            }
        } else{
            return "not a triangle";
        }
    }
    public static int ternaryEvaluation(int a, int b){
        return (a > b) ? a : b;
    }
    public static int howManyItems(float n, float w, float h){
        return (int) (n / w / h / 2f);
    }
    public static int factorial(int factNumber){
        int result = 1;
        for (int i = 1; i <= factNumber; i++){
            result *= i;
        }
        return result;
    }
    public static int gcd(int a, int b){
        while (b!=0){
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
    public static int ticketSaler(int tickets, int cost){
        return (int) (tickets * cost * 0.72f);
    }
    public static int tables(int students, int curTables){
        int normTables = (students % 2 != 0 ? students / 2 + 1 : students / 2);
        if (normTables <= curTables){
            return 0;
        } else {
            return normTables - curTables;
        }
    }
}