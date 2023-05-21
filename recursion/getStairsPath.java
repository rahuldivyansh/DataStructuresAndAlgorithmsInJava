import java.util.ArrayList;
import java.util.Scanner;

// This program takes no of stairs as an input and returns the total number of possible paths from stair n to stair 0.
public class getStairsPath{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of stairs: ");
        int num = sc.nextInt();
        ArrayList<String> myres = gsp(num);
        System.out.println("The final result is : "+myres);
    }
    static ArrayList<String> gsp(int num){
        if(num==0){
            ArrayList<String> r = new ArrayList<>();
            r.add("");
            return r;
        } else if(num<0){
            ArrayList<String> r = new ArrayList<>();
            return r;
        }

        ArrayList<String> res1 = gsp(num-1);
        ArrayList<String> res2 = gsp(num-2);
        ArrayList<String> res3 = gsp(num-3);
        ArrayList<String> fres = new ArrayList<>();
        
        for(String str: res1){
            fres.add("1"+str);
        }

        for(String str: res2){
            fres.add("2"+str);
        }
  
        for(String str: res3){
            fres.add("3"+str);
        }

        return fres;
    }
}