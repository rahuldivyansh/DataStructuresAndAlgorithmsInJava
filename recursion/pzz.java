public class pzz {
    public static void main(String[] args) {
        pzz(2);
    }
    static void pzz(int n){
        if(n==0)
        return;

        System.out.println("Pre "+n);
        pzz(n-1);
        System.out.println("In "+n);
        pzz(n-1);
        System.out.println("Post "+n);
    }
}
