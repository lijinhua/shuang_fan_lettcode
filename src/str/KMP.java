package str;

public class KMP {
  
      // 获取next数组的方法,根据给定的字符串求
      public static int[] getNext(String sub) {
  
         int j = 1, k = 0;
         int[] next = new int[sub.length()];
         next[0] = -1; // 这个是规定
         next[1] = 0; // 这个也是规定
         //
         while (j < sub.length() - 1) {
            if (sub.charAt(j) == sub.charAt(k)) {
                next[j + 1] = k + 1;
                 j++;
                 k++;
           } else if (k == 0) {
                next[j + 1] = 0;
                j++;
           } else {
                k = next[k];
            }

       }
        return next;
    }
 
    // 根据给定的主串和子串，采用KMP算法来获取模式匹配
    public static int kmp(String src, String sub) {

         // 首先生成模式串sub的next[j]
         int[] next = getNext(sub);
         int i = 0, j = 0, index = -1;
        while (i < src.length() && j < sub.length()) {
             if (src.charAt(i) == sub.charAt(j)) {
                 i++;
                 j++;
            } else if (j == 0) {
                 i++;
             } else {
                j = next[j];
             }
         }
 
         // 得到开始匹配的位置索引
         if (j == sub.length()) {
             index = i - sub.length();
         }
         return index;
     }
 }