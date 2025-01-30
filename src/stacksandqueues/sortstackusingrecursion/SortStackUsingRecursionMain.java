package stacksandqueues.sortstackusingrecursion;

import java.util.Stack;

public class SortStackUsingRecursionMain {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(2);
        stack.push(4);
        stack.push(1);
        stack.push(3);
        System.out.println("Before Sorting: "+stack);

        StackSorter sorter =  new StackSorter(stack);
        sorter.sortStack();

        System.out.println("After Sorting: "+stack);

    }
}
