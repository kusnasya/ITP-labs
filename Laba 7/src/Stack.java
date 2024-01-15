import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack <T>{
    private T[] data; // data - массив для хранения элементов стека. size - текущий размер стека.
    private int size;

    public Stack(int capacity) { // capacity - максимальную емкость стека.
        data = (T[]) new Object[capacity];
        size = 0;
    }
    public void push(T element) {
        if (size == data.length) {
            T[] newData = (T[]) new Object[data.length * 2];
            for (int i = 0; i < data.length;i++){
                newData[i] = data[i];
            }
            data = newData;
        }
        data[size++] = element;
    } // Метод добавляет элемент в стек. Если стек уже полон, генерируется исключение StackOverflowError.

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T element = data[--size];
        data[size] = null;
        return element;
    } // Метод удаляет и возвращает верхний элемент стека. Если стек пуст, генерируется исключение EmptyStackException.

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return data[size - 1];
    } // Метод возвращает верхний элемент стека без его удаления. Если стек пуст, генерируется исключение EmptyStackException.
    public T pull(){
        for (int i = 0; i < data.length; i++){
            System.out.println(data[i]); ;
        }
        return null;
    }
}
