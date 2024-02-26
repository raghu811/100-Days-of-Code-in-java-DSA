class Solution {
    private int mostFrequency = 0;
    private int dfs(TreeNode root, Map<Integer, Integer> map){
        if(root == null){
            return 0;
        }
        int sum = root.val + dfs(root.left, map) + dfs(root.right, map);
        int frequency = map.getOrDefault(sum, 0) + 1;
        map.put(sum, frequency);
        if(frequency > mostFrequency){
            mostFrequency = frequency;
        }
        return sum;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        List<Integer> list = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key) == mostFrequency){
                list.add(key);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
