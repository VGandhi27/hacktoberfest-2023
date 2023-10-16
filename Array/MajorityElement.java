class Solution {

    //     THIRD APPROACH WORKS ONLY IF ARRAY CONTAINS 2 KIND OF NUMBERS
    public int majorityElement(int[] nums) 
    {
        Arrays.sort(nums);
        
        return nums[nums.length / 2];
    }
}