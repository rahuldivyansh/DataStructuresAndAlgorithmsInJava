import java.util.*;

// This program prints all possible words that can be made from the given number.

public class printEncodings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your number : ");
        String ques = sc.next();
        System.out.println("Your final answer is : ");
        pe(ques, "");

    }
    static String []codes = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    public static void pe(String ques, String ans){

        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }

        // char ch = ques.charAt(0);
        if(ques.length() > 2)
        {
            String rques = ques.substring(1,3);
            pe(rques, ans+codes[Integer.parseInt(rques)-1]);

        }
        else{
            
            pe(ques, ans+codes[Integer.parseInt(ques)-1]);
        }
    }
}
