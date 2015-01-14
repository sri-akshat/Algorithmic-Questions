package su.problems;


import su.dataStructure.Edge;
import su.dataStructure.Graph;
import su.dataStructure.Stack;
import su.dataStructure.Vertex;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created with IntelliJ IDEA.
 * User: Akshat
 * Date: 2/20/13
 * Time: 9:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class WordLadder {

    Vertex startPtr;
    Vertex endPtr;

    public String computeLadder(String[] dictionary, String start, String end){

        Graph graph = constructGraph(dictionary);
        graph = applyBellmanFord(graph, start, end);

        Stack pathStack = new Stack(dictionary.length+1);

        do{
            pathStack.push(endPtr);
            endPtr = endPtr.parent;
        }while(endPtr != null);

        StringBuilder sb = new StringBuilder();
        while(!pathStack.isEmpty()){
            Vertex vertex = (Vertex) pathStack.pop();
            sb.append(vertex.getData().toString() + ">");
        }

        return sb.substring(0,sb.length()-1);
    }

    public Graph applyBellmanFord(Graph graph, String start, String end){

        initializeSingleSource(graph, start, end);

        for(int i=0; i<graph.getVertices().size()-1; i++){
            for(Edge edge : graph.getEdges()){
                realaxEdge(edge);
            }
        }

        return graph;
    }

    private void initializeSingleSource(Graph graph, String start, String end) {
        for(Vertex vertex : graph.getVertices()){
            if(vertex.getData().toString().equals(start)){
                vertex.setCost(0);
                startPtr = vertex;
            }else if(vertex.getData().toString().equals(end)){
                endPtr = vertex;
            }
        }
    }

    private void realaxEdge(Edge edge){
        if(edge.getVertex2().getCost() > (edge.getVertex1().getCost() + edge.getWeight())){
            edge.getVertex2().setCost(edge.getVertex1().getCost() + edge.getWeight());
            edge.getVertex2().parent = edge.getVertex1();
        }else if(edge.getVertex1().getCost() > (edge.getVertex2().getCost() + edge.getWeight())){
            edge.getVertex1().setCost(edge.getVertex2().getCost() + edge.getWeight());
            edge.getVertex1().parent = edge.getVertex2();
        }
    }


    public Graph constructGraph(String[] dictionary){

        Graph graph = new Graph();

        for (String word : dictionary){
            graph.addVertex(new Vertex(word));
        }

        graph.build((Vertex currentVertex, Vertex vertex) -> {
            int distance = 0;
            for(int i=0; i<currentVertex.getData().toString().length(); i++){
                distance += currentVertex.getData().toString().charAt(i) == vertex.getData().toString().charAt(i) ? 0 : 1;
            }
            return distance;
        }, (distance)->distance == 1);

        return graph;
    }
}

