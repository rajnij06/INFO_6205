public class Island {
    public static void main (String[] args) {
//        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}; //1
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}}; //3
        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {
        int c = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    c++;
                    find(i, j, grid);
                }
            }
        }
        return c;
    }
    private static void find(int row, int col, char[][] grid) {
        grid[row][col] = '2';
        if(isValid(row, col + 1, grid) && grid[row][col + 1] == '1')
            find(row, col+1, grid);
        if(isValid(row + 1, col, grid) && grid[row + 1][col] == '1')
            find(row + 1, col, grid);
        if(isValid(row, col - 1, grid) && grid[row][col - 1] == '1')
            find(row, col - 1, grid);
        if(isValid(row - 1, col, grid) && grid[row - 1][col] == '1')
            find(row - 1, col, grid);
    }
    private static boolean isValid(int row, int col, char[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}