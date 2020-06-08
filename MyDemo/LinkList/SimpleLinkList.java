package MyDemo.LinkList;

class SimpleLinkList {
    private Node head;
    private int size;

    SimpleLinkList() {
        this.head = new Node(0);
        this.size = 0;
    }

    SimpleLinkList(Node head,int size) {
        this.head = head;
        this.size = size;
    }

    public int size () {
        return this.size;
    }

    private void checkBounds(int pos) {
        if(!(pos <= this.size && pos >= 0)){
             throw new IndexOutOfBoundsException(pos + "");
        }
    }

    //positin start from index 0
    public void insertNode(int value, int pos){
        Node newNode = new Node(value);
        this.checkBounds(pos);
        Node cur = this.head;
        for(int i = 0; i < pos; i++){
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        this.size = this.size + 1;
    }

    public void deleteNode(int pos) {
        Node pre = this.head;
        this.checkBounds(pos);
        for(int i = 0 ; i < pos ; i++){
            pre = pre.next;
        }
        Node cur = pre.next;  
        pre.next = cur.next;
        this.size--;
    }

    public void insertNode(int value){
        this.insertNode(value, this.size);
    }

    public String toString(){
        if(size == 0){
            return "";
        } 
        StringBuilder strBuilder = new StringBuilder();
        Node cur = this.head.next;
        while(cur != null){
            strBuilder.append(cur.value).append("->");
            cur = cur.next;
        }
        return strBuilder.replace(strBuilder.length() - 2, strBuilder.length(), "").toString();
    }

    public static SimpleLinkList merge(SimpleLinkList list1, SimpleLinkList list2){
        Node cur1 = list1.head.next;
        Node cur2 = list2.head.next;

        int size = listA.size() + listB.size();

        Node head = new Node();
        Node cur = head;
        while(cur1 != null && cur2 != null){
            if(cur1.value < cur2.value){
                cur.next = cur1;
                cur1 = cur1.next;
                } else {
                cur.next = cur2;
                cur2 = cur2.next;
            } 
            cur = cur.next;
        }
        if(cur1 == null) {
            // list 1 merge complete
            cur.next = cur2;
        } else {
            cur.next = cur1;
        }

        return new SimpleLinkList(head, size);
    }

    
    public static void main(String[] args) {
        SimpleLinkList linkList = new SimpleLinkList();
        linkList.insertNode(1);
        linkList.insertNode(2);
        linkList.insertNode(3);
        linkList.insertNode(4);
        linkList.insertNode(5);
        System.out.println(linkList.toString());
        linkList.deleteNode(4);
        System.out.println(linkList.toString());
        linkList.deleteNode(2);
        System.out.println(linkList.toString());
        linkList.deleteNode(0);
        System.out.println(linkList.toString());

        SimpleLinkList list1 = new SimpleLinkList();
        SimpleLinkList list2 = new SimpleLinkList();

        for (int i = 10; i >= 2; i -= 2) {
            list1.insertNode(i);
            list2.insertNode(i - 1);
        }
        assert list1.toString().equals("2->4->6->8->10");
        assert list2.toString().equals("1->3->5->7->9");
        assert SimpleLinkList.merge(list1, list2).toString().equals("1->2->3->4->5->6->7->8->9->10");
    }
}

class Node {
    public int value;
    public Node next;

    Node() {
        this.value = 0;
        this.next = null;
    }

    Node(int value) {
        this.value = value;
        this.next = null;
    }

    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
   
}
