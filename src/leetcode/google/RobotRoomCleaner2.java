package leetcode.google;

//https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/1340/

import java.util.HashSet;
import java.util.Set;

/**
 * [1,1,1,1,1,0,1,1],
 * [1,1,1,1,1,0,1,1],
 * [1,0,1,1,1,1,1,1],
 * [0,0,0,1,0,0,0,0],
 * [1,1,1,1,1,1,1,1]
 */
public class RobotRoomCleaner2 {
    public void cleanRoom(Robot robot) {
        Set<String> cleaned = new HashSet<>();
        backtrack(cleaned, robot, 0, 0, 0);
    }

    //dir is Up and value is 0, 90 right, 180 down, 270 left
    void backtrack(Set<String> cleaned, Robot robot, int i, int j, int dir) {
        String cell = i + "," + j;
        if (cleaned.contains(cell)) {
            return;
        }
        robot.clean();
        cleaned.add(cell);

        for (int k = 0; k < 4; k++) {
            if (robot.move()) {
                int x = i, y = j;
                if (dir == 0) {
                    x = i - 1;
                } else if (dir == 90) {
                    y = j + 1;
                } else if (dir == 180) {
                    x = i + 1;
                } else if (dir == 270) {
                    y = j - 1;
                } else {
                    //throw new Exception("Error in direction");
                }

                backtrack(cleaned, robot, x, y, dir);

                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnLeft();
                robot.turnLeft();
            }
            robot.turnRight();
            dir += 90;
            dir %= 360;
        }
    }
}



