package list;

public class Main {

    public static Node<Integer> delNode(Node<Integer> h, int x) {
        Node<Integer> p = new Node<Integer>(-1, h);
        h = p;
        while (p.hasNext()) {
            if (p.getNext().getValue() == x) {
                Node<Integer> t = p.getNext();
                p.setNext(p.getNext().getNext());
                t.setNext(null);
                return h.getNext();
            }
            p = p.getNext();
        }
        return h.getNext();
    }

    public static Node<Integer> build(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Node<Integer> head = new Node<>(arr[0]);
        Node<Integer> current = head;

        for (int i = 1; i < arr.length; i++) {
            Node<Integer> newNode = new Node<>(arr[i]);
            current.setNext(newNode);
            current = newNode;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node<Integer> head = build(arr);
        System.out.println(head);
        head = delNode(head, 3);
        System.out.println(head);
    }
}
