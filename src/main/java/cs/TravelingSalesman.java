package cs;

public class TravelingSalesman {

    int size = 4;

    void travel(int startIndex) {
        int[] distances = new int[4];
        for (int i = 0; i < size; i++) {
            if(startIndex != i){
                distances[i] = graph[i][0];
            }
        }
    }


    int graph[][] = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}};
}
