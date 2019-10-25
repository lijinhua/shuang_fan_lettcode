package leetcode.chat_3;

import chat_3.ArrayStack;

/**
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 */
public class StackDemo {

    public static void main(String[] args){
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("([)]"));
    }

    public static boolean isValid(String s)
    {
        if(s==null ||s.isEmpty()){
            return false;
        }
        ArrayStack<Character> arrayStack = new ArrayStack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('|| c=='{' || c=='['){
                arrayStack.push(c);
            }else{
                if(arrayStack.isEmpty()){
                    return false;
                }
                char popChar = arrayStack.pop();
                if(c==')' && popChar!='('){
                   return false;
                }
                if(c=='}' && popChar!='{'){
                    return false;
                }
                if(c==']' && popChar!='['){
                    return false;
                }
            }
        }
        return arrayStack.isEmpty();
    }
}
