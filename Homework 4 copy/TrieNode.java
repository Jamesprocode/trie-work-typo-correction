import java.util.ArrayList;
import java.util.List;

public class TrieNode {
    // instance valuable
    public char data;
    public boolean isEnd;
    public List<TrieNode> childList;

    // constructor
    public TrieNode(char c) {
        this.isEnd = false;
        this.data = c;
        this.childList = new ArrayList<>();
    }

    // This method takes a char value as its parameter,
    // returns the child of this TrieNode that contains the char c as its data.
    // Return null if the list of children is empty or the list of children doesn't
    // contain any TrieNodes with char c as its data.
    public TrieNode getChild(char c) {
        if (this.childList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < this.childList.size(); i++) {
            if (this.childList.get(i).data == c) {
                return this.childList.get(i);
            }
        }
        return null;
    }
}
