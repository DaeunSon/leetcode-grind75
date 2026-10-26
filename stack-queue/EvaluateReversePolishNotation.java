class Solution {
    public int evalRPN(String[] tokens) {

        Deque<Integer> stack = new ArrayDeque<>(); //후입선출

        for(int i=0;i<tokens.length;i++) {

            if (tokens[i].equals("+") || tokens[i].equals("-")
            || tokens[i].equals("*") || tokens[i].equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(calculate(a,b,tokens[i]));
            }

            else { //숫자면 바로 저장
                stack.push(Integer.valueOf(tokens[i]));
            }
        }

        return stack.pop();
    }

    public int calculate(int a, int b, String operation) {
        if (operation.equals("+")) {
                return a+b;
            }

            else if (operation.equals("-")) {
                return b-a;
            }

            else if (operation.equals("*")) {
                return a*b;
            }

            else {
                return b/a;
            }
    }
}
