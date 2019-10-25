package chat_2;

public class Main {

    public static void main(String[] args) {
//        MyArray<Integer> myArray = new MyArray<Integer>();
//        myArray.addLast(66);
//        myArray.addLast(88);
//        myArray.addLast(99);
//        myArray.addLast(100);
//        System.out.println(myArray.toString());
//
//        myArray.add(1,77);
//        System.out.println(myArray.toString());
//
//        myArray.remove(1);
//        System.out.println(myArray.toString());

        MyArray<Integer> arr = new MyArray<>();
        System.out.println(arr);
        for(int i = 0 ; i < 10 ; i ++)
            arr.addLast(i);
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

        for(int i = 0 ; i < 4 ; i ++){
            arr.removeFirst();
            System.out.println(arr);
        }
    }
}
