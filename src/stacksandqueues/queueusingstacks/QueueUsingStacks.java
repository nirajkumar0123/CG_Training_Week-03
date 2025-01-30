package stacksandqueues.queueusingstacks;

import java.util.Stack;

class QueueUsingStacks {
    Stack<Integer> st1;
    Stack<Integer> st2;

    public QueueUsingStacks() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    //enqueue operation for stack
    public void enqueue(int data){
        st1.push(data);
        System.out.println(data + " entered into queue");
    }

    //Dequeue operation for stack
    public int dequeue(){
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
        int deleted = st2.pop();
        return deleted;
    }

    //peek operation
    public int peek(){
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
       return st2.peek();
    }

    //check if queue is empty;
    public boolean isEmpty() {
        return st1.isEmpty() && st2.isEmpty();
    }
}
