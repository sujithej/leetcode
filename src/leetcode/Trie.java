import java.util.HashMap;

class TrieNode {
    // Initialize your data structure here.
    HashMap<Character, TrieNode> hash = new HashMap<Character, TrieNode>();
    private char val;

    public TrieNode() {

    }

    public TrieNode(char val) {
        this.val = val;
    }

    public void insertChild(char val) {
        TrieNode temp = hash.get(val);
        if(temp == null)
            hash.put(val, (new TrieNode(val)));
    }


    public TrieNode getChild(char val) {
        return hash.get(val);

    }

    public boolean emptyChildren() {
        return hash.isEmpty();
    }
}

public class Trie {
    public static void main(String []args)
    {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        System.out.println(trie.search("app"));
        System.out.println("hold");

    }


    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        char[] charArray = word.toCharArray();
        TrieNode temp = root;
        for (char c : charArray) {
            temp.insertChild(c);
            temp = temp.getChild(c);
        }
        temp.insertChild(';');
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        word = word + ";";
        return startsWith(word);

    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        char[] charArray = prefix.toCharArray();
        TrieNode temp = root;
        for (char c : charArray) {
            temp = temp.getChild(c);
            if (temp == null)
                return false;
        }
        return true;

    }


}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");