package strengthenVIII;

import java.util.HashMap;
import java.util.Map;

// assume key is String
class TrieNode {

    Character key;
    Map<Character, TrieNode> children = new HashMap<>();
    int count; // how many words are under the subtree
    boolean isWord;

    public TrieNode(char key) {
        this.key = key;
        this.count = 0;
        this.isWord = false;
    }
    public TrieNode(char key, boolean isWord) {
        this.key = key;
        this.count = 0;
        this.isWord = isWord;
    }
}

public class Trie {

    private TrieNode root = new TrieNode((char)0);

    // get the corresponding value for the given target, null if not found
    public boolean search(String target) {
        TrieNode cur = root;
        for (int i = 0; i < target.length(); i++) {
            TrieNode next = cur.children.get(target.charAt(i));
            if (next == null) {
                return false; // not found;
            }
            cur = next;
        }
        return cur.isWord;
    }

    public void insert(String s) {
        TrieNode cur = root;
        for (int i = 0; i < s.length(); i++) {
            TrieNode next = cur.children.get(s.charAt(i));
            if (next == null) {
                next = new TrieNode(s.charAt(i));
                cur.children.put(s.charAt(i), next);
            }
            next.count++;
            cur = next;
        }
        cur.isWord = true;
    }

    public void remove(String s) {
        if (!search(s)) {
            return;
        }
        TrieNode cur = root;
        for (int i = 0; i < s.length(); i++) {
            // next 是 和 s.charAt(i)对应的
            TrieNode next = cur.children.get(s.charAt(i));
            next.count--;
            if (next.count == 0) {
                cur.children.remove(s.charAt(i));
                return;
            } else {
                cur = next;
            }
        }
        cur.isWord = true;
    }
}
