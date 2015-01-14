package su.design;

import su.dataStructure.Graph;
import su.dataStructure.Vertex;

/**
 * Created by Akshat on 5/11/2014.
 */
@FunctionalInterface
public interface CostFunction<T> {
    public T evaluate(Vertex v1, Vertex v2);
}
