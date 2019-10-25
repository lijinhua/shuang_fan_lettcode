package chat_3;

public class LoopQueue<E> implements MyQueue<E> {

    public E[] data;
    public int front,tail;
    public int size;

    public LoopQueue(){
        this(10);
    }
    public LoopQueue(int capacity){
        data = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }
    @Override
    public void enqueue(E e) {
        // 入队
        if((tail+1)%data.length==front){
            // 队列满了,扩容
            resize(data.length*2);
        }
        data[tail] = e;
        tail = (tail+1)%(data.length);
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw  new RuntimeException("数组为空不能出队");
        }
       E resultE =  data[front];
        data[front] = null;
        front = (front+1)%data.length;
       size--;
        if(size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return resultE;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw  new RuntimeException("数组为空不能出队");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front==tail;
    }

    public void resize(int capacity){
        E[] newData = (E[]) new Object[capacity];
        for(int i=0;i<size;i++){
            newData[i] = data[(i+front)%data.length];
        }
        data = newData;
        front=0;
        tail=size;
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, data.length));
        res.append("front [");
        for(int i = front ; i != tail ; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args){

        LoopQueue<Integer> queue = new LoopQueue<>();
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
