package cs.dijsktra;

import java.util.List;

public class Graph {
    List<Node> nodes;
}

class Node {
    String name;
    int fromDistance;
    List<Node> adjacent;

    @Override
    public boolean equals(Object n) {
        return this.name == ((Node)n).name;
    }
}
