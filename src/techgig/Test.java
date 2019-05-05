package techgig;

import java.util.*;

public class Test {
    public static void main(String args[]) throws Exception {
        int index = 0;
        int testCases = Integer.parseInt(args[index]);

        Test candidateCode = new Test();
        for (int i = 0; i < testCases; i++) {
            int n = Integer.parseInt(args[index++]);
            int[] villains = new int[n];
            for (int j = 0; j < n; j++) {
                villains[j] = Integer.parseInt(args[index++]);
            }
            int[] players = new int[n];
            for (int j = 0; j < n; j++) {
                players[j] = Integer.parseInt(args[index++]);
            }

            String result = candidateCode.checkWinOrLose(n, villains, players);
            System.out.println(result);
        }
    }

    private String checkWinOrLose(int participants, int[] villains, int[] players) {
        int[] sortedVillains = sort(villains);
        int[] sortedPlayers = sort(players);
        boolean win = true;
        for (int i = 0; i < participants; i++) {
            if (sortedVillains[i] >= sortedPlayers[i]) {
                win = false;
            }
        }
        return (win ? "WIN" : "LOSE");
    }

    private int[] sort(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }
}
