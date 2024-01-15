public class ArrayAverage {
    public static void main(String[] args) {
        String[] arr = {"1", "д", "3", "4", "6"};
        double sum = 0;
        double average = 0;

        try {
            for (int i = 0; i <= arr.length-1; i++) {
                sum += Integer.parseInt(arr[i]);
            }
            average = sum / arr.length;
            System.out.println("Среднее арифметическое: " + average);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: выход за границы массива");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: неверный формат числа");
        }
    }
}