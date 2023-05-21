import java.util.*;

// This program returns all sub-sequences of a string using recursion.
// A subsequence is a sub part of a string where indexes may not be continuous. 
// for eg = string 'abc' subsequence = ac is a subsequence but not a substring.
public class sseq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String str = sc.next();

        ArrayList<String> rs = sseq(str);
        System.out.println("Final result is: "+rs);
    }

    public static ArrayList<String> sseq (String str){
        
        if(str.length()==0)
        {
            ArrayList <String> s = new ArrayList<>();
            s.add("");
            return s;
        }


        char ch = str.charAt(0);
        String s = str.substring(1);
        ArrayList<String> res = sseq(s);
        
        ArrayList<String> fres = new ArrayList<>();
        for(String s1: res){
            fres.add(""+s1);
        }
        for(String s1: res){
            fres.add(ch+s1);
        }

        return fres;
        
    }
}
