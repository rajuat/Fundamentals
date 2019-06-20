package cs.dijsktra;

import java.util.ArrayList;
import java.util.List;
/**
 * This algorithm is based on the explaning shared here - https://www.youtube.com/watch?v=8Ls1RqHCOPw
 */

public class DijsktraShortestPath {

    public void findShortestPath(Graph g, Node from) {
        List<List<Node>> distances = new ArrayList<>();
        List<Node> startingNodes = distances.get(0);
        startingNodes.set(0, from);
        g.nodes.stream().filter(x -> x != from).forEach(x ->startingNodes.add(x));



    }
}
