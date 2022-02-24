class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort() # Timsort
        result = []
        
        length = len(nums)
        
        for i in range(length):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            
            j  = i + 1
            k = length - 1
            
            while j < k:
                a = nums[i]
                b = nums[j]
                c = nums[k]
                three_sum = a + b + c;
                
                if three_sum == 0:
                    result.append([a,b,c])
                    
                    while k > j+1 and nums[j+1] == nums[j]:
                        j += 1
                    while j < k-1 and nums[k-1] == nums[k]:
                        k -= 1
                        
                    j += 1
                    k -= 1
                    
                elif three_sum > 0:
                    k -= 1
                elif three_sum < 0:
                    j += 1
                    
        return result