class Solution:
    def merge_alternately(self, first_word: str, second_word: str) -> str:
        merged_result = ''
        min_length = min(len(first_word), len(second_word))

        for i in range(min_length):
            merged_result += first_word[i] + second_word[i]
        merged_result += first_word[min_length:] + second_word[min_length:]

        return merged_result
