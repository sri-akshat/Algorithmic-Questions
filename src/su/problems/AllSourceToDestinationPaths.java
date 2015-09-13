package su.problems;

import su.dataStructure.Edge;
import su.dataStructure.Graph;
import su.dataStructure.Vertex;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Akshat on 1/17/2015.
 *
 * Given a directed graph, a source vertex ‘s’ and a destination vertex ‘d’, print all paths from given ‘s’ to ‘d’.

 Consider the following directed graph. Let the s be 2 and d be 3. There are 4 different paths from 2 to 3.

 2=0->3
 \ | /
   1

 2 to 3
 2->1->3
 2->0->3
 2->0->1->3

 *
 */
public class AllSourceToDestinationPaths {
    public List<String> compute(Graph graph, Vertex start, Vertex end) {
        return traverseGraph(start, end, "", new ArrayList<String>(), new HashSet<>());
    }

    private List<String> traverseGraph(Vertex current, Vertex end, String path, List<String> paths, Set<Integer> pathTracker) {

        if(current == end)
        {
            path += current.getData()+"-";
            paths.add(path.substring(0, path.length()-1));
            return paths;
        }

        if(pathTracker.contains(current.getData()))
        {
            return paths;
        }

        for(Edge edge : (Set<Edge>)current.getEdges())
        {
            Set<Integer> newPathTracker = new HashSet<>(pathTracker);
            newPathTracker.add((Integer) current.getData());
            traverseGraph(edge.getVertex2(), end, path + current.getData() + "-", paths, newPathTracker);
        }

        return paths;
    }
}
