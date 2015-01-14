package su;

import junit.framework.Assert;
import org.junit.Test;
import su.dataStructure.Edge;
import su.dataStructure.Graph;
import su.problems.WordLadder;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Ankur
 * Date: 2/21/13
 * Time: 1:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestWordLadder {

    String[] dictionary = {"hot","dot","dog","lot","log","cog","hit"};
    String start = "hit";
    String end = "cog";

    @Test
    public void testComputeLadder(){

        WordLadder wordLadder = new WordLadder();
        Assert.assertTrue("Wrong path", ("hit>hot>dot>dog>cog".equals(wordLadder.computeLadder(dictionary, start, end)) || "hit>hot>lot>log>cog".equals(wordLadder.computeLadder(dictionary, start, end))));
    }

    @Test
    public void testConstructGraph(){

        WordLadder wordLadder = new WordLadder();
        Graph graph = wordLadder.constructGraph(dictionary);
        Set<Edge> edgeList1 = graph.getVertices().get(0).getEdges();
        Set<Edge> edgeList2 = graph.getVertices().get(0).getEdges();
        Assert.assertEquals("Wrong graph construction", graph.getVertices().get(0).getData().toString(), "hot");
        Iterator<Edge> edgeIterate = edgeList1.iterator();
        Assert.assertEquals("Wrong graph construction", edgeIterate.next().getVertex2().getData().toString(), "dot");
        Assert.assertEquals("Wrong graph construction", edgeIterate.next().getVertex2().getData().toString(), "lot");
    }

}
