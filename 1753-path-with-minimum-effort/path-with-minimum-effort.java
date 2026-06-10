import java.util.*;

class coord {
    int x;
    int y;
    int diff;

    coord(int x, int y, int diff) {
        this.x = x;
        this.y = y;
        this.diff = diff;
    }
}

class Solution {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int minimumEffortPath(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        int[][] best = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(best[i], Integer.MAX_VALUE);
        }

        PriorityQueue<coord> pq =
                new PriorityQueue<>((a, b) -> a.diff - b.diff);

        best[0][0] = 0;
        pq.add(new coord(0, 0, 0));

        while (!pq.isEmpty()) {

            coord temp = pq.poll();

            int x = temp.x;
            int y = temp.y;
            int diff = temp.diff;

            // stale state
            if (diff > best[x][y]) continue;

            // destination reached
            if (x == m - 1 && y == n - 1) {
                return diff;
            }

            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 &&
                    nx < m && ny < n) {

                    int newEffort =
                            Math.max(
                                    diff,
                                    Math.abs(
                                            heights[nx][ny]
                                            - heights[x][y]
                                    )
                            );

                    if (newEffort < best[nx][ny]) {

                        best[nx][ny] = newEffort;

                        pq.add(
                                new coord(
                                        nx,
                                        ny,
                                        newEffort
                                )
                        );
                    }
                }
            }
        }

        return 0;
    }
}