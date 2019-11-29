package graphs;

import java.util.LinkedList;
import java.util.List;

public class FindNodesThatDisconnects {

    void dfs(Graph graph){

    }

    Graph createGraph(int V, List<List<Integer>> edges){
        Graph graph = new Graph(V);
        for(List<Integer> edge: edges){
            addEdges(graph, edge);
        }
        return graph;
    }

    private void addEdges(Graph graph, List<Integer> edge){
        graph.adjListArray[edge.get(0)].add(edge.get(1));
        graph.adjListArray[edge.get(1)].add(edge.get(0));
    }

    class Graph {
        int V;
        LinkedList<Integer>[] adjListArray;
        Graph(int V){
            this.V = V;
            this.adjListArray = new LinkedList[V];
            for(int i = 0; i < V; ++i){
                adjListArray[i] = new LinkedList<>();
            }
        }
    }
}
