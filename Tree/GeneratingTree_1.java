// In this program we generate a tree from given array and we use stack in the process.
import java.util.*;

class Node{
   int data;
   ArrayList <Node> children = new ArrayList<>();

   Node(){

   } 
   Node(int data){
    this.data = data;
   }
}
public class GeneratingTree_1{
    

    public static void main(String[] args) {
        int [] arr = {1,2,4,-1,5,-1,-1,3,6,-1,7,-1,-1};

        Node root = new Node();
        Stack <Node> st = new Stack<>();

        for(int i = 0; i<arr.length; i++){
            if(arr[i] == -1){
                st.pop();
            } else{
                Node t = new Node();
                t.data = arr[i];

                if(st.size() > 0){
                    st.peek().children.add(t);
                } else{
                    root = t;
                }

                st.push(t);
            }
        }

        operations obj = new operations();
        // obj.displayStyle_1(root);
        // System.out.println();
        // obj.displayStyle_2(root);

        // System.out.println("The number of nodes in the tree is : "+obj.size(root));
        // System.out.println("The maximum element in the tree is : "+obj.max(root));
        // System.out.println("The height in the tree is : "+obj.height(root));
        // System.out.print("The level order traversal of tree gives us : ");
        // obj.levelOrder(root);
        // System.out.println();
        // System.out.println("The level order linewise traversal of tree gives us : ");
        obj.levelOrderLinewise(root);
        // System.out.println("The level order linewise traversal of tree using method 2 gives us : ");
        // obj.levelOrderLinewise2(root);
        // System.out.println();
        // System.out.println("The level order linewise zig-zag traversal of tree gives us : ");
        // obj.levelOrderLinewiseZZ(root);

        // System.out.println("tree after removing its leaves");
        // obj.removeLeaves(root);
        // obj.levelOrderLinewise2(root);

        // System.out.println("\nTree after linearizing :");
        // obj.levelOrderLinewise(obj.linearize2(root));

        // obj.show();
        // obj.multisolver(root, 0);
        // obj.show();

        obj.MSST(root);
        obj.resultMSST();
    }
}


class operations{
    public void displayStyle_1(Node t){
        if(t.children.size() == 0)
        {
            System.out.print(t.data+ " ");
            return;
        }

        System.out.print(t.data+ " ");
        for(int i = 0; i<t.children.size(); i++){
            displayStyle_1(t.children.get(i));
        }

        return;
    }

    public void displayStyle_2(Node t){
        String str = t.data + "-> ";
        for(Node child : t.children){
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for(Node child: t.children){
            displayStyle_2(child);
        }
    }

    public int size(Node node){
        int s = 0;

        for(Node child: node.children){
            int childSize = size(child);
            s = s + childSize;
        }
        s = s+1;

        return s;
    }

    public int max(Node node){
        int max = node.data;

        for(int i = 0; i<node.children.size(); i++){
            int big = max(node.children.get(i));
            if(big > max)
                max = big;
        }

        return max;
    }

    public int height(Node node){
        int height = -1;

        for(Node child: node.children){
            int childHeight = height(child);
            if(childHeight > height){
                height = childHeight;
            }
        }
        height = height + 1;

        return height;
    }

    public void levelOrder(Node node){
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);

        while(q.size() > 0){
            node = q.remove();
            System.out.print(node.data + " ");

            for(Node child: node.children){
                q.add(child);
            }
        }

        System.out.print(".");
    }

    public void levelOrderLinewise2(Node node){             //More efficient approach with using on one queue.
           Queue<Node> mq = new ArrayDeque<>();
           mq.add(node);
           mq.add(new Node(-1));

           while(mq.size() > 0){
                node = mq.remove();

                if(node.data != -1){
                    System.out.print(node.data + " ");
    
                    for(Node child: node.children){
                        mq.add(child);
                    }
                } else{
                    if(mq.size()>0){
                        mq.add(new Node(-1));
                        System.out.println();
                    }
                }   
           }
        }

    public void levelOrderLinewise(Node node){
           Queue<Node> mq = new ArrayDeque<>();
           mq.add(node);
           
           Queue<Node> cq = new ArrayDeque<>();

           while(mq.size() > 0){
                node = mq.remove();
                System.out.print(node.data + " ");

                for(Node child: node.children){
                    cq.add(child);
                }

                if(mq.size() == 0)
                {
                    mq = cq;
                    cq = new ArrayDeque<>();
                    System.out.println();
                }
           }
       
       
        // Queue<Node> q = new ArrayDeque<>();
        // q.add(node);
        // System.out.println(node.data);
        // int count = 1, n;

        // while(q.size() > 0){
        //     n = count;
        //     count = 0;

        //     for(int i = 1; i <= n; i++){
        //         node = q.remove();

        //         for(Node child: node.children){
        //             q.add(child);
        //             System.out.print(child.data + " ");
        //             count++;
        //         }
        //     }
        //     System.out.println();
        // }
    }

    public void levelOrderLinewiseZZ(Node node){    // Print levelOrderLinewise in zig zag manner.
        Stack <Node> ms = new Stack<>();
        ms.push(node);

        Stack <Node> cs = new Stack<>();
        int level = 0;

        while(ms.size() > 0){
            node = ms.pop();
            System.out.print(node.data + " ");

            if(level % 2 == 1){
                for(int i = 0; i < node.children.size(); i++){
                    Node child = node.children.get(i);
                    cs.push(child);
                }
            } else{
                for(int i = node.children.size() - 1; i >= 0 ; i--){
                    Node child = node.children.get(i);
                    cs.push(child);
                }
            }

            if(ms.size() == 0){
                ms = cs;
                cs = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }

    public void removeLeaves(Node node){
        
        for(int i = node.children.size() - 1; i >= 0 ; i--){
            Node child = node.children.get(i);

            if(child.children.size() == 0){
                node.children.remove(child);
            }
        }

        for(Node child: node.children){
            removeLeaves(child);
        }

    }


    public void linearize(Node node){
        for(Node child: node.children){
            linearize(child);
        }

        while(node.children.size() > 1){
            Node lc = node.children.remove(node.children.size() - 1);       // Last child of root
            Node sc = node.children.get(node.children.size() -1);           // Second last child of root
            Node slt = getTail(sc);                                         // Second last child's tail

            slt.children.add(lc);                       // Add last child to children of second last's tail.
        }
    }

    public Node getTail(Node node){
        while(node.children.size() == 1){
            node = node.children.get(0);
        }
        return node;
    }

    public Node linearize2(Node node){
        if(node.children.size() == 0){                  // Base case
            return node;
        }

        Node lkt = linearize2(node.children.remove(node.children.size()-1));        // Last child gets linearized.
        while(node.children.size() > 1){
            Node last = node.children.remove(node.children.size() - 1);
            Node sl = node.children.get(node.children.size() -1 );      // Second last child
            Node slkt =  linearize2(sl);                                // Second last ka tail
            slkt.children.add(last);
        }
        return lkt;
    }

    int size = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, height = 0;
    public void multisolver(Node node, int depth){
        size++;
        min = Math.min(min, node.data); 
        max = Math.max(max, node.data); 
        height = Math.max(height, depth);

        for(Node child: node.children)
            multisolver(child, depth+1);
        
    }
    public void show(){
        System.out.println("\n"+size+" "+min+" "+max+" "+height);
    }


    //function to find the node with maximum subtree sum.
     int msn = 0;
     int ms = Integer.MIN_VALUE;
    public int MSST(Node node){
        int sum = node.data;

        for(Node child: node.children){
            int csum = MSST(child);
            sum+= csum;
        }
        if(sum > ms){
            ms = sum;
            msn = node.data;
        }

        return sum;
    }
    public void resultMSST(){
        System.out.println("Node with maximum sum subtree is : "+msn);
    }
}