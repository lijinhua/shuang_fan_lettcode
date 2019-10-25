package chat_3;

import chat_2.MyArray;

/**
 * 基于数组的实现
 * @param <E>
 */
public class ArrayStack<E> implements MyStack<E> {

    MyArray<E> myArray;

    public ArrayStack(){
        this(10);
    }

    public ArrayStack(int capacity){
        myArray = new MyArray<E>(capacity);
    }
    @Override
    public void push(E e) {
        myArray.addLast(e);
    }

    @Override
    public E pop() {
        return myArray.removeLast();
    }

    @Override
    public E peek() {
        return myArray.getLast();
    }

    @Override
    public int getSize() {
        return myArray.getSize();
    }

    @Override
    public boolean isEmpty() {
        return myArray.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for(int i = 0 ; i < myArray.getSize() ; i ++){
            res.append(myArray.get(i));
            if(i != myArray.getSize() - 1)
                res.append(", ");
        }
        res.append("] top");
        return res.toString();
    }
}
