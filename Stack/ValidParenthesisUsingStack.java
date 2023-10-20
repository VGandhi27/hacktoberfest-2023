import java.util.*;
public class ValidParenthesisUsingStack {
    public static void main(String[] args){
        String sequence = "{[()]}";
        System.out.println(sequence +" is "+isValid(sequence));
    }

    static boolean isValid(String s){
        int n = s.length();
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch=='[' || ch=='{' || ch=='('){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }else if(!pairMatch(stack.peek(),ch)){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    static boolean pairMatch(char a, char b){
        if(a=='[' && b==']'){
            return true;
        }
        if(a=='{' && b=='}'){
            return true;
        }
        if(a=='(' && b==')'){
            return true;
        }
        return false;
    }
}
