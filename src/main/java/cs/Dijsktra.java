package cs;

import org.junit.Test;

import java.util.*;

public class Dijsktra {

    @Test
    public void canDijsktra() {
        shortestPath();
        for (Integer key : distanceMap.keySet()) {
            System.out.println(key + " " + distanceMap.get(key));
        }
    }

    public static final int NOT_VISITED_DISTANCE = 100;
    PriorityQueue<Node> minHeap = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);
    Map<Integer, Integer> distanceMap = new HashMap();
    Map<Integer, Integer> routeMap = new HashMap();

    void shortestPath() {
        DGraph graph = new DGraph(6).build();
        initMinHeap();

        while (!minHeap.isEmpty()) {
            Node poll = minHeap.poll();
            distanceMap.put(poll.nodeName, poll.distance);

            //update neighbours
            LinkedList<Node> neighbours = graph.adjadencyList[poll.nodeName];
            if(neighbours == null){ // the last node
                System.out.println("happens once");
                continue;
            }
            ListIterator<Node> nodeListIterator = neighbours.listIterator();
            while (nodeListIterator.hasNext()) {
                Node current = nodeListIterator.next();
                Node heapCurrentClone = null;
                int heapCurrentDistance = -1;
                if (!distanceMap.containsKey(current)) { //if not is distanceMap, node already visited
                    Iterator<Node> heapIterator = minHeap.iterator();
                    while (heapIterator.hasNext()) {
                        Node heapN = heapIterator.next();
                        if (heapN.nodeName == current.nodeName) {
                            heapCurrentClone = heapN;
                            heapCurrentDistance = heapN.distance;
                            break;
                        }
                    }
                    if (minHeap.remove(heapCurrentClone)) { //removes with nodename
                        int newDistance = current.distance + poll.distance; //current contains cummulative distance now
                        if (heapCurrentDistance != NOT_VISITED_DISTANCE) { //visited before
                            current.distance = Math.min(newDistance, heapCurrentClone.distance);//revisit if current node has a lower distance from source
                        } else {
                            current.distance = newDistance;
                        }
                        minHeap.add(current);//adds with real priority
                        //now add or override to route
                        routeMap.put(current.nodeName, poll.nodeName);
                    }
                }
            }
        }
    }


    void initMinHeap() {
        minHeap.add(new Node(0, 99));
        minHeap.add(new Node(1, NOT_VISITED_DISTANCE));
        minHeap.add(new Node(2, NOT_VISITED_DISTANCE));
        minHeap.add(new Node(3, NOT_VISITED_DISTANCE));
        minHeap.add(new Node(4, NOT_VISITED_DISTANCE));
        minHeap.add(new Node(5, NOT_VISITED_DISTANCE));
    }
}


class DGraph {

    int V = 0;
    LinkedList<Node> adjadencyList[] = null;

    public DGraph(int V) {
        this.V = V;
        this.adjadencyList = new LinkedList[V];
    }

    DGraph build() {
        DGraph g = new DGraph(6);

        LinkedList<Node> from0 = new LinkedList<>();
        from0.add(new Node(1, 2));
        from0.add(new Node(5, 4));
        from0.add(new Node(3, 10));
        g.adjadencyList[0] = from0;

        LinkedList<Node> from1 = new LinkedList<>();
        from1.add(new Node(2, 3));
        g.adjadencyList[1] = from1;

        LinkedList<Node> from2 = new LinkedList<>();
        from2.add(new Node(3, 5));
        g.adjadencyList[2] = from2;

        LinkedList<Node> from4 = new LinkedList<>();
        from4.add(new Node(3, 4));
        g.adjadencyList[4] = from4;

        LinkedList<Node> from5 = new LinkedList<>();
        from5.add(new Node(4, 2));
        g.adjadencyList[5] = from5;
        return g;
    }
}

class Node {
    int nodeName;
    int distance;

    public Node(int nodeName, int distance) {
        this.nodeName = nodeName;
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return nodeName == node.nodeName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodeName);
    }
}
