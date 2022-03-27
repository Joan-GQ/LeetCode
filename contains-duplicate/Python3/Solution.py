class Solution(object):
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        
        nums_set = set(nums)
        output = len(nums_set) != len(nums)
        
        return output