package su.problems;

import javafx.util.Pair;
import su.dataStructure.Edge;
import su.dataStructure.Graph;
import su.dataStructure.Vertex;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Akshat on 5/8/2014.
 *
 * Walter White and Jesse Pinkman have now established their bases at different places.
 Now they want to form a network, that is, they want that all their bases should be reachable from every base.
 One base is reachable from other base if there is a path of tunnels connecting bases.
 Bases are suppose based on a 2-D plane having integer coordinates.
 Cost of building tunnels between two bases are coordinates (x1,y1) and (x2,y2) is min{ |x1-x2|, |y1-y2| }.

 What is the minimum cost such that a network is formed.

 Input:
 First line contains N, the number of bases.
 Each of the next N lines contain two integers xi and yi.

 Output:
 Print the minimum cost of building the network.

 Constraints:
 1 ≤ N ≤ 100000
 -109 ≤ xi,yi ≤ 109
 *
 */
public class  MakePaths {

    public Graph constructGraph(Graph graph)
    {
        if(graph==null){
            graph = new Graph();
            addVertexFromStdIn(graph);
        }

        graph.build((Vertex currentVertex, Vertex vertex)->{
            int x1 = ((Pair<Integer, Integer>)currentVertex.getData()).getKey();
            int y1 = ((Pair<Integer, Integer>)currentVertex.getData()).getValue();
            int x2 = ((Pair<Integer, Integer>)vertex.getData()).getKey();
            int y2 = ((Pair<Integer, Integer>)vertex.getData()).getValue();

            int xDiff = Math.abs(x1-x2);
            int yDiff = Math.abs(y1-y2);

            return xDiff > yDiff ? yDiff : xDiff;
        }, (n)->true);

        return graph;
    }

    private void addVertexFromStdIn(Graph graph) {
        Scanner scanner = new Scanner(System.in);
        int records = scanner.nextInt();
        for(int i=0; i<records ;i++)
        {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Pair<Integer, Integer> pair = new Pair<Integer, Integer>(x,y);
            Vertex<Pair<Integer, Integer>> vertex = new Vertex<Pair<Integer, Integer>>(pair);
            graph.addVertex(vertex);
        }
    }


    public int  evaluateMinCost(Graph graph)
    {
        Set<Vertex> unVisitedVertices = new HashSet<>(graph.getVertices().subList(1,graph.getVertices().size()));
        Set<Vertex> visitedVertices = new HashSet<Vertex>();
        visitedVertices.add(graph.getVertices().get(0));
        int totalMinCost = 0;
        do{
            Edge minEdge = getMinEdgeFor(visitedVertices);
            totalMinCost += minEdge.getWeight();
            visitedVertices.add(minEdge.getVertex1());
            visitedVertices.add(minEdge.getVertex2());
        }while(visitedVertices.size() != graph.getVertices().size());

        return totalMinCost;
    }

    private Edge getMinEdgeFor(Set<Vertex> visitedVertices) {

        int minWeight = Integer.MAX_VALUE;
        Edge minEdge = null;
        for(Vertex vertex : visitedVertices)
        {
            for(Edge edge : (Set<Edge>)vertex.getEdges())
            {
                if(!edge.isVisited(visitedVertices) && minWeight > edge.getWeight())
                {
                    minEdge = edge;
                    minWeight = edge.getWeight();
                }
            }
        }
        return minEdge;
    }

    private boolean edgeExists(Vertex<Pair<Integer, Integer>> vertex, Vertex<Pair<Integer, Integer>> eachVertex) {
        for(Edge edge : eachVertex.getEdges())
        {
            if((edge.getVertex1() == vertex || edge.getVertex1() == eachVertex)&&(edge.getVertex2() == vertex || edge.getVertex2() == eachVertex))
            {
                return true;
            }
        }
        return false;
    }

    private int evaluateCost(Vertex currentVertex, Vertex vertex) {

        int x1 = ((Pair<Integer, Integer>)currentVertex.getData()).getKey();
        int y1 = ((Pair<Integer, Integer>)currentVertex.getData()).getValue();
        int x2 = ((Pair<Integer, Integer>)vertex.getData()).getKey();
        int y2 = ((Pair<Integer, Integer>)vertex.getData()).getValue();

        int xDiff = Math.abs(x1-x2);
        int yDiff = Math.abs(y1-y2);

        return xDiff > yDiff ? yDiff : xDiff;
    }

    public static void main(String[] args)
    {
        MakePaths makePaths = new MakePaths();
        Graph graph = makePaths.constructGraph(null);
        System.out.println(makePaths.evaluateMinCost(graph));
    }


}
