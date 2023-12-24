class Solution:
    def maxArea(self, height: List[int]) -> int:
        left, right =0, len(height)-1
        max_water = 0
        while left < right:
            w =  right - left
            h = min(height[left],height[right])
            current_area = w * h
            if height[left]  < height[right]:
                left+=1
            else:
                right-=1
            if current_area > max_water:
                max_water = current_area
        return max_water