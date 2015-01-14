package su.dataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akshat on 12/14/2014.
 */
public class TrieNode<T> {

    private char letter;
    private boolean word = false;
    private List<TrieNode> children = new ArrayList<>();
    private List<T> documents = new ArrayList<>();

    public TrieNode(char curr) {
        this.letter = curr;
    }

    public int insert(String word, T doc) {
        char curr = word.charAt(0);
        TrieNode parentNode = searchNode(curr);
        parentNode = parentNode == null ? this : parentNode;
        TrieNode childNode = parentNode;

        if (curr != parentNode.getLetter()) {
            childNode = parentNode.addChild(curr);
        }

        String next = word.substring(1);

        if (next.isEmpty()) {
            if (childNode != null) {
                childNode.setWord(true);
                childNode.getDocuments().add(doc);
            }
            return 1;
        }

        childNode.insert(next, doc);

        return -1;
    }

    private TrieNode addChild(char curr)
    {
        TrieNode node = new TrieNode(curr);
        this.getChildren().add(node);
        return node;

    }

    private TrieNode searchNode(char curr)
    {
        for (TrieNode node : this.getChildren())
        {
            if (curr == node.getLetter())
            {
                return node;
            }
        }
        return null;
    }

    public List<T> searchDocuments(String word)
    {
        if(word.isEmpty())
            return this.getDocuments();

        TrieNode trieNode = searchNode(word.charAt(0));

        if(trieNode !=null){
           return trieNode.searchDocuments(word.substring(1));
        }

        return null;
    }

    public List<TrieNode> getChildren() {
        return children;
    }

    public char getLetter() {
        return letter;
    }

    public void setWord(boolean word) {
        this.word = word;
    }

    public boolean isWord() {
        return word;
    }

    public List<T> getDocuments() {
        return documents;
    }
}
