class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        max_can =  max(candies)
        return [max_can <= candi + extraCandies for candi in candies]