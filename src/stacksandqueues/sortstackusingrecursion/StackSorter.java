package stacksandqueues.sortstackusingrecursion;

import java.util.Stack;

class StackSorter {
    Stack<Integer> st1 = new Stack<>();

    public StackSorter(Stack<Integer> st1 ){
        this.st1 = st1;
    }

    public void sortStack(){
        if(!st1.isEmpty()){
            int val = st1.pop();
            sortStack();
            insertSortedOrder(val);
        }
    }

    public void insertSortedOrder(int element){
        if(st1.isEmpty() || st1.peek() <= element){
            st1.push(element);
        }else{
            int ele = st1.pop();
            insertSortedOrder(element);
            st1.push(ele);
        }
    }
}
