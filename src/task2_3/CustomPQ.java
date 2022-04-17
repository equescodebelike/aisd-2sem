package task2_3;

public class CustomPQ { // приоритетная очередь на основе связного списка

    protected static class Node {
        String data;
        // приоритет (порядок) в очереди
        int priority;
        Node next;
    }

    protected static int size;
    // protected static Node node = new Node();

    public static Node newNode(String d, int p) {
        Node temp = new Node();
        temp.data = d;
        temp.priority = p;
        temp.next = null;
        size++;

        return temp;
    }

    public static String peek(Node head) {
        return head.data;
    }

    // удаляет элемент с самым высоким приоритетом => первый в очереди
    public static Node pop(Node head) {
        size--;
        head = head.next;
        return head;
    }

    // добавление по приоритету
    public static Node push(Node head, String d, int p) {
        Node start = head;

        Node temp = newNode(d, p);

        // смена head, если приоритет нового больше, чем принятый
        if (head.priority > p) {
            temp.next = head;
            head = temp;
        } else {
            while (start.next != null && start.next.priority < p) {
                start = start.next;
            }

            temp.next = start.next;
            start.next = temp;
        }
        return head;
    }

    /* public static int isEmpty(Node head) {
        if ((head) == null) {
            return 1;
        } else {
            return 0;
        }
    } */

    public static int getSize() {
        return size;
    }

   /* private static void emptyError() throws Exception {
        if (size == 0) {
            throw new Exception("List is empty");
        }
    } */

}
