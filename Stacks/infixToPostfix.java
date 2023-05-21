import java.util.Scanner;
import java.util.Stack;

public class infixToPostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your expression");
        String exp = sc.nextLine(); // this holds the infix expressions to be converted into postfix.

        Stack<Character> tors = new Stack<>();
        Stack<String> pre = new Stack<>();

        for(int i =0; i<exp.length();i++){
            char ch = exp.charAt(i);
            if(ch == '(')
                tors.push(ch);
            else if((ch>= '0' && ch<='9') || (ch>= 'a' && ch<='z') || (ch>= 'A' && ch<='Z'))
                pre.push(ch+"");
            else if(ch == ')'){
                while(tors.peek()!='('){
                    String v2 = pre.pop();
                    String v1 = pre.pop();
                    char optor = tors.pop();

                    pre.push(optor+v1+v2);
                }
                tors.pop();
            } else if(ch == '+'||ch == '-'||ch == '*'||ch == '/'){
                while(tors.size()>0 && tors.peek()!='(' && precedence(ch)<=precedence(tors.peek())){
                    String v2 = pre.pop();
                    String v1 = pre.pop();
                    char optor = tors.pop();

                    pre.push(optor+v1+v2);
                }
                tors.push(ch); 
            }

        }
        while(tors.size()>0){
            String v2 = pre.pop();
            String v1 = pre.pop();
            char optor = tors.pop();

            pre.push(optor+v1+v2);
        }
        System.out.println(pre.pop());

    }
    public static int precedence(char ch){
        if(ch=='+' || ch =='-')
            return 1;
        else if (ch == '*' || ch == '/')
            return 2;
        return 0;
    }
}
