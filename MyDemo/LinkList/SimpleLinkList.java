package MyDemo.LinkList;

class SimpleLinkList {
    private Node head;
    private int size;

    SimpleLinkList() {
        this.head = new Node(0);
        this.size = 0;
    }

    public int size () {
        return this.size;
    }
    //positin start from index 0
    public void insertNode(int value, int pos){
        Node newNode = new Node(value);
        if(pos <= this.size && pos >= 0){
            Node cur = this.head;
            for(int i = 0; i < pos; i++){
                cur = cur.next;
            }
            newNode.next = cur.next;
            cur.next = newNode;
            this.size = this.size + 1;
        } else {
            throw new IndexOutOfBoundsException(pos + "");
        }
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

    
    public static void main(String[] args) {
        SimpleLinkList linkList = new SimpleLinkList();
        linkList.insertNode(1);
        linkList.insertNode(2);
        linkList.insertNode(3);

        System.out.println(linkList.toString());
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
