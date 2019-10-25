package str;

/**
 * 暴力匹配算法 也叫简单匹配算法
 *
 * https://www.cnblogs.com/fuck1/p/6013543.html
 * https://blog.csdn.net/chndata/article/details/43792363
 * 原理:
 * 从目标字符串初始位置开始，依次分别与Pattern的各个位置的字符比较，
 * 如相同，比较下一个位置的字符直至完全匹配；如果不同则跳到目标字符串下一位置继续如此与Pattern比较，直至找到匹配字符串并返回其位置。
 *
 * 我们注意到Brute Force 算法是每次移动一个单位，一个一个单位移动显然太慢，设目标串String的长度为m，Pattern的长度为n，不难得出BF算法的时间复杂度最坏为O(mn)，效率很低。
 */
public class s_01_bf {

    /**
      * 找出指定字符串在目标字符串中的位置
      * @param source 目标字符串
      * @param pattern 指定字符串
      * @return 指定字符串在目标字符串中的位置
     */
    public static int match(String source, String pattern)
    {
        int index = -1;
        boolean match = true;
        for(int i=0,len =source.length()-pattern.length();i<=len;i++){
            match = true;
            for(int j=0;j<pattern.length();j++){
                if(source.charAt(i+j)!=pattern.charAt(j)){
                    match = false;
                    break;
                }
            }

            if (match) {
                index = i;
                 break;
               }
        }
        return index;
    }
    public static void main(String[] args){
        System.out.println(match("cdeftdggg","dggg"));

    }
}
