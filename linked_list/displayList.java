import java.util.*;

import javax.xml.validation.Validator;

class node{
    int data;
    node next;
}
class linkedList{
    node head;
    node tail;
    int size;
}


public class displayList {
    public static void main(String[] args) {
        
    }

    public static void insert(int val){
        node temp = new node();

        temp.data = val;
        temp.next = null;
        size++;
    }
}
