class Solution {

    public String decodeString(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch != ']') {
                stack.push(ch);
            }
            else {

                StringBuilder str = new StringBuilder();

                while (stack.peek() != '[') {
                    str.insert(0, stack.pop());
                }

                stack.pop();

                StringBuilder num = new StringBuilder();

                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    num.insert(0, stack.pop());
                }

                int repeat = Integer.parseInt(num.toString());

                StringBuilder repeated = new StringBuilder();

                for (int i = 0; i < repeat; i++) {
                    repeated.append(str);
                }

                for (char c : repeated.toString().toCharArray()) {
                    stack.push(c);
                }
            }
        }

        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }
}