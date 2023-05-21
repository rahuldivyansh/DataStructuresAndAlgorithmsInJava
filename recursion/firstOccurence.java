import java.util.Arrays;
import java.util.Scanner;

public class firstOccurence {
    static int value,idx;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int []a = {1,2,3,1,5,7,2,8,3};
        System.out.println("Your Arrays is : "+Arrays.toString(a));
        value = sc.nextInt();
        System.out.println(first (a,value,9)); 
    }
    static int first(int []a, int value,int n){
        if(n==0)
        return 0;
        
        if(a[n-1]==value)
        idx = n-1;
        first(a, value, n-1);

        return idx;
    }
}
