
class Solution {
    public int jump(int[] nums) {
         int n = nums.length,ans = 0, curr = 0, y = 0;

        for (int i = 0; i < n - 1; i++) {
            y = Math.max(y, i + nums[i]);
            if (i == curr) {
                ans++;
                curr = y;
                if (curr >= n - 1) break; 
            }
        }
        return ans;
    }
}
