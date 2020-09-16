package tree;

/**
 * trie树实现
 * Created by xsg on 2019/5/27.
 */
public class Trie {

    private TrieNode root = new TrieNode('/');

    /**
     * 往trie树中插入数据
     */
    public void insert(char[] text) {
        TrieNode p = this.root;
        for (char c : text) {
            int index = c - 'a';
            if (p.children[index] == null) {
                TrieNode newTrieNode = new TrieNode(c);
                p.children[index] = newTrieNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    /**
     * 在tire树中查找数据
     */
    public boolean find(char[] text) {
        TrieNode p = this.root;
        for (char c : text) {
            int index = c - 'a';
            if (p.children == null) {
                return false;
            }
            p = p.children[index];
        }
        return p.isEndingChar;
    }

    public static class TrieNode {
        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;

        public TrieNode(char data) {
            this.data = data;
        }
    }

}
