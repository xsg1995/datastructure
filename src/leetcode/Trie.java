package leetcode;

/**
 * 实现 Trie (前缀树)(https://leetcode-cn.com/problems/implement-trie-prefix-tree/)
 */
public class Trie {

    private TrieNode head;

    /** Initialize your data structure here. */
    public Trie() {
        this.head = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        TrieNode node = this.head;
        for (char c : word.toCharArray()) {
            if (!node.contains(c)) {
                node.set(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setIsEnd(true);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = this.searchNode(word);
        return node != null && node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = this.searchNode(prefix);
        return node != null;
    }

    private TrieNode searchNode(String word) {
        if (word == null || word.length() == 0) return null;
        TrieNode node = this.head;
        for (char c : word.toCharArray()) {
            node = node.get(c);
            if (node == null) return null;
        }
        return node;
    }

    private static class TrieNode {
        private TrieNode[] childern = new TrieNode[26];
        private boolean isEnd;

        public boolean contains(char c) {
            return childern[c - 'a'] != null;
        }

        public void set(char c, TrieNode node) {
            this.childern[c - 'a'] = node;
        }

        public TrieNode get(char c) {
            return this.childern[c - 'a'];
        }

        public boolean isEnd() {
            return this.isEnd;
        }

        public void setIsEnd(boolean isEnd) {
            this.isEnd = isEnd;
        }
    }
}
