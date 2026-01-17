import java.util.Stack;
import java.util.*;
class Node{
        int data;
        Node next;

        Node(int data,Node next){
            this.data = data;
            this.next = next;
        }

        Node(int data){
            this.data = data;
             this.next = null;
        }
    
   
}
//this class for the doubly linked list 
// class node{
//     int data;
//     node next;
//     node prev;
//     node(int data,node next,node prev){
//         this.data = data;
//         this.next = next;
//         this.prev = prev;  
//     }
//     node(int data ){
//         this.data = data;
//         this.next = null;
//         this.prev = null;
//     }
// }
class SLLSolution {
//function to insert  a new node at the head
    public Node insertAtHead(Node head,int newData){
        Node newNode = new  Node(newData,head);
        return newNode;
    }
    //function to delete the last Node
    public Node deleteLastNode(Node head){
        if(head == null || head.next == null)
        return null;
        Node temp = head;

        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }
    //function to convert the array to SLL
    public Node convertarray2SLL(int[] arr){
        if(arr == null || arr.length == 0){
            return null;
        }
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i =1;i<arr.length;i++){
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }
    //function to print the linkedlist 
    public void printList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    //function to find the length
    public int findLength(Node head){
        if(head == null)
        return 0;
        Node temp = head;
        int count = 0;
        while(temp.next != null){
            temp = temp.next;
            count++;
        }
        return count+1 ;
    }
    //function to search the element in the LL
    public boolean searchElement(Node head,int val){
        if(head == null)
        return false;

        Node temp = head;
        while(temp != null){
            if(temp.data == val)
            return true;
            temp = temp.next;
        }
        return false;
    }
    // function to find the middle of the element ==> brute force 
    public Node findMiddle(Node head){
        if(head  == null)
        return null;
        int count = 0;
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
            count++;
        }
        int mid = count/2+1; // middle nodee
        temp = head;
        while(temp != null){
            mid = mid-1;
            if(mid == 0)
            break;
            temp = temp.next;
        }
        return temp;
    }
    

    // best to find the middle element 
    public Node findMiddl(Node head){
    if(head == null)
        return null;

    Node slow = head;
    Node fast = head;

    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}

public Node reverseByrecurse(Node head){
    if(head == null || head.next == null) return head;
    Node newHead = reverseByrecurse(head.next);
    Node front = head.next;
    front.next = head;
    head.next = null;
    return newHead;
}

// func to detect the loop in the given LL
public boolean detectLoop(Node head){
    Node temp = head;
    HashMap<Node,Integer> nodeMap = new HashMap<>();
    while(temp != null){
        if(nodeMap.containsKey(temp)) return true;

        nodeMap.put(temp,1);
        temp = temp.next;
    }
    return false;
}
//funct to find the starting point of al loop in a LL:
public Node  findFirst(Node head){
    Node temp = head;
    HashMap<Node,Integer> nodeMap = new HashMap<>();
    while(temp != null){
        if(nodeMap.containsKey(temp)) return temp;
         nodeMap.put(temp,1);
         temp = temp.next;
    }
    return null; //O(N)
}
//optimized code
public Node findfirst(Node head){
    Node slow = head;
    Node fast = head;
    while(slow != null){

        slow = slow.next;
        fast = fast.next.next;
        if(slow == fast){
            slow = head; // imp bcz the point need not be the starting point so we st it to the head back
            while(slow != null){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }
    return null;
}
// length of the loop of the linked list
public int findLengthofloop(Node head){
    Node temp = head;
    int timer = 0;
    HashMap<Node,Integer> map = new HashMap<>();
    while(temp != null){
        if(map.containsKey(temp)){
            int loopLength = timer - map.get(temp);

            return loopLength;
        }
        map.put(temp,timer);
        temp = temp.next;  //O(N)
        timer++;
    }
    return 0;
}
// optimized 
 public int findLoopLength(Node head){
    Node slow = head;
    Node fast = head;
    while(fast !=  null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
        if(slow == fast){
            return countLoopLength(slow);
        }

    }
    return 0;

    
 }
 public int countLoopLength(Node meetingPoint) {
        // Start from meeting point
        Node temp = meetingPoint;
        int length = 1;

        // Move until we meet again
        while (temp.next != meetingPoint) {
            temp = temp.next;
            length++;
        }
        return length;
    }
    // check the palindrome
public boolean checkPalindrome(Node head){
    Stack<Integer> st = new Stack<>();
    Node temp = head;
    while(temp != null){
        st.push(temp.data);
        temp = temp.next;

    }
    temp = head;
    while(temp != null){
        if(temp.data != st.peek())
        return false;

        st.pop();
        temp = temp.next;
    }
    return true;
}
//  optimized code
public boolean checkPalin(Node head){
    if(head == null || head.next == null) return true;
    Node slow = head;
    Node fast = head;
    while(fast != null || fast.next.next != null){
        slow = slow.next;
        fast = fast.next.next;
    }
    Node newHead = reverseByrecurse(slow.next);
    Node first = head;
    Node second = newHead;
    while(second != null){
        if(first.data != second.data){
            reverseByrecurse(newHead);
            return false;

        }
        first = first.next;
        second = second.next;

    }
    reverseByrecurse(newHead);
    return true;
}
//leetcode
public Node segregate(Node head){
    if(head == null || head.next == null) return head;
   Node odd = head;
   Node even = head.next;
   Node evenHead = even ;
   while(even != null && even.next != null){
    odd.next = even.next;
    odd = odd.next;
    even.next = odd.next;
    even = even.next;
     
   }
   odd.next = evenHead;
   return head;

}
}

// class for the functions for the doubly linkedd list
// class DLLSolution{
//     public node insertAtTail(node head,int val){
//         if(head == null)
//         return null;

//         node temp = head;
//         while(temp.next != null){
//             temp = temp.next;
//         }
//         temp.next  = new node(val);
//         return head;
//     }

//     public node convertarr2dll(int[] arr){
//         node head = new node(arr[0]);
//         node prev = head;

//         // traverse the array
//         for(int i=1;i<arr.length;i++){
//             node temp = new node(arr[i],null,prev);
//             prev.next = temp;
//             prev = temp;
//         }
//         return head;


//     }

//     public node deleteLastnode(node head){
//         if(head == null)
//         return null;
//         node temp = head;
//         while(temp.next.next != null){
//             temp = temp.next;
//         }
//         temp.next = null;
//         return head;
//     }


//     public void printlist(node head){
//         node temp = head;
//         while(temp != null){
//             System.out.print(temp.data + " ");
//             temp = temp.next;
//         }
//         System.out.println();
//     }

//     public node reversedll(node head){
//         if (head == null || head.next == null) 
//             return head;
//         Stack<Integer> st = new Stack<>();
//         node temp = head;
//         while(temp != null){
//             st.push(temp.data);
//             temp = temp.next;
//         }
//         temp = head;

//         while(temp != null){
//             temp.data = st.pop();
//             temp = temp.next;
//         }
//         return head;
//     }
//     // best case to reverse the DLL
//     public node reverseDll(node head){
//     if(head == null || head.next == null)
//         return head;

//     node curr = head;
//     node temp = null;

//     while(curr != null){
//         temp = curr.prev;
//         curr.prev = curr.next;
//         curr.next = temp;
//         curr = curr.prev;
//     }
//     return temp.prev;
// }

//}

public class Main{
    
     public static void main(String[] args){
      

        // Node head = new Node(2);
        // head.next = new Node(3);

        // System.out.println("before inserting ");
        // sol.printList(head);
        // head = sol.insertAtHead(head,10);
        //  System.out.println("aftere inserting ");
        // sol.printList(head);
        // sol.deleteLastNode(head);
        // System.out.println("after deleting the last node ");
        // sol.printList(head);
        // System.out.println(sol.findLength(head));
        // System.out.println(sol.searchElement(head,5));


        // int[] arr = {2, 5, 8, 7};
        // node head = new node(arr[0]);
        // System.out.println(head.data);
        // System.out.println(sol.insertAtTail(head,5));
        // sol.printlist(head);
        // head = sol.convertarr2dll(arr);
        // sol.printlist(head);
        // head = sol.deleteLastnode(head);
        // sol.printlist(head);
        // head = sol.reverseDll(head);
        // sol.printlist(head);

        SLLSolution sol = new SLLSolution();
        int[] arr = {1,3,2,1};
        Node head = sol.convertarray2SLL(arr);

        
        Node middleNode = sol.findMiddl(head);
        System.out.println(middleNode.data);
        System.out.println("Hello Mahi");

        // Node rever  = sol.reverseByrecurse(head);
        // sol.printList(rever);

        // System.out.println( sol.detectLoop(head));
        // head = sol.findFirst(head);
        // System.out.println(head);
        // System.out.println(sol.checkPalindrome(head));
        head = sol.segregate(head);
        sol.printList(head);
        






    }
}