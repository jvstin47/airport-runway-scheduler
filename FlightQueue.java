// Module: Data Structures & Core Algorithms (Elna Elizabeth Abraham)
// Very Basic Singly Linked-List Queue (No loops, pure pointer manipulation)

public class FlightQueue {
    Node front = null;
    Node rear = null;

    // Check if queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Enqueue: 
    // - Normal flight: Insert at End / Tail (FIFO)
    // - Emergency flight: Insert at Beginning / Head (Instant Priority)
    public void enqueue(Aircraft a) {
        Node newNode = new Node(a);

        if (isEmpty()) {
            front = rear = newNode;
        } else if (a.isEmergency) {
            // Insert at Head (Emergency jump)
            newNode.next = front;
            front = newNode;
        } else {
            // Insert at Tail (Standard FIFO)
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Dequeue: Delete from Head (FIFO removal)
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

    // Returns simple string for the UI text area
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
