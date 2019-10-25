import java.io.File;
import java.util.*;

/**
 * F:\桌面\需要掌握的知识\算法\玩转数据结构 从入门到进阶\Play-with-Data-Structures-master
 */
public class Main {

    public static void main(String[] args) {
        String path = "/Users/lijinhua/Desktop/16/";

        List< File> files = Arrays.asList(new File(path).listFiles());
        List<File> newFile = new ArrayList<>();
        for (File f : files) {
            if(f.getName().contains(".png")){
                newFile.add(f);
            }

        }

        Collections.sort(newFile, new Comparator< File>() {
            public int compare(File f1, File f2) {
//                return (f1.getName()).compareTo(f2.getName());
                long diff = Integer.parseInt(f1.getName().replace(".png","")) - Integer.parseInt(f2.getName().replace(".png",""));
                if (diff > 0)
                    return 1;
                else if (diff == 0)
                    return 0;
                else
                    return -1;

            }
            public boolean equals(Object obj) {
                return true;
            }
        });



       int row = -1,col = 0;
//        int row = 9,col = 0;
       for(int i=0;i<newFile.size();i++){
           File file = newFile.get(i);
          //
           if(i%10==0){
               row++;
               col= 0;
           }
           String fileName = col+"_"+row+".png";
          File file1 =  new File(path+fileName);
           file.renameTo(file1);
           col++;

//           System.out.println(file.getName()+"----"+file1.getName());
           System.out.println(file.getName()+"----"+fileName);
       }
//        test();
    }

    public static void test(){
        System.out.println(377/3.0f);
        Map<String, String> map = new HashMap<String, String>(10);
        map.put("1", "AA");
        map.put("1", "BB");
        System.out.println(map.get("1")+" szie="+map.size());
    }
}
