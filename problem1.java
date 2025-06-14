// https://leetcode.com/problems/rotting-oranges

// Time Complexity : O(m+n)
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// use direction array to access neighbours
// use bfs=> put all rotten in queue, then while queue is not empty, keep taking out
// orange and put fresh neighbours of that orange
// at end of every level, increase time.
// check if freshh count is 0 at the end, if not return -1 else return time.

class Solution {
    int [][] dirs={{0,1},{1,0},{-1,0},{0,-1}};
    int m;
    int n;
    public int orangesRotting(int[][] grid) {
        this.m=grid.length;
        this.n=grid[0].length;
        int fresh =0;
        Queue<int[]> q= new LinkedList<>();
        // Queue<int> rq= new LinkedList<>(); //row index
        // Queue<int> cq= new LinkedList<>(); //coloum index
        for(int i=0; i<m; i++){
            for(int j=0; j<n;j++){
                if(grid[i][j]==2) q.add(new int[] {i,j});
                else if(grid[i][j]==1) fresh++;
            }
        }
        int time=0;
        if(fresh==0) return 0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0; i<size;i++){
                int[] current = q.poll();
                for(int[] dir:dirs){
                    int nr= dir[0]+current[0];
                    int nc=dir[1]+current[1];
                    //bounds check
                    if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        fresh--;
                        if(fresh==0) return time+1;
                        q.add(new int[] {nr,nc});  
                    }
                }
            }
            time++;
        }
        return -1;
    }
}