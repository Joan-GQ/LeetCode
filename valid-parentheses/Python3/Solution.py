class Solution:
    def isValid(self, s: str) -> bool:
        if len(s) % 2 != 0: return False
        pairs = {
            '(':')',
            '[': ']',
            '{': '}'
        }
        
        stack = []
        for char in s:
            if char in '([{':
                stack.append(char)

            elif len(stack) == 0 or char != pairs[stack.pop()]:
                return False
                
        return len(stack) == 0