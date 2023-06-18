import java.util.ArrayList;

class DisjointSet {

    ArrayList<Integer> rank = new ArrayList<>();    // used in union by rank
    ArrayList<Integer> size = new ArrayList<>();    // used in union by size
    ArrayList<Integer> parent = new ArrayList<>();  // common in both

    DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int u) {
        if (parent.get(u) == u) {
            return u;
        }

        int ultimateParent = findParent(parent.get(u));
        parent.set(u, ultimateParent);
        return parent.get(u);
    }

    public void unionByRank(int u, int v) {
        int ulp_U = findParent(u);
        int ulp_V = findParent(v);

        // u and v are already part of the same component, so no union needed.
        if (ulp_U == ulp_V)
            return;

        int rankU = rank.get(ulp_U);
        int rankV = rank.get(ulp_V);
        if (rankU > rankV) {
            parent.set(ulp_V, ulp_U);
        } else if (rankU < rankV) {
            parent.set(ulp_U, ulp_V);
        } else {
            parent.set(ulp_U, ulp_V);
            rank.set(ulp_V, rankV+1);
        }
    }

    public void unionBySize(int u, int v){
        int ulp_U = findParent(u);
        int ulp_V = findParent(v);

        // u and v are already part of the same component, so no union needed.
        if (ulp_U == ulp_V)
            return;

        int sizeU = size.get(ulp_U);
        int sizeV = size.get(ulp_V);
        if (sizeU > sizeV) {
            parent.set(ulp_V, ulp_U);
            size.set(ulp_U, sizeV+sizeU);
        } else {
            parent.set(ulp_U, ulp_V);
            size.set(ulp_V, sizeV+sizeU);
        } 
    }
}

public class Main {
    public static void main(String[] args) {

        // Create a Disjoint Set.
        DisjointSet ds = new DisjointSet(7);

        Using_union_by_rank:{
            ds.unionByRank(1, 2);
            ds.unionByRank(2, 3);
            ds.unionByRank(4, 5);
            ds.unionByRank(6, 7);
            ds.unionByRank(5, 6);
    
            if(ds.findParent(3) == ds.findParent(7))    System.out.println("Same");
            else    System.out.println("Different");
    
            ds.unionByRank(3, 7);
    
            if(ds.findParent(3) == ds.findParent(7))    System.out.println("Same");
            else    System.out.println("Different");
        }

        // Using union by rank
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        if(ds.findParent(3) == ds.findParent(7))    System.out.println("Same");
        else    System.out.println("Different");

        ds.unionBySize(3, 7);

        if(ds.findParent(3) == ds.findParent(7))    System.out.println("Same");
        else    System.out.println("Different");
    }
}