class Solution {
    public int totalNQueens(int num) {
    int[] memo = new int[num];
    int count = 0 ;
    for(int i=0;i<num;i++) {
      memo[0] = i;
      count = count + dfs(0, i, memo,num);
    }
    return count;
    }
  
    public static int dfs(int x, int y, int[] memo, int num){
    int count = 0;
    if(isValid(x,y,memo)){
      if(x == num -1) return 1;
      for(int i=0;i<num;i++){
        memo[x+1] = i;
        count = count + dfs(x+1,i, memo, num);
      }
    }
    return count;
  }
  public static boolean isValid(int x, int y, int[] memo){
    int curr;
    for(int i=0; i<x;i++){
      curr = memo[x-i-1];
      if(curr == y || (y > 0 && curr == y-i-1) || curr == y+i+1)
        return false;
    }
    return true;
  }
}
