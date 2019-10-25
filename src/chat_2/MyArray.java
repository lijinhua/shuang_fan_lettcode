package chat_2;

public class MyArray<E> {
    private E[] data;
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public MyArray(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }
    // 无参数的构造函数，默认数组的容量capacity=10
    public MyArray(){
        this(10);
    }

    public void addFirst(E e){
        add(0,e);
    }
    public void addLast(E element){
        add(size,element);
    }

    // 从数组中删除元素e
    public void removeElement(E e)
    {
       int resultIndex =  find(e);
       if(resultIndex!=-1){
          remove(resultIndex) ;
       }
    }
    public E removeFirst(){
       return remove(0);
    }
    public E removeLast(){
        return remove(size-1);
    }

    public E getFirst(){
        return get(0);
    }
    public E getLast(){
        return get(size-1);
    }
    public void add(int index,E element){

        if(index>size || index<0 ){
            throw  new RuntimeException("index 不合法");
        }
        if(size==data.length){
            resize(size*2);
        }
        for(int i=size-1;i>=index;i--){
            data[i+1] = data[i];
        }
        data[index] = element;
        size++;
    }

    private void resize(int capacity){
      Object[] newData = (E[]) new Object[capacity];
      for(int i=0;i<size;i++){
        newData[i] = data[i];
      }
      data = (E[]) newData;
    }

    // 获取index索引位置的元素
    public E get(int index){
        if(index<0|| index>=size){
            throw  new RuntimeException("index 不合法");
        }
        return data[index];
    }

    //修改index索引位置的元素为e
    public void set(int index,E element){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index] = element;
    }

    public boolean contain(E e){
        for(E item:data){
            if(e==item){
                return true;
            }
        }
        return false;
    }

    public int find(E element){
        for(int i=0;i<data.length;i++){
           if(data[i]==element){
               return i;
           }
        }
        return -1;
    }

    public E remove(int index)
    {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        E removeElement = data[index];
        for(int i=index;i<size-1;i++){
            data[i] = data[i+1];
        }
        size--;
        data[size] = null;// loitering objects != memory leak

        if(size==(data.length/4) && data.length/2!=0){
            resize((data.length/2));
        }
        return removeElement;
    }

    // 获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    // 获取数组中的元素个数
    public int getSize(){
        return size;
    }

    // 返回数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
