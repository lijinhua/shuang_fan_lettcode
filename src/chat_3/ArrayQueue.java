package chat_3;

import chat_2.MyArray;

public class ArrayQueue<E> implements MyQueue<E> {

    MyArray<E> myArray;
    public ArrayQueue(){
        this(10);
    }

    public ArrayQueue(int capacity)
    {
        myArray = new MyArray<>(capacity);
    }
    @Override
    public void enqueue(E e) {
        myArray.addLast(e);
    }

    @Override
    public E dequeue() {
        return myArray.removeFirst();
    }

    @Override
    public E getFront() {
        return myArray.getFirst();
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
        res.append("Queue: ");
        res.append("front [");
        for(int i = 0 ; i < myArray.getSize() ; i ++){
            res.append(myArray.get(i));
            if(i != myArray.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
    public static void main(String[] args) {

        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
