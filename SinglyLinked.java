import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Insertion {

    private Node head;
    Scanner sc = new Scanner(System.in);

    public void select() {

        int choice;

        do {
            System.out.println("\n1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at position");
            System.out.println("4. Display List");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter data: ");
                    insertAtBegin(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter data: ");
                    insertAtEnd(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();
                    System.out.print("Enter data: ");
                    insertAtPosition(pos, sc.nextInt());
                    break;
                
                case 4:
                    traverse();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }

    public void insertAtBegin(int data) {
        Node nn = new Node(data);
        nn.next = head;
        head = nn;
        System.out.println("Inserted " + data + " at beginning");
    }

    public void insertAtEnd(int data) {
        Node nn = new Node(data);

        if (head == null) {
            head = nn;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = nn;
        }

        System.out.println("Inserted " + data + " at end");
    }

    public void insertAtPosition(int pos, int data) {

        if (pos == 1) {
            insertAtBegin(data);
            return;
        }

        Node nn = new Node(data);
        Node temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position!");
            return;
        }

        nn.next = temp.next;
        temp.next = nn;

        System.out.println("Inserted " + data + " at position " + pos);
    }

    public void traverse() {

    if (head == null) {
        System.out.println("List is empty!");
        return;
    }

    Node temp = head;

    System.out.print("Linked List: ");

    while (temp != null) {
        System.out.print(temp.data + " -> ");
        temp = temp.next;
    }

    System.out.println("null");
}
}

public class SinglyLinked {

    public static void main(String[] args) {
        Insertion obj = new Insertion();
        obj.select();
    }
}