package str;

/**
 * KMP算法
 *  其基本思想是：每当匹配过程中出现字符串比较不等时，不需回溯指针，
 *  而是利用已经得到的“部分匹配”结果将模式向右“滑动”尽可能远的一段距离，继续进行比较。显然我们首先需要获取一个“部分匹配”的结果，该结果怎么计算呢？
 *
 * 当目标字符串与源字符串进行比较时，会逐个字符进行比较一旦发现不匹配就会重新回到头部进行比较，比较浪费时间
 * 最重要的就是部分匹配表
 *
 * https://www.cnblogs.com/fuck1/p/6059736.html
 */
public class s_02_kmp {

    /**
           * @param args
           */
  public static void main(String[] args) {
               String src = "aaaaaaab";
               String sub = "ABCDABDABD";
//               int[] next = KMP.getNext(sub);
                int[] next = GetNextVal(sub);
               for (int i : next) {
                       System.out.print(i + "  ");// -1 0 1 2 3
                    }

                System.out.println();
                System.out.println(KMP.kmp(src, sub));
      System.out.println("----------");
                getNext(sub);
           }

    //补充上一篇中的对于前缀后缀的讨论的获取部分匹配数组的算法
    public static int[] lengthKMP(char[] mchar) {
              int[] fixNum = new int[mchar.length];
               for (int i = 1, j = 0; i < mchar.length; i++) {
                    if (mchar[j] == mchar[i]) {
                             fixNum[i] = j + 1;
                            j++;
                      } else if (j > 0) {
                              j = 0;
                              i -= j;
                          }
                   }
                // return [0, 0, 0, 0, 1, 2, 0, 1, 2, 0]ABCDABDABD
               return fixNum;
           }

    public static int[] getNext(String match) {

        int[] next = new int[match.length()];
        next[0] = -1;
        int i, j, len;
        for (j = 1; j < match.length(); j++)   // 相等子串的从match[0]-match[j-1]查找
        {
            for (len = j - 1; len >= 1; len--) {
                for (i = 0; i < len; i++)        // 依次比较match[0]-match[len-1] 与 match[j-len]-match[j-1]
                {
                    if (match.charAt(i) != match.charAt(i + j - len))
                        break;
                }
                if (len == i) {
                    next[j] = len;
                    break;
                }
            }
            if (len < 1)
                next[j] = 0;
        }
        System.out.print(match + "的next[]数组为：");
        for (int interger : next)
            System.out.print(interger + " ");

        return next;
    }

    private static int[] GetNextVal(String smallstr) {
        int k = -1;     //前缀串起始位置("-1"是方便计算）
        int j = 0;      //后缀串起始位置（"-1"是方便计算）
        int[] next = new int[smallstr.length()];

        next[j] = -1;   //根据公式： j=0时，next[j]=-1

        while (j < smallstr.length() - 1){
            if (k == -1 || smallstr.charAt(k) == smallstr.charAt(j)){
                next[++j] = ++k;    //pk=pj的情况: next[j+1]=k+1 => next[j+1]=next[j]+1
            } else{
                //pk != pj 的情况:我们递推 k=next[k];
                //要么找到，要么k=-1中止
                k = next[k];
            }
        }

        return next;
    }

}
