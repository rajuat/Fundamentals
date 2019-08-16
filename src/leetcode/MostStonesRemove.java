package leetcode;

public class MostStonesRemove {

    public int removeStones(int[][] stones){
        if(stones == null || stones.length == 0) return 0;
        int res = 0;
        int n = stones.length;
        int m = stones[0].length;
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[m];
        for(int row = 0; row < n ; row++) {
            for(int col = 0; col < m; col++) {
                if(stones[row][col] > 0){
                    int k = col;
                    for(; k < m; k++){
                        if(stones[row][k] > 0){
                            stones[row][col] = 0;
                            res++;
                            break;
                        }
                    }
                    if(k+1 < m) {
                        continue; //have a row cleared
                    }
                    if(!cols[col]){
                        k = row;
                        for(; k < n; k++) {
                            if(stones[k][col] > 0){
                                stones[k][col] = 0;
                                res++;
                                break;
                            }
                        }
                        if(k+1 == n) {
                            cols[col] = true;
                        }
                    }
                }
            }
        }
        return res;
    }

}
