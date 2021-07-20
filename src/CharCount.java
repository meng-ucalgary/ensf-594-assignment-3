/**
 * Holds the count of characters of a string in an integer array
 *
 * @author Bhavyai Gupta
 */
public class CharCount {
    // integer array to hold the character count
    private int[] chars;

    /**
     * Creates a CharCount object and break down the String s into integer array
     *
     * @param s String
     */
    public CharCount(String s) {
        this.chars = new int[(int) 'z' + 1];

        for (int i = 0; i < s.length(); i++) {
            this.chars[(int) s.charAt(i)] = this.chars[(int) s.charAt(i)] + 1;
        }
    }

    /**
     * Compare if other CharCount object c is equal to this
     *
     * @param c other CharChount object to be compared
     * @return <code>true</code> if this and c have same letters with same count,
     *         <code>false</code> otherwise
     */
    public boolean compare(CharCount c) {
        // loop to check every alphabetic character in the array chars of this and c
        for (int i = 0; i < this.chars.length; i++) {
            if (this.chars[i] != c.chars[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = (int) 'a'; i < this.chars.length; i++) {
            sb.append(String.format("%c = %d%n", (char) i, this.chars[i]));
        }

        return sb.toString();
    }
}
