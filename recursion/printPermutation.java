import java.util.Scanner;

// Self written code. This program returns all permutations of a given string.

public class printPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your string : ");
        String ques = sc.next();
        System.out.println("Your final result is : ");
        pp(ques, "");
    }

    public static void pp(String ques, String ans) {
        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < ques.length(); i++) {
            String rques=ques.substring(0,i)+ques.substring(i+1); // gives the string excluding ch.
            char ch = ques.charAt(i);
            pp(rques, ans + ch);
        }
    }
}
