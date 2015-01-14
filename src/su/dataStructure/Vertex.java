package su.dataStructure;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Ankur
 * Date: 2/21/13
 * Time: 12:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class Vertex<T> {

    private Set<Edge> edges = new HashSet<Edge>();
    private T data;
    public Vertex parent;
    private Integer cost = Integer.MAX_VALUE / 2;

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

    public void addEdge(Vertex v2) {

        this.edges.add(new Edge(this,v2));
    }

    public Edge getMinEdge() {

        Edge minEdge = null;
        int weight = Integer.MAX_VALUE;
        for (Edge edge : this.edges) {
            if (edge.getWeight() < weight) {
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