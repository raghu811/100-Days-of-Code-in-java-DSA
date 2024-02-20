class Solution {
    public int countSegments(String s) {
        return (int) Arrays.stream(s.trim().split(" ")).filter(t -> t.length() > 0).count();
    }
}
