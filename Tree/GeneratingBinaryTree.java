import java.util.*;

public class GeneratingBinaryTree {
    public static void main(String[] args) {
        Integer arr[] = {50, 25, 12, null, null, 87, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        

        functions obj = new functions();
        Node root = obj.createTree(arr);
        obj.display_1(root);
        obj.pathToLeafFromRoot(root, "", 0, 5, 250);
    }
}

class Pair{
    Node node;
    int state;
    Pair(Node node, int state){
        this.node = node;
        this.state = state;
    }
}
class Node{
    int data;
    Node left;
    Node right;
    Node(int data, Node left, Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class functions{
    public Node createTree(Integer arr[]){
        Node root = new Node(arr[0], null, null);   // Creating root node
        Pair rootPair = new Pair(root, 1);              // we Create new pair to insert it in stack, and we keep its state 1 as it is in preorder.
        
        Stack<Pair> st = new Stack<>();
        st.push(rootPair);  // We pushed the root in the stack first.

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();           // we get the node at the top of stack
            if(top.state == 1){
                idx++;
                if(arr[idx] != null){               // if the arr[idx] is not null that means we have to create left child of node on top of stack 
                    top.node.left = new Node(arr[idx], null, null);   // We create the left child  
                    Pair leftPair = new Pair(top.node.left, 1);            // We create the leftpair and set its state = 1 as it has just been created
                    st.push(leftPair);                                           // Then we push the node into the stack along with its state (collectively pair)
                } else{
                    top.node.left = null;   // If the arr[idx] is null then it means that there are no left child to be added to that node so we set it as null.
                }

                top.state++;    // As the previous top has now a left child so we increase its state to add right child the next time. 
            }

            else if(top.state == 2){    // A condition where top's right child need to inserted (if exists) because it already has a left child or its left child is null
                idx++;      // increase this to get the next element in array to create a node 

                if(arr[idx] != null){
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rightPair = new Pair(top.node.right, 1);
                    st.push(rightPair);
                } else{
                    top.node.right = null;
                }

                top.state++;
            }

            else{
                st.pop();       // if the state is = 3, it indicates that we have inserted left and rigth child of top node and now we need to remove that node to go we in the tree 
            }
        }

        return root;
    }

    public void display_1(Node node){
        if(node == null){
            return;
        }

        String str = "";
        
        str += node.left == null ? ". " : node.left.data + " ";
        str += " <- " +  node.data + " -> ";
        str += node.right == null ? ". " : node.right.data + "";
        System.out.println(str);

        display_1(node.left);
        display_1(node.right);
        
    }

    public void pathToLeafFromRoot(Node node, String path, int sum, int low, int high){
        if(node == null)
            return;

        if(node.left == null && node.right == null){
            sum += node.data;
            if(sum >= low && sum <= high){
                System.out.println(path + node.data);
            }
            return;
        }

        pathToLeafFromRoot(node.left, path + node.data + " ", sum + node.data, low, high);
        pathToLeafFromRoot(node.right, path + node.data + " ", sum + node.data, low, high);
    }
}
