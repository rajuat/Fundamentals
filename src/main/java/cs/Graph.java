package cs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    List<Vertex> vertices;
    List<Edge> edges;

    public Graph(List<Vertex> vertices, List<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }
}

class Vertex {
    int id;
    String name;
}

class Edge {
    int id;
    int source;
    int destination;
    int weight;
}



/*
class Edge {
    */
/*
    int[] nodes;
    Map<Integer, List<Edge>> adjacencies = new HashMap();
     *//*

    int destination;
    int weight;
}
*/


/*
int[] nodesWeight = new int[graph.length];
    int destinationIndex = 8;

    void path(int sourceIndex) {
        int[] weightsFromCurrentIndex = graph[sourceIndex];
        List<Integer> nextIndices = new ArrayList();
        for(int index = 0; index < weightsFromCurrentIndex.length; index++){
            if(weightsFromCurrentIndex[index] > 0){
                nextIndices.add(index);
                int weightOfCurrentNode = nodesWeight[index];
                if(weightOfCurrentNode > 0){ // visited this node before
                    int alternativeNewWeight = nodesWeight[sourceIndex]+weightsFromCurrentIndex[index];//finding weight routed from sourceIndex lesser
                    if(alternativeNewWeight < weightOfCurrentNode){
                        weightOfCurrentNode = alternativeNewWeight;
                    }
                } else {
                    weightOfCurrentNode = weightsFromCurrentIndex[index];//visiting for first time
                }
            }
        }
        if(sourceIndex == destinationIndex){
            return;
        } else {

        }



    }

 */
