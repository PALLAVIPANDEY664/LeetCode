class Solution(object):
    def removeElement(self, nums, val): # Added 'self'
        k = 0
        for i in range(len(nums)):
            if nums[i] != val:
                nums[k] = nums[i]
                k += 1
        return k