package chat_3;

public interface MyStack<E> {
    void push(E e);
    E pop(); // 获取stack顶元素，并删除stack顶元素
    E peek();// 获取stack顶元素，但是不删除stack元素
    int getSize();
    boolean isEmpty();
}
