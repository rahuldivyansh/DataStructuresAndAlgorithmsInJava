import java.util.*;

// This returns all the possible alphabetic words using the numbers given as input by the user.
public class keypadCombination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your number : ");
        String str = sc.next();

        ArrayList<String> res = kc(str);
        System.out.println("The final result is : " + res);

    }

    static String[] codes = { ",;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static ArrayList<String> kc(String str) {
        if(str.length()==0){
            ArrayList <String> r = new ArrayList<>();
            r.add("");
            return r;
        }
        char ch = str.charAt(0);
        String s = str.substring(1);
        ArrayList <String> res = kc(s);

        ArrayList <String> fres = new ArrayList<>();
        String code = codes[ch - '0']; // This gives the index on keypad according to number in char ch.
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            for(String s1: res ){
                fres.add(c+s1);
            }
        }
        return fres;
    }
}
