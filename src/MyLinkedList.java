public class MyLinkedList<T> {

    private Node first = null;
    private Node last = null;
    private int size = 0;

    class Node{

        T item;
        Node next;
        Node previous;

        Node(T item){
            this.item = item;
        }
    }


    public void add(T item){
        Node newNode = new Node(item);
        if(first == null){
            newNode.next = null;
            newNode.previous = null;
            first = newNode;
            last = newNode;
        }else {
            newNode.previous = last;
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public void add(int index, T item){

        Node newNode = new Node(item);

        if(index < size && index > 0){

            if(index == 0)
                add(item);

            if(index == size){
                last.next = newNode;
                last = newNode;
            }

            Node current = first;
            for(int i = 0; i < index; i++)
                current = current.next;

            Node oldPrevious = current.previous;
            oldPrevious.next = newNode;
            current.previous = newNode;

            newNode.previous = oldPrevious;
            newNode.next = current;

            size++;
        }
    }

    public void clear(){
        first = null;
        last = null;
        size = 0;
    }

    public T get(int index){
        Node currentNode = first;

        if(index > 0 && index < size){
            for(int i = 0; i < index; i++)
                currentNode = currentNode.next;
        }
        return currentNode.item;
    }

    public void remove(int index){
        if(index > 0 && index < size){

            Node currentNode = first;

            for(int i = 0; i < index - 1; i++)
                currentNode = currentNode.next;

            currentNode.next = currentNode.next.next;
            currentNode.next.previous = currentNode;

        }
    }

    public void set(int index, T item){
        if(index < size && index > 0){

            Node currentNode = first;

            for(int i = 0; i < index; i++)
                currentNode = currentNode.next;
            currentNode.item = item;
        }
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "first=" + first +
                ", last=" + last +
                ", size=" + size +
                '}';
    }

    public void print(){
        Node current = first;
        String result = "";

        while(current != null){
            result += (String)current.item;
            result += " ";
            current = current.next;
        }

        System.out.println(result);
    }

    public static void main(String []args){
        MyLinkedList<String> list = new MyLinkedList<>();

        list.add("Hello");
        list.add("It's");
        list.add("my");
        list.add("LinkedList");

        list.print();

        list.add(3, "Test");

        list.print();

        list.set(3, "Error");
        list.print();

        System.out.println(list.get(1));

        list.remove(3);
        list.print();

        list.clear();
        System.out.println(list);
    }
}
