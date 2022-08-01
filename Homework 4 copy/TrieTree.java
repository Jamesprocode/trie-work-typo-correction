import java.util.ArrayList;

public class TrieTree {
    // instance valriable
    public TrieNode root;

    // constructor
    public TrieTree() {
        this.root = new TrieNode(' ');
    }

    // methods

    // This method takes a String word as its parameter and inserts the word into
    // this TrieTree.
    // Assume that every word you insert into the TrieTree is a valid word from the
    // dictionary.
    public void insert(String word) {
        if (word.isEmpty()) {
            return;
        }
        this.root = insert(word, this.root);

    }

    private TrieNode insert(String word, TrieNode root) {
        if (word.isEmpty()) {
            root.isEnd = true;
            return this.root;
        } else {
            char c = word.charAt(0);

            if (root.getChild(c) == null) {// if there is no prefix, put it there
                root.childList.add(new TrieNode(c));
            }

            root = root.getChild(c);

            if (word.length() > 1) {
                root = insert(word.substring(1), root);
            } else {
                root.isEnd = true;
                return this.root;

            }

        }
        return this.root;
    }

    // This method takes a String word as its parameter and returns true if this
    // TrieTree contains the word.
    public boolean search(String word) {
        TrieNode current = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.getChild(c) == null) {
                return false;
            }
            current = current.getChild(c);
        }
        if (current.isEnd) {
            return true;
        } else {
            return false;
        }
    }

    // This method takes a String word as its parameter and removes the word from
    // this TrieTree.
    // If we can't find the word in TrieTree, return false. Otherwise, remove the
    // word and return true.
    public boolean remove(String word) {
        TrieNode current = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.getChild(c) == null) {
                return false;
            }
            current = current.getChild(c);
        }
        current.isEnd = false;
        return true;
    }

    // This method takes a String prefix as its parameter and returns a list of
    // valid words from this TrieTree that has the given prefix.
    // Hint: using a recursive helper method may be helpful in this case.
    public ArrayList<String> wordListForPrefix(String prefix) {
        ArrayList<String> words = new ArrayList<>();
        if (prefix == "") {
            return words;
        }
        TrieNode current = this.root;
        if (prefix != " ") {
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (current.getChild(c) == null) {
                    return words;
                }
                current = current.getChild(c);
            }
        }
        // System.out.println(current.data);
        wordListForPrefix(current, prefix.substring(0, prefix.length() - 1), words);
        return words;
    }

    private void wordListForPrefix(TrieNode current, String prefix, ArrayList<String> ans) {
        if (current.data == ' ') {

        }
        if (current.isEnd && current.childList.isEmpty()) {
            ans.add(prefix + current.data);
        } else {
            for (int i = 0; i < current.childList.size(); i++) {
                if (current.isEnd && !ans.contains(prefix + current.data)) {
                    ans.add(prefix + current.data);
                }
                wordListForPrefix(current.childList.get(i), prefix + current.data, ans);
            }
        }
    }
}
