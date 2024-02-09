class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int n = arr.length;
        int sum = 0;
        int len = 0;
        int ans = n+1;
        int i=0;
        int j=0;

        while(j<n){
            sum+=arr[j];
            while(sum>=target){
                len = j-i+1;
                ans = Math.min(ans,len);
                sum-=arr[i];
                i++;
            }
            j++;
        }
        return (ans==n+1) ? 0 : ans;
    }
}
