package su.dataStructure;

import su.design.CostFunction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Created with IntelliJ IDEA.
 * User: Ankur
 * Date: 2/21/13
 * Time: 12:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class Graph {

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

    public void build(CostFunction<Integer> costFunction, Predicate<Integer> predicate) {
        for(Vertex currentVertex : this.getVertices()){
            for(Vertex vertex : this.getVertices()){
                if(currentVertex != vertex) {
                    Integer edgeWeight = costFunction.evaluate(currentVertex, vertex);
                    if (predicate.test(edgeWeight)) {
                        Edge newEdge = new Edge(currentVertex, vertex, edgeWeight);
                        Edge edge = vertex.findEdge(newEdge);
                        currentVertex.addEdge(edge==null?newEdge:edge);
                    }
                }
            }
        }
    }

}
