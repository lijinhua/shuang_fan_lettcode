package chat_4;

public class MyLinkList<E> {

    private class Node{
        E e;
        Node next;

        public Node(){
            this(null);
        }
        public Node(E e){
            this(e,null);
        }

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    public Node dummyHead;
    public int size;
    public MyLinkList(){
        dummyHead = new Node();
        size = 0;
    }

    // 获取链表中元素的个数
    public int getSize(){
        return size;
    }
    public void addFirst(E e){
      add(0,e);
    }
    // 向指定的位置插入元素
    public void add(int index,E e){
        if( index<0 || index>=size){
            throw  new RuntimeException("index不合法");
        }
        Node preNode =dummyHead;
        for(int i=0;i<index;i++){
            preNode = preNode.next;
        }
        Node node = new Node(e,preNode.next);
        preNode.next = node;
        size++;

    }
    // 在尾部增加元素
    public void addLast(E e){
          add(size,e);
    }
    // 获得链表的第index(0-based)个位置的元素
    // 在链表中不是一个常用的操作，练习用：）
    public E get(int index){
        if(index<0 || index>=size){
            throw new RuntimeException("index 不合法");
        }
        Node preNode = dummyHead;
        for(int i=0;i<index;i++){
            preNode = preNode.next;
        }
        return  preNode.e;
    }

    // 获得链表的第一个元素
    public E getFirst()
    {
        return get(0);
    }

    // 获得链表的最后一个元素
    public E getLast()
    {
        return get(size-1);
    }

    // 修改链表的第index(0-based)个位置的元素为e
    // 在链表中不是一个常用的操作，练习用：）
    public void set(int index, E e){
        if(index<0 || index>=size){
            throw new RuntimeException("index 不合法");
        }
        Node preNode = dummyHead.next;
        for(int i=0;i<index;i++){
            preNode = preNode.next;
        }
        preNode.e =e;
    }
    // 查找链表中是否有元素e
    public boolean contains(E e)
    {
        Node preNode = dummyHead.next;
       while (preNode!=null){
           if(preNode.e.equals(e)){
               return  true;
           }
           preNode = preNode.next;
       }
       return false;
    }

    // 从链表中删除index(0-based)位置的元素, 返回删除的元素
    // 在链表中不是一个常用的操作，练习用：）
    public E remove(int index)
    {
        if(index<0 || index>=size){
            throw new RuntimeException("index 不合法");
        }
        Node node = dummyHead;
        return node.e;
    }

    public E removeFirst(){
       return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    public void removeElement(E e){
        Node pre = dummyHead;
        while (pre.next!=null){
            if(pre.e.equals(e)){
                break;
            }
            pre = pre.next;
        }
        if(pre.next!=null){
            Node delNode = pre.next;
            pre.next = delNode.next;
            delNode.next=null;
            size--;
        }
    }
    @Override
    public String toString() {
        StringBuilder ssb = new StringBuilder();
        for(Node node = dummyHead;node!=null;node = node.next){
            ssb.append(node + "->");
        }
        ssb.append("NULL");
        return ssb.toString();
    }
}
