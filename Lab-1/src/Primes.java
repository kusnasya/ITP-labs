public class Primes {
    public static void main(String[] args){
        IsPrime(100);
    }
    public static boolean IsPrime(int n){
        for (int i = 2; i < n; i++){
            boolean flag = true;
            for (int j = 2; j < (i / 2); j ++){
                if (i % j == 0){
                    flag = false;
                }
            }
            if (flag){
                System.out.println(i);
            }
        }
        return false;
    }
}
