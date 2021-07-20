/**
 * Represents a Node of a singly linked list
 *
 * @author Bhavyai Gupta
 */
public class Node {
    public String data;
    public Node next;

    /**
     * Creates a new node with String <code>d</code>
     *
     * @param d String to be stored in the Node
     */
    public Node(String d) {
        this.data = d;
        this.next = null;
    }
}
