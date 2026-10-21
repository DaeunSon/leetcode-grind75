class Solution {
    public boolean isValid(String s) {

        //닫는 괄호가 나오면 가장 최근에 열린 괄호와 짝이어야함 - 스택
        
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            if (c=='(' || c=='[' || c=='{') {
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (top == '(' && c != ')') return false;
                if (top == '[' && c!= ']') return false;
                if (top == '{' && c!= '}') return false;
            }
        }
        return stack.isEmpty();
    }
}
