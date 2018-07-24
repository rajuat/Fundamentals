package cs;

import org.junit.Test;

import java.util.Arrays;

public class ShortestPathProblem {
    boolean[] sptSet;
    int[] distances;
    int size = 0;

    @Test
    public void testtttt(){
        path();
    }

    void path() {
        init();
        for(int j = 0; j < size; j++) {
            int nodeIndex = getMinimumDistanceNotFinalized();
            sptSet[nodeIndex] = true;
            for (int i = 0; i < size; i++) {
                if (!sptSet[i] &&
                        graph[nodeIndex][i] != 0 &&
                        distances[i] > distances[nodeIndex] + graph[nodeIndex][i]) {

                    distances[i] = distances[nodeIndex] + graph[nodeIndex][i];

                }
            }
        }
        print();
    }

    void print(){
        for (int i = 0; i < size; i++) {
            System.out.println(i + " " + distances[i]);
        }
    }

    int getMinimumDistanceNotFinalized() {
        int minimum = Integer.MAX_VALUE;
        int minimumIndex = 0;

        for(int i = 0; i < size; i++){
            if(!sptSet[i] && distances[i] < minimum){
                minimum = distances[i];
                minimumIndex = i;
            }
        }
        return minimumIndex;
    }

    void init() {
        size = graph.length;
        sptSet = new boolean[size];
        distances = new int[size];
        for (int i = 0; i < size; i++) {
            distances[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        distances[0] = 0;
    }


    int graph[][] = new int[][]{
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
    };

}
