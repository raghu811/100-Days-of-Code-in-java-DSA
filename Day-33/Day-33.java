class Solution { 

    private int binary(int[] a,int i,int j,int k){
        if(i<=j){
            int m=(i+j)/2;
            if(a[m]==k)
                return m;
            if(a[m]>k)
                return binary(a,i,m-1,k);
            else 
                return binary(a,m+1,j,k);
        }
        return -1;
    }

    private int pivort(int[] a,int i,int j,int n){
        if(i<=j){
            int m=(i+j)/2;
            if(a[n-1]<a[m])
                return pivort(a,m+1,j,n);
            else
                return pivort(a,i,m-1,n);
        }
        return i;
    }

    public int search(int[] nums, int target) {
        int n=nums.length;
        int p=pivort(nums,0,n-1,n);
        if(nums[p]==target)
            return p;
        if(nums[n-1]<target)
            return binary(nums,0,p-1,target);
        return binary(nums,p+1,n-1,target);
    }
}
