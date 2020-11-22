package ua.edu.ucu.collections;

import lombok.Getter;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
@Getter
public class Stack {
    private ImmutableLinkedList stack;


    public Stack(ImmutableLinkedList newStack) {
        this.stack = newStack;
    }

    public Object peek() {
        return stack.getFirst();
    }

    public Object pop() {
        Object last;
        last = stack.getFirst();
        stack = stack.removeFirst();
        return last;
    }

    void push(Object e) {
        stack = stack.addFirst(e);
    }
    
}
