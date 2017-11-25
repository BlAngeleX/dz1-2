package dz2;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class QueueProcessorTest {


        /**
         * проверяем работу конструкторв:
         * формируем очередь с последовательным набором чисел [1;count) е N
         */
        @Test
        public void testConstructQueue_validParams_generateNewQueueWithConsecutiveNumbers ()
        {
            int count = 13;
            boolean ok = false;
            Queue queue[] = new Queue[count];
            for (int i = 0; i < count; i++) {
                queue[i] = new Queue(i);
                for (int j = 0; j < i; j++) {
                    Assertions.assertTrue(queue[i].getQueueMember(j) == j+1);
                }
            }

        }

        /**
         * проверка размера очереди и количества свободных в ней мест
         */
        @Test
        public void testConstructQueue_validParams_generateNewQueueWithDefiniteSize ()
        {
            Queue queue = new Queue(10);
            Assertions.assertTrue(queue.getSize() == 10);
            Assertions.assertTrue(queue.getLength() == 12);
        }

        /**
         * тест удаления члена очереди
         */
        @Test
        public void testDequeue_validParams_deleteQueueMember (){
            Queue queue = new Queue(10);
            queue.dequeue();
            for (int i = 0; i < 10; i++)
                if (i < 9)
                    Assertions.assertTrue(queue.getQueueMember(i) == i+2);
                else Assertions.assertTrue(queue.getQueueMember(i) == 0);
        }

        /**
         * тест добавления члена в очередь
         */
        @Test
        public void testEnqueue_validParams_addQueueMember () {
            Queue queue = new Queue(12);
            Assertions.assertTrue(queue.getLength() == 12);
            queue.enqueue(30);
            for (int i = 0; i < 13; i++)
                if (i < 12)
                    Assertions.assertTrue(queue.getQueueMember(i) == i+1);
                else Assertions.assertTrue(queue.getQueueMember(i) == 30);
            Assertions.assertTrue(queue.getLength() == 24);
        }
}
