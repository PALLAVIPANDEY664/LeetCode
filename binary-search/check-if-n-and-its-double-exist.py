class Solution(object):
    def checkIfExist(self, arr):
        """
        :type arr: List[int]
        :rtype: bool
        """
        seen = set()
        
        for num in arr:
            # Check if double of current number exists
            if 2 * num in seen:
                return True
            # Check if half of current number exists (and it's even)
            if num % 2 == 0 and num // 2 in seen:
                return True
            seen.add(num)
        
        return False
        