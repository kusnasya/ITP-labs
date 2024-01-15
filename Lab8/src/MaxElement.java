public class MaxElement extends Thread{
    private int[] row;
    private int maxElement;
    public MaxElement(int[] row) {
        this.row = row;
    }
    public void run() {
        maxElement = row[0];
        for (int i = 1; i < row.length; i++) {
            if (row[i] > maxElement) {
                maxElement = row[i];
            }
        }
    }

    public int getMaxElement() {
        return maxElement;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, -11, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        MaxElement[] finders = new MaxElement[matrix.length];
        // Создаем потоки для каждой строки матрицы
        for (int i = 0; i < matrix.length; i++) {
            finders[i] = new MaxElement(matrix[i]);
            finders[i].start();
        }
        // Ожидаем завершения работы всех потоков
        try {
            for (MaxElement finder : finders) {
                finder.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int maxElement = finders[0].getMaxElement();
        for (int i = 1; i < finders.length; i++) {
            if (finders[i].getMaxElement() > maxElement) {
                maxElement = finders[i].getMaxElement();
            }
        }
        System.out.println("The largest element in the matrix is: " + maxElement);
    }
}
