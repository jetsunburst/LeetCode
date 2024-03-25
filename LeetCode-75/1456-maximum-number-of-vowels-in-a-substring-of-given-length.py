class Solution:
    def maxVowels(self, s: str, k: int) -> int:

        vowels = 'aeiou'
        max_vowels_count = 0
        current_vowels_count = 0

        # Initialize the first window
        for i in range(k):
            if s[i] in vowels:
                current_vowels_count += 1
        max_vowels_count = current_vowels_count

        # Slide the window of size k through the string s
        for i in range(k, len(s)):
            # Remove the left element of the window
            if s[i-k] in vowels:
                current_vowels_count -= 1
            # Add the new element of the window
            if s[i] in vowels:
                current_vowels_count += 1
            # Update max_vowels_count if current window has more vowels
            max_vowels_count = max(max_vowels_count, current_vowels_count)

        return max_vowels_count