package su.dataStructure;

import org.junit.Assert;
import org.junit.Test;
import su.problems.Book;

/**
 * Created by Akshat on 1/1/2015.
 */
public class TestTrieNode {

    @Test
    public void testInsert()
    {
        char root = '#';
        TrieNode trieNode = new TrieNode(root);
        trieNode.insert("a", null);
        trieNode.insert("t", null);
        trieNode.insert("an", null);
        trieNode.insert("at", null);
        trieNode.insert("ant", null);

        Assert.assertEquals(2, trieNode.getChildren().size());
        TrieNode o = (TrieNode) trieNode.getChildren().get(0);
        Assert.assertEquals(2, o.getChildren().size());
        Assert.assertEquals('a', o.getLetter());
        TrieNode o1 = (TrieNode) o.getChildren().get(0);
        Assert.assertEquals('n', o1.getLetter());
        TrieNode o2 = (TrieNode) o1.getChildren().get(0);
        Assert.assertEquals('t', o2.getLetter());
        Assert.assertTrue(o2.isWord());
    }
}
