class Solution {
    class tuple {
        int first, second, third; // distance, row, col
        tuple(int f, int s, int t) {
            this.first = f;
            this.second = s;
            this.third = t;
        }
    }

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        int n = grid.length;
        int m = grid[0].length;
        
      

        // If source or destination is blocked
        if (grid[source[0]][source[1]] == 1 || grid[destination[0]][destination[1]] == 1)
            return -1;
        
        if(source[0]==destination[0] && source[1]==destination[1]) return 1;

        int[][] dist = new int[n][m];
        for (int[] row : dist)
            Arrays.fill(row, (int) 1e9);

        Queue<tuple> q = new LinkedList<>();
        q.add(new tuple(1, source[0], source[1]));
        dist[source[0]][source[1]] = 1;

        int[] dr = {-1, 0, 1, 0,-1,-1,1,1};
        int[] dc = {0, 1, 0, -1,-1,1,1,-1};

        while (!q.isEmpty()) {
            int dis = q.peek().first;
            int r = q.peek().second;
            int c = q.peek().third;
            q.remove();

            for (int i = 0; i < 8; i++) {
                int newr = r + dr[i];
                int newc = c + dc[i];

                if (newr >= 0 && newr < n && newc >= 0 && newc < m &&
                    grid[newr][newc] == 0 && dis + 1 < dist[newr][newc]) {

                    dist[newr][newc] = dis + 1;

                    // ✅ Safe to check destination *after* validation
                    if (newr == destination[0] && newc == destination[1])
                        return dis + 1;

                    q.add(new tuple(dis + 1, newr, newc));
                }
            }
        }

        return -1;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] source={0,0};
        int[] distination={n-1,m-1};
       return shortestPath(grid,source,distination);
    }
}