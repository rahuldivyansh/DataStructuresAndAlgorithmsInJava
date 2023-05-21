//{ Driver Code Starts
    import java.util.*;

    class Node
    {
        int data;
        Node next;
        
        Node(int key)
        {
            data = key;
            next = null;
        }
    }
    
    
    class mergeKSortedLists
    {
        public static void printList(Node node)
        {
            while(node != null)
            {
                System.out.print(node.data + " ");
                node = node.next;
            }
        }
        
        public static void main (String[] args) {
            Scanner sc = new Scanner(System.in);
            
            int t = sc.nextInt();
            while(t-- > 0)
            {   
                int N = sc.nextInt();
                
                Node []a = new Node[N];
                
                for(int i = 0; i < N; i++)
                {
                    int n = sc.nextInt();
                    
                    Node head = new Node(sc.nextInt());
                    Node tail = head;
                    
                    for(int j=0; j<n-1; j++)
                    {
                        tail.next = new Node(sc.nextInt());
                        tail = tail.next;
                    }
                    
                    a[i] = head;
                }
                
                Solution g = new Solution();
                 
                Node res = g.mergeKList(a,N);
                if(res!=null)
                    printList(res);
                System.out.println();
            }
        }
    }
    // } Driver Code Ends
    
    
    /*class Node
    {
        int data;
        Node next;
        
        Node(int key)
        {
            data = key;
            next = null;
        }
    }
    */
    
    // a is an array of Nodes of the heads of linked lists
    // and N is size of array a
    
    
    class Solution
    {
        //Function to merge K sorted linked list.
        Node mergeKList(Node[]arr,int K)
        {
            if(K==1){
                return arr[0];
            }
            Node merged = new Node(0);
            Node head = merged;
            for(int i =0;i<K;i+=2){
                Node one = arr[i];
                Node two = new Node(0);
                if(i+1 == K){
                    two = head;
                }  else{
                two = arr[i+1];
                } 
                    
                while(one!=null && two!=null){
                    if(one.data < two.data){
                        Node temp = new Node(one.data);
                        merged.next = temp;
                        merged = temp;
                        
                        one = one.next;
                    } 
                    else
                    {
                        Node temp = new Node(two.data);
                        merged.next = temp;
                        merged = temp;
                        
                        two = two.next;
                    }
                }
                while(one != null){
                    Node temp = new Node(one.data);
                    merged.next =temp;
                    merged = temp;
                    one = one.next;
                }
                
                while(two != null){
                    Node temp = new Node(two.data);
                    merged.next =temp;
                    merged = temp;
                    two = two.next;
                }
            
            }
            
            head = head.next;
            return head;
        }
    }
    