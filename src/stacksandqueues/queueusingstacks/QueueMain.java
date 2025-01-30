package stacksandqueues.queueusingstacks;

public class QueueMain {
    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue() + " deleted from queue");
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.dequeue() + " deleted from queue");
        System.out.println(queue.isEmpty());
    }
}
