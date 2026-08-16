package find_valid_parentheses;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String input = "{[()]}";
        boolean isValid = isValidParentheses(input);
        System.out.println("Is the parentheses valid? " + isValid);
    }
    private static boolean isValidParentheses(String s){
        if(s == null || s.isEmpty()){
            return true;
        }
        // Use a stack to keep track of opening parentheses
        Stack<Character> stack = new Stack<>();
        //Loop through each character in the string
        for(char c: s.toCharArray()){
            //If it's an opening parenthesis, push it onto the stack
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else {
                // Closing bracket without opening bracket
                if(stack.isEmpty()){
                    return false;
                }
                // Get the most recent opening bracket
                char top = stack.pop();
                // Check matching pair
                if (c == ')' && top != '(') {
                    return false;
                }
                if (c == '}' && top != '{') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty(); // If stack is empty, all parentheses are matched
    }
}
