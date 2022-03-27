class Solution {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> set = new HashMap<>();
        for (int i = 0, numsLength = nums.length; i < numsLength; i++) {
            int num = nums[i];
            if(set.containsKey(num) && i-set.get(num) <= k) return true;
            set.put(num,i);
        }
        return false;
    }
}