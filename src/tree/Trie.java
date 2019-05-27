package tree;

/**
 * Created by xsg on 2019/5/27.
 */
public class Trie {

    private TrieNode root = new TrieNode('/');

    /**
     * 往trie树中插入数据
     * @param text
     */
    public void insert(char[] text) {
        TrieNode p = this.root;
        for(int i = 0; i < text.length; i++) {
            int index = text[i] - 'a';
            if(p.children[index] == null) {
                TrieNode newTrieNode = new TrieNode(text[i]);
                p.children[index] = newTrieNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    /**
     * 在tire树中查找数据
     * @param text
     * @return
     */
    public boolean find(char[] text) {
        TrieNode p = this.root;
        for(int i = 0; i < text.length; i++) {
            int index = text[i] - 'a';
            if(p.children == null) {
                return false;
            }
            p = p.children[index];
        }
        if(!p.isEndingChar) return false;
        else return true;
    }

    public class TrieNode {
        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;

        public TrieNode(char data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc".toCharArray());
        System.out.println(trie.find("ab".toCharArray()));
        System.out.println(trie.find("abc".toCharArray()));
    }
}
