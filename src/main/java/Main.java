package List;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        Node<Integer> list = buildListFromArray(array);
        System.out.println("List from array:");
        printList(list);

        System.out.println("\nList in reverse order:");
        reverseList(list);

        Node<Integer> userInputList = buildListFromInput();
        System.out.println("\nUser-input list:");
        printList(userInputList);

        System.out.println("\nEven numbers in the list:");
        printEvenNumbers(userInputList);

        System.out.println("\nEnter a number to check:");
        Scanner scanner = new Scanner(System.in);
        int numberToCheck = scanner.nextInt();
        boolean exists = containsNumber(userInputList, numberToCheck);
        System.out.println("Number " + numberToCheck + " exists in list: " + exists);

        System.out.println("\nEnter a number to delete:");
        int numberToDelete = scanner.nextInt();
        userInputList = deleteFirstAppearance(userInputList, numberToDelete);
        System.out.println("List after deleting " + numberToDelete + ":");
        printList(userInputList);

        System.out.println("\nEnter an index to delete:");
        int indexToDelete = scanner.nextInt();
        userInputList = deleteIndex(userInputList, indexToDelete);
        System.out.println("List after deleting index " + indexToDelete + ":");
        printList(userInputList);
    }

    public static Node<Integer> buildListFromArray(int[] array) {
        if (array.length == 0) return null;
        Node<Integer> head = new Node<>(array[0]);
        Node<Integer> current = head;
        for (int i = 1; i < array.length; i++) {
            current.setNext(new Node<>(array[i]));
            current = current.getNext();
        }
        return head;
    }

    public static void printList(Node<Integer> head) {
        Node<Integer> current = head;
        while (current != null) {
            System.out.print(current.getValue() + " --> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public static void reverseList(Node<Integer> head) {
        if (head == null) return;
        reverseList(head.getNext());
        System.out.println(head.getValue());
    }

    public static Node<Integer> buildListFromInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter positive numbers (end with -1):");
        Node<Integer> dummy = new Node<>(null);
        Node<Integer> current = dummy;

        while (true) {
            int num = scanner.nextInt();
            if (num == -1) break;
            if (num >= 0) {
                current.setNext(new Node<>(num));
                current = current.getNext();
            } else {
                System.out.println("Only positive numbers are allowed. Try again.");
            }
        }

        return dummy.getNext();
    }

    public static void printEvenNumbers(Node<Integer> head) {
        Node<Integer> current = head;
        while (current != null) {
            if (current.getValue() % 2 == 0) {
                System.out.println(current.getValue());
            }
            current = current.getNext();
        }
    }

    public static boolean containsNumber(Node<Integer> head, int number) {
        Node<Integer> current = head;
        while (current != null) {
            if (current.getValue() == number) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public static Node<Integer> deleteFirstAppearance(Node<Integer> head, int number) {
        if (head == null) return null;
        if (head.getValue() == number) return head.getNext();

        Node<Integer> current = head;
        while (current.hasNext() && current.getNext().getValue() != number) {
            current = current.getNext();
        }
        if (current.hasNext()) {
            current.setNext(current.getNext().getNext());
        }
        return head;
    }

    public static Node<Integer> deleteIndex(Node<Integer> head, int index) {
        if (index < 0 || head == null) return head;
        if (index == 0) return head.getNext();

        Node<Integer> current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null || !current.hasNext()) return head;
            current = current.getNext();
        }
        if (current.hasNext()) {
            current.setNext(current.getNext().getNext());
        }
        return head;
    }
}
