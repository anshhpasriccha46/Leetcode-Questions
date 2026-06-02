import java.util.*;

class Coord {
    int x;
    int y;

    Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public void solve(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 'O' && !visited[i][j]) {

                    ArrayList<Coord> component = new ArrayList<>();

                    boolean touchesBorder =
                            dfs(i, j, visited, grid, component);

                    if (!touchesBorder) {

                        for (Coord cell : component) {
                            grid[cell.x][cell.y] = 'X';
                        }

                    }
                }
            }
        }
    }

    public boolean dfs(int r,
                       int c,
                       boolean[][] visited,
                       char[][] grid,
                       ArrayList<Coord> component) {

        visited[r][c] = true;

        component.add(new Coord(r, c));

        boolean border = false;

        if (r == 0 || r == grid.length - 1 ||
            c == 0 || c == grid[0].length - 1) {

            border = true;
        }

        for (int k = 0; k < 4; k++) {

            int nr = r + dx[k];
            int nc = c + dy[k];

            if (nr >= 0 && nr < grid.length &&
                nc >= 0 && nc < grid[0].length &&
                grid[nr][nc] == 'O' &&
                !visited[nr][nc]) {

                if (dfs(nr, nc, visited, grid, component)) {
                    border = true;
                }
            }
        }

        return border;
    }
}