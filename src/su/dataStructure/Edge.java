package su.dataStructure;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Ankur
 * Date: 2/21/13
 * Time: 12:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class Edge {

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

    public Edge(Vertex vertex1, Vertex vertex2) {
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
    }
}
