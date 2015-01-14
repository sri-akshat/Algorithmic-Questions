package su.problems;

import org.junit.Assert;
import su.dataStructure.Graph;
import su.dataStructure.Vertex;

import java.util.List;

/**
 * Created by Akshat on 1/17/2015.
 */
public class TestAllSourceToDestinationPaths {

    @org.junit.Test
    public void testCompute()
    {
        Graph graph = new Graph();
        Vertex<Integer> v2 = new Vertex<>(2);
        graph.addVertex(v2);
        Vertex<Integer> v0 = new Vertex<>(0);
        graph.addVertex(v0);
        Vertex<Integer> v1 = new Vertex<>(1);
        graph.addVertex(v1);
        Vertex<Integer> v3 = new Vertex<>(3);
        graph.addVertex(v3);

        v2.addEdge(v0);
        v2.addEdge(v1);

        v0.addEdge(v2);
        v0.addEdge(v1);
        v0.addEdge(v3);

        v1.addEdge(v3);

        AllSourceToDestinationPaths allSourceToDestinationPaths = new AllSourceToDestinationPaths();
        List<String> paths = allSourceToDestinationPaths.compute(graph, v2, v3);
        Assert.assertTrue(paths.contains("2-1-3"));
        Assert.assertTrue(paths.contains("2-0-3"));
        Assert.assertTrue(paths.contains("2-0-1-3"));
    }
}
