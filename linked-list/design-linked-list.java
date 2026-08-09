class MyLinkedList {
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
            this.next = null;
        }
    }
    private Node head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }
    
    public int get(int index) {
        if(index < 0 || index >=  size){
            return -1;
        }
        Node current = head;
        for(int i =0; i<index; i++){
            current = current.next;
        }
        return current.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            size++;
            return;
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
        size++;
    }
    
    public void addAtIndex(int index, int val) {

        // If index is greater than size, don't insert
        if (index > size) {
            return;
        }

        // Add at beginning
        if (index == 0) {
            addAtHead(val);
            return;
        }

        Node newNode = new Node(val);

        Node current = head;

        // Move to node just before index
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        // Insert new node
        newNode.next = current.next;
        current.next = newNode;

        size++;
    }


    
    public void deleteAtIndex(int index) {

        // Invalid index
        if (index < 0 || index >= size) {
            return;
        }

        // Delete head
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }

        Node current = head;

        // Move to node before the node to delete
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        // Skip the node
        current.next = current.next.next;

        size--;
    }

}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */