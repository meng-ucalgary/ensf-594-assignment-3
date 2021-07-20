/**
 * A singly linked list
 *
 * @author Bhavyai Gupta
 */
public class LinkedList {
    private Node head;
    private CharCount chars;

    /**
     * Constructs an empty Linked List
     */
    public LinkedList() {
        this.head = null;
        this.chars = null;
    }

    /**
     * Inserts a string at tail of the Linked List if the string is not already
     * present
     *
     * @param s String to be inserted
     */
    private void insert(String s) {
        if (this.head == null) {
            this.head = new Node(s);
        }

        else {
            Node temp = this.head;

            // if string is already present at the head, dont insert
            if(temp.data.equals(s)) {
                return;
            }

            while(temp.next != null) {
                // if string is already present anywhere else, then also dont insert
                if(temp.data.equals(s)) {
                    return;
                }

                temp = temp.next;
            }

            temp.next =  new Node(s);
        }
    }

    /**
     * Checks and inserts a string to the Linked List if the Linked List is empty or
     * if the string is an anagram of the existing strings
     *
     * @param s the string to be inserted
     * @return <code>true</code> if insertion is successful, <code>false</code>
     *         otherwise
     */
    public boolean checkAndInsert(String s) {
        // create CharCount object for the input string s
        CharCount c = new CharCount(s);

        // if this linked list has not been used before, simply insert
        if (this.chars == null) {
            this.insert(s);
            this.chars = c;
            return true;
        }

        // if the input string is an anagram, insert at tail
        else if (this.chars.compare(c) == true) {
            this.insert(s);
            return true;
        }

        // else don't insert and return false
        else {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node temp = this.head;

        while (temp != null) {
            sb.append(temp.data);

            if (temp.next != null) {
                sb.append(" ");
            }

            temp = temp.next;
        }

        return sb.toString();
    }

    /**
     * Prints the Linked List on the stdout
     */
    public void print() {
        Node temp = this.head;

        while (temp != null) {
            System.out.printf("%s ", temp.data);
            temp = temp.next;
        }
    }
}
