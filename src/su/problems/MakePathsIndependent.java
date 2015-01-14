package su.problems;

import java.util.*;

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
public class MakePathsIndependent {

    public Graph constructGraph(Graph graph)
    {
        if(graph==null){
            graph = new Graph();
            addVertexFromStdIn(graph);
        }

        graph.build();

        return graph;
    }

    private int getWeight(Vertex currentVertex, Vertex vertex) {

        int x1 = ((Pair)currentVertex.getData()).getKey();
        int y1 = ((Pair)currentVertex.getData()).getValue();
        int x2 = ((Pair)vertex.getData()).getKey();
        int y2 = ((Pair)vertex.getData()).getValue();

        int xDiff = Math.abs(x1-x2);
        int yDiff = Math.abs(y1-y2);

        return xDiff > yDiff ? yDiff : xDiff;
    }

    private void addVertexFromStdIn(Graph graph) {
        Scanner scanner = new Scanner(System.in);
        int records = scanner.nextInt();
        for(int i=0; i<records ;i++)
        {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Pair pair = new Pair(x,y);
            Vertex<Pair> vertex = new Vertex<Pair>(pair);
            graph.addVertex(vertex);
        }
    }


    public int  evaluateMinCost(Graph graph)
    {
        Set<Vertex> unVisitedVertices = new HashSet<Vertex>(graph.getVertices().subList(1,graph.getVertices().size()));
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

    private boolean edgeExists(Vertex<Pair> vertex, Vertex<Pair> eachVertex) {
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

        return getWeight(currentVertex, vertex);
    }

    public static void main(String[] args)
    {
        MakePathsIndependent makePaths = new MakePathsIndependent();
        Graph graph = makePaths.constructGraph(null);
        System.out.println(makePaths.evaluateMinCost(graph));
    }


    class Graph{

        List<Vertex> vertices = new ArrayList<Vertex>();

        public List<Vertex> getVertices() {
            return vertices;
        }

        public void setVertices(List<Vertex> vertices) {
            this.vertices = vertices;
        }

        public void addVertex(Vertex vertex) {
            this.vertices.add(vertex);
        }

        public Set<Edge> getEdges(){

            Set<Edge> edges = new HashSet<Edge>();
            for(Vertex vertex : vertices){
                edges.addAll(vertex.getEdges());
            }
            return edges;
        }

        public void build() {
            for(Vertex currentVertex : this.getVertices()){
                for(Vertex vertex : this.getVertices()){
                    if(currentVertex != vertex) {
                        Integer edgeWeight = getWeight(currentVertex, vertex);
                        Edge newEdge = new Edge(currentVertex, vertex, edgeWeight);
                        Edge edge = vertex.findEdge(newEdge);
                        currentVertex.addEdge(edge==null?newEdge:edge);
                    }
                }
            }
        }


    }

    class Edge {

        Vertex vertex1;
        Vertex vertex2;
        int weight;

        public boolean isVisited(Set<Vertex> visitedVertices) {
            if(visitedVertices.contains(this.vertex1) && visitedVertices.contains(this.vertex2))
                return true;
            return false;
        }

        public Edge(Vertex vertex1, Vertex vertex2, int weight) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }

        Edge(Vertex vertex1, Vertex vertex2) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
        }

        public Vertex getVertex1() {
            return vertex1;
        }

        public void setVertex1(Vertex vertex1) {
            this.vertex1 = vertex1;
        }

        public Vertex getVertex2() {
            return vertex2;
        }

        public void setVertex2(Vertex vertex2) {
            this.vertex2 = vertex2;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public int hashCode(){

            return vertex1.hashCode() + vertex2.hashCode();
        }

        @Override
        public boolean equals(Object obj) {

            Edge edge = (Edge)obj;
            return (vertex1.hashCode() + vertex2.hashCode()) == (edge.vertex1.hashCode() + edge.vertex2.hashCode());
        }    }

    class Vertex<T> {

        private Set<Edge> edges = new HashSet<Edge>();
        private T data;
        public Vertex parent;
        private Integer cost = Integer.MAX_VALUE/2;

        public Integer getCost() {
            return cost;
        }

        public void setCost(Integer cost) {
            this.cost = cost;
        }

        public Vertex(T data) {
            this.data = data;
        }

        public Set<Edge> getEdges() {
            return edges;
        }

        public void setEdges(Set<Edge> edges) {
            this.edges = edges;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void addEdge(Edge edge) {

            this.edges.add(edge);
        }

        public Edge getMinEdge(){

            Edge minEdge = null;
            int weight = Integer.MAX_VALUE;
            for(Edge edge : this.edges)
            {
                if(edge.getWeight() < weight)
                {
                    minEdge = edge;
                }
            }
            return minEdge;
        }

        public Edge findEdge(Edge newEdge) {
            for (Edge edge : this.getEdges()) {
                if (edge.hashCode() == newEdge.hashCode()) {
                    return edge;
                }
            }
            return null;
        }
    }

    class Pair{

        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }

}
