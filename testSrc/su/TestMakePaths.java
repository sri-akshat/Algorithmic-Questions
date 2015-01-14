package su;

import javafx.util.Pair;
import junit.framework.Assert;
import org.junit.Test;
import su.dataStructure.Edge;
import su.dataStructure.Graph;
import su.dataStructure.Vertex;
import su.problems.MakePaths;

/**
 * Created by Akshat on 5/9/2014.
 */
public class TestMakePaths {

    @Test
    public void testEvaluateMinCost()
    {
        MakePaths makePaths = new MakePaths();

        Graph graph = new Graph();
        graph.addVertex(new Vertex<Pair<Integer, Integer>>(new Pair<Integer, Integer>(1, 5)));
        graph.addVertex(new Vertex<Pair<Integer, Integer>>(new Pair<Integer, Integer>(7,8)));
        Assert.assertEquals("Wrong cost", 3, makePaths.evaluateMinCost(makePaths.constructGraph(graph)));
    }

    @Test
    public void testEvaluateMinCostWith3Vertex()
    {
        MakePaths makePaths = new MakePaths();

        Graph graph = new Graph();
        graph.addVertex(new Vertex<Pair<Integer, Integer>>(new Pair<Integer, Integer>(1, 5)));
        graph.addVertex(new Vertex<Pair<Integer, Integer>>(new Pair<Integer, Integer>(7,8)));
        graph.addVertex(new Vertex<Pair<Integer, Integer>>(new Pair<Integer, Integer>(7,3)));
        Assert.assertEquals("Wrong cost", 2, makePaths.evaluateMinCost(makePaths.constructGraph(graph)));
    }

    @Test
    public void testEvaluateMinCostWith5Vertex()
    {
        MakePaths makePaths = new MakePaths();

        Graph graph = new Graph();
        graph.addVertex(new Vertex<Pair<Integer, Integer>>(new Pair<Integer, Integer>(1, 5)));
        graph.addVertex(new Vertex<Pair<Integer, Integer>>(new Pair<Integer, Integer>(7,8)));
        graph.addVertex(new Vertex<Pair<Integer, Integer>>(new Pair<Integer, Integer>(7,3)));
        graph.addVertex(new Vertex<Pair<Integer, Integer>>(new Pair<Integer, Integer>(5,1)));
        graph.addVertex(new Vertex<Pair<Integer, Integer>>(new Pair<Integer, Integer>(8,2)));
        Assert.assertEquals("Wrong cost", 4, makePaths.evaluateMinCost(makePaths.constructGraph(graph)));
    }

    @Test
    public void testEdgeHashCode()
    {
        Vertex vertex1 = new Vertex<Pair<Integer, Integer>>(new Pair<Integer, Integer>(1, 5));
        Vertex vertex2 = new Vertex<Pair<Integer, Integer>>(new Pair<Integer, Integer>(7, 8));

        Edge edge1 = new Edge(vertex1, vertex2, 1);
        Edge edge2 = new Edge(vertex2, vertex1, 1);

        edge1.setWeight(2);

        Assert.assertEquals("different objetcs", edge1.hashCode(), edge2.hashCode());
        Assert.assertEquals("different objects", edge1, edge2);
    }
}
