class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList();
        if (matrix.length == 0 || matrix[0].length == 0)  return res;
        // visited by pacific == -1, atlantic == -2, both == -3
        int[][] visited = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            dfs(matrix, visited, i, 0, -1);
            dfs(matrix, visited, i, matrix[0].length-1, -2);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            dfs(matrix, visited, 0, i, -1);
            dfs(matrix, visited, matrix.length-1, i, -2);
        }
        
        
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                if (visited[y][x] == -3) {
                    res.add(Arrays.asList(y,x));
                }
            }
        }
        return res;
    }
    
    private void dfs(int[][] matrix, int[][] visited, int y, int x, int code) {
        int val = matrix[y][x];
        int vis = visited[y][x];
        if (vis == code || vis == -3) return;
        visited[y][x] = vis < 0 ? -3 : code;
        
        boolean left = x > 0 && matrix[y][x-1] >= val;
        boolean right = x < matrix[0].length -1 && matrix[y][x+1] >= val;
        boolean up = y > 0 && matrix[y-1][x] >= val;
        boolean down = y < matrix.length - 1 && matrix[y+1][x] >= val;
        
        if (left) dfs(matrix, visited, y, x-1, code);
        if (right) dfs(matrix, visited, y, x+1, code);
        if (up) dfs(matrix, visited, y-1, x, code);
        if (down) dfs(matrix, visited, y+1, x, code);
    }
}
