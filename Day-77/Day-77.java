
class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    private void dfs(TreeNode node, List<Integer> path, int remainingSum) {
        // if it is null, then return
        if (node == null) return;
        path.add(node.val);
        if (node.left == null && node.right == null && remainingSum == node.val) ans.add(new ArrayList<>(path));
        this.dfs(node.left, path, remainingSum - node.val);
        this.dfs(node.right, path, remainingSum - node.val);
        // backtrack 
        path.remove(path.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<Integer>();
        dfs(root, path, targetSum);
        return ans;
    }
}
