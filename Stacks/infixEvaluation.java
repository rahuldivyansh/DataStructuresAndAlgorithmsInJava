import java.util.Scanner;

public class infixEvaluation{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your statement to evaluate");
        String s = sc.nextLine();

        public static int precedence (char optor){
            if(optor == '+'||optor == '-')
                return 1;
            else if(optor == '*'||optor == '/')
                return 2;        
        }
    }
}