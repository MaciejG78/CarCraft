package pl.com.bottega.stack;

/**
 * Created by macie on 15.12.2016.
 */
public class ConsoleStackApp {

    public static void main(String[] args) {

        ArrayStack<String> arrayStack = new ArrayStack<>();

        arrayStack.push("test1");
        arrayStack.pop();
        arrayStack.push("test2");
        arrayStack.push("test3");
        arrayStack.push("test4");
        System.out.println(arrayStack);
        arrayStack.pop();
        arrayStack.pop();
        System.out.println(arrayStack);
        arrayStack.push("test5");
        arrayStack.push("test6");
        arrayStack.pop();
        System.out.println(arrayStack);
        arrayStack.push("test7");
        arrayStack.push("test8");
        System.out.println(arrayStack);
        arrayStack.pop();
        System.out.println(arrayStack);
    }
}