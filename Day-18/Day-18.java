
/*
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>>result = new ArrayList<>();

         ArrayList s1 = new ArrayList();
         Arrays.sort(nums);
         if(nums.length <4){
             return result;
         }

         if(nums.length ==4){
             if(nums[0]+nums[1]+nums[2]+nums[3]== target){
                 s1.add(nums[0]);
                 s1.add(nums[1]);
                 s1.add(nums[2]);
                 s1.add(nums[3]);
                 result.add(s1);
                 return result;
             }
             else {
                 return result;
             }
         }

        int left =0 ;
        int right = nums.length-1;

        int num1 = 0;
        int num2= 0;

        int index =2;
           while(left<right){
                 
                  while(index<nums.length-1){
                  if(nums[left]+nums[right]+nums[index]+nums[index-1]==target){
                    s1.add(nums[left]);
                    s1.add(nums[right]);
                    s1.add(nums[index]);
                    s1.add(nums[index-1]);

                    result.add(s1);
                    s1.clear();
                    index++;
                  }
                  else{
                      index++;
                  }
           }
           left++;
           right--;
           index =left+2;

          }

return result;
        
    }
}
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, long target) {

        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

      int count =0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
            continue;
            }
            else{
                count++;
            }
        }
if(target<0 && count ==0){
    return new ArrayList<>(result);
}


        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        List<Integer> quadruplet = new ArrayList<>();
                        quadruplet.add(nums[i]);
                        quadruplet.add(nums[j]);
                        quadruplet.add(nums[left]);
                        quadruplet.add(nums[right]);

                        result.add(quadruplet);

                        left++;
                        right--;
                        
                        // Adjust left and right pointers to skip duplicates
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }
}
