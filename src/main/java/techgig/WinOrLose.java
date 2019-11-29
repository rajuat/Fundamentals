package techgig;

import java.util.*;

public class WinOrLose {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String args[]) throws Exception {
        int testCases = scanner.nextInt();

        WinOrLose candidateCode = new WinOrLose();
        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            int[] villains = new int[n];
            for (int j = 0; j < n; j++) {
                villains[j] = scanner.nextInt();
            }
            int[] players = new int[n];
            for (int j = 0; j < n; j++) {
                players[j] = scanner.nextInt();
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
