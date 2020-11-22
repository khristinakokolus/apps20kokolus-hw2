package ua.edu.ucu.collections;

import lombok.Getter;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
@Getter
public class Queue {
    private ImmutableLinkedList queue;

    public Queue(ImmutableLinkedList newQueue) {
        this.queue = newQueue;
    }

    public Object peek() {
        return queue.getFirst();
    }

    public Object dequeue() {
        Object first;
        first = queue.getFirst();
        queue = queue.removeFirst();
        return first;
    }

    public void enqueue(Object e) {
        queue = queue.addLast(e);
    }
    
}
