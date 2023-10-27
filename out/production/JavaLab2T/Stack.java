import java.util.EmptyStackException;

public class Stack {
    private int maxSize;
    private int top;
    private int[] stackArray;

    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int value) {



        if (isFull()) {
            System.out.println("Стек переповнений. Неможливо додати елемент " + value);
        } else {
            stackArray[++top] = value;
            System.out.println("Додано елемент: " + value);
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            int value = stackArray[top];
            top--;
            System.out.println("Вилучено елемент: " + value);
            return value;
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return stackArray[top];
        }
    }

    public int search(int value) {
        for (int i = top; i >= 0; i--) {
            if (stackArray[i] == value) {
                return top - i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println("Пошук елемента 30: позиція від вершини - " + stack.search(30));

        System.out.println("Вершина стеку: " + stack.peek());

        stack.pop();
        stack.pop();

        System.out.println("Вершина стеку після вилучення двох елементів: " + stack.peek());
    }
}