package dz2;

/**
 * Created by admin on 18.11.2017.
 */
public class Application {
    public static void main(String[] args) {
        Queue queue = new Queue(4);
        queue.print();

        queue.dequeue();
        queue.print();
        queue.dequeue();
        queue.print();
        queue.dequeue();
        queue.print();
        queue.dequeue();
        queue.print();
        queue.dequeue();
        queue.print();

        queue.enqueue(25);
        queue.print();
        queue.enqueue(30);
        queue.print();
        queue.enqueue(35);
        queue.print();
        queue.enqueue(40);
        queue.print();
        queue.dequeue();
        queue.print();
        queue.enqueue(45);
        queue.print();
        queue.dequeue();
        queue.print();
    }
}
