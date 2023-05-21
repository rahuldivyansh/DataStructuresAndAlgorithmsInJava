public class fact {
    public static void main(String[] args) {
        
        System.out.println(fact(5));
    }

    static int fact(int n){

        int fac;
        if(n==0)
        return 1;


        fac = n* fact(n-1);
        return fac;
    }
}
