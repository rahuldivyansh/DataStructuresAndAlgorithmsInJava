import java.util.ArrayList;
import java.util.Scanner;

public class allOccurences {
    
        static int value;
        static ArrayList <Integer> alist = new ArrayList<Integer>();
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        value = sc.nextInt();
        int a[] = {1,2,3,4,5,1,2,6,7,3};
        System.out.println(all(a, value, 10));

    }
    static ArrayList<Integer> all(int []a, int value, int n){
        

        if(n==0){
            return alist;
        }

        all(a, value, n-1);
        if(a[n-1]==value)
        alist.add(n-1);
        return alist;

    }
}
