class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        current_sum = sum(nums[:k])
        max_avg = current_sum / k
        window_start = 0

        for window_end in range(k, len(nums)):
            current_sum = current_sum - nums[window_start] + nums[window_end]
            window_start += 1
            max_avg = max(max_avg, current_sum / k)

        return max_avg