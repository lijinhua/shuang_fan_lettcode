package executor;

public class TestPhone {

    public static void main(String[] args){
        for(int i=0;i<=9999;i++){
            String str = String.valueOf(i);
            char[] ary1 = str.toCharArray();

            char[] ary2 = {'0','0','0','0'};



            System.arraycopy(ary1, 0, ary2, ary2.length-ary1.length, ary1.length);

            String result = new String(ary2);

            System.out.println("1000000"+result);
        }
    }
}
