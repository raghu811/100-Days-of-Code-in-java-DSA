class Solution {
    List<List<Integer>> res;
    void solve(Node cur, int level){
        if(cur == null)
            return ;
        if(level >= res.size()){
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(cur.val);
        for(int i=0;i<cur.children.size();i++){
            solve(cur.children.get(i), level+1);
        }
    }
    public List<List<Integer>> levelOrder(Node root) {
        res = new ArrayList<>();
        solve(root, 0);
        return res;
    }
}
