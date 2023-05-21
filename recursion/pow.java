public class pow {
    public static void main(String[] args) {
        System.out.println(pow(2,5));
    }
    static int pow(int x, int n){
        if(n==0)
        return 1;

        int p = x*pow(x,n-1);
        return p;
    }
}
