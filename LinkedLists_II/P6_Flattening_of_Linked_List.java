package LinkedLists_II;

class Node {
    int data;
    Node next;
    Node bottom;

    Node(int value) {
        data = value;
        next = null;
        bottom = null;
    }
}

class Main {
    public static Node flatten(Node node){
        if(node == null || node.next == null) return node;

        node.next = flatten(node.next);

        node = mergeList(node, node.next);
        return node;
    }

    private static Node mergeList(Node a, Node b){
        Node temp = new Node(0);
        Node result = temp;

        while (a != null && b != null) {
            if(a.data < b.data){
                temp.bottom = a;
                temp = temp.bottom;
                a = a.bottom;
            }else{
                temp.bottom = b;
                temp = temp.bottom;
                b = b.bottom;
            }
        }

        if(a!=null) temp.bottom = a;
        else temp.bottom = b;
        
        return result.bottom;
    }

    public static void main(String[] args) {
        // Example usage
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(19);
        head.next.next.next = new Node(28);

        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);
        head.bottom.bottom.bottom = new Node(30);

        head.next.bottom = new Node(20);

        head.next.next.bottom = new Node(22);
        head.next.next.bottom.bottom = new Node(50);

        head.next.next.next.bottom = new Node(35);
        head.next.next.next.bottom.bottom = new Node(40);
        head.next.next.next.bottom.bottom.bottom = new Node(45);

        // Call the flatten function
        head = flatten(head);

        // Print the flattened linked list
        printList(head);
    }
}
