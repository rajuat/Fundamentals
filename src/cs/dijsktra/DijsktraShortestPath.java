package cs.dijsktra;

import java.util.ArrayList;
import java.util.List;

public class DijsktraShortestPath {

    public void findShortestPath(Graph g, Node from) {
        int noOfNodes = g.nodes.size();
        List<List<Node>> distances = new ArrayList<>();
        List<Node> nodes = distances.get(0);
        nodes.set(0, from);
        /*for (Node n : g.nodes) {
            if (n != from) {
                nodes.add(n);
            }
        }*/
        g.nodes.stream().filter(x -> x != from).forEach(x ->nodes.add(x));

    }
}
