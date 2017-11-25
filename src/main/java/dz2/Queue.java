package dz2;

import java.util.Arrays;

/**
 * Created by admin on 18.11.2017.
 */
public class Queue {
    int length = 3;

    public int getSize() {
        return size;
    }

    int size;
    int queue [];

    public Queue(int size) {
        queue = new int [length];
        for (int i = 0; i < size; i ++)
            enqueue(i+1);
        this.size = size;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void enqueue(int number) {
        if (size == length) {
            int [] queueTemp = queue;
            setLength(length*2);
            queue = new int [getLength()];
            System.arraycopy(queueTemp, 0, queue, 0, size);
        }
        queue[size++] = number;
    }


    public void dequeue(){
        if (size > 0) {
            for (int i = 0; i < size - 1; i++)
                queue[i] = queue[i + 1];

            queue[size - 1] = 0;
            size--;
        }
        else if (size == 0)
            System.out.println("Невозможно выполнить операцию: очередь пуста.");

    }

    public int getQueueMember(int nomer) {
        return queue[nomer];
    }

    public void setQueue(int[] queue) {
        this.queue = queue;
    }

    @Override
    public String toString() {
        int [] queueString = new int [size];
        for (int i = 0; i < size; i++)
            queueString[i] = queue[i];

        return Arrays.toString(queueString);
    }

    public void print() {
        if (size == 0)
            System.out.println("Очередь пуста.");
        else
            System.out.println("Очередь: " + this.toString());
    }
}
