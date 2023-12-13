class Solution:
    def reverseWords(self, s: str) -> str:
        reversed_string = ""
        i = len(s) - 1
        while i >= 0:
            while i >= 0 and s[i] == " ":
                    i -= 1
            if i >= 0:
                word_end = i + 1
                while i >= 0  and s[i] != " ":
                    i -= 1
                word_start = i
                reversed_string += s[word_start+1:word_end] + " "
        return reversed_string.strip()
    
"""
class Solution:
    def reverseWords(self, s: str) -> str:
        s= s.split()
        s = s[::-1]
        s = ' '.join(s)
        return s
"""