import java.util.*;
public class pdi{
    public static void main(String[] args) {
        pdi(5);
    }

    static void pdi(int n){

        if(n==0)
        return;

        System.out.println(n);
        pdi(n-1);
        System.out.println(n);
    }
}