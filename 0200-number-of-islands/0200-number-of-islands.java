class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // visited matrix
        boolean[][] isVisited = new boolean[n][m];

        // answer variable
        int ans = 0;

        for(int row=0; row<n; row++) {
            for(int col=0; col<m; col++) {
                if(grid[row][col] == '1' && !isVisited[row][col]) {
                    ans++;
                    bfs(row, col, isVisited, grid);
                }
            }
        }

        return ans;
    }

    private void bfs(int row, int col, boolean[][] isVisited, char[][] grid) {
        isVisited[row][col] = true;
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(row, col));

        int n = grid.length;
        int m = grid[0].length;

        while(!q.isEmpty()) {
            int ro = q.peek().row;
            int co = q.peek().col;
            q.poll();

            for(int delRow=-1; delRow<=1; delRow++) {
                for(int delCol=-1; delCol<=1; delCol++) {
                    if(Math.abs(delRow) == 1 && Math.abs(delCol) == 1) continue;
                    int nrow = ro+delRow;
                    int ncol = co+delCol;

                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol] == '1' && !isVisited[nrow][ncol]) {
                        q.offer(new Pair(nrow, ncol));
                        isVisited[nrow][ncol] = true;
                    }
                }
            }
        }
    }
}

class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}