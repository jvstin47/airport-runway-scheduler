public class FlightQueue {
    Node front = null;
    Node rear = null;

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(Aircraft a) {
        Node newNode = new Node(a);

        if (isEmpty()) {
            front = rear = newNode;
        } else if (a.isEmergency) {
            newNode.next = front;
            front = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public Aircraft dequeue() {
        if (isEmpty()) {
            return null;
        }
        Aircraft removed = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return removed;
    }

    public String getDisplayList() {
        if (isEmpty()) {
            return " (No flights waiting)\n";
        }
        String list = "";
        Node temp = front;
        int i = 1;
        while (temp != null) {
            list += " " + i + ". " + temp.data.toString() + "\n";
            temp = temp.next;
            i++;
        }
        return list;
    }
}
