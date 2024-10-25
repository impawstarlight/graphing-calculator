package com.jjk.gcalc;

import java.util.*;

public class FunctionEvaluator {
    private final List<String> postfix; // Stores the postfix expression

    // Operator precedence map
    private static final Map<String, Integer> precedence = Map.of(
            "+", 1, "-", 1,
            "*", 2, "/", 2,
            "^", 3
    );

    public FunctionEvaluator(String functionText) {
        postfix = convertToPostfix(functionText);
    }

    // Convert infix expression to postfix notation (shunting yard algorithm)
    private List<String> convertToPostfix(String functionText) {
        List<String> output = new ArrayList<>();
        Stack<String> operators = new Stack<>();
        StringTokenizer tokenizer = new StringTokenizer(functionText.replaceAll("\\s+", ""), "()+-*/^", true);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();

            if (isNumber(token) || token.equals("x")) {
                output.add(token); // Numbers and variable go directly to output
            } else if (isFunction(token)) {
                operators.push(token); // Functions are pushed to the stack
            } else if (token.equals("(")) {
                operators.push(token); // Left parenthesis is pushed
            } else if (token.equals(")")) {
                // Pop all operators until left parenthesis
                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    output.add(operators.pop());
                }
                operators.pop(); // Remove left parenthesis
                if (!operators.isEmpty() && isFunction(operators.peek())) {
                    output.add(operators.pop()); // Add function if any
                }
            } else if (isOperator(token)) {
                // Pop operators with higher or equal precedence
                while (!operators.isEmpty() && isOperator(operators.peek()) &&
                        precedence.get(token) <= precedence.get(operators.peek())) {
                    output.add(operators.pop());
                }
                operators.push(token);
            }
        }

        // Pop the remaining operators in the stack
        while (!operators.isEmpty()) {
            output.add(operators.pop());
        }

        return output;
    }

    // Evaluate the postfix expression for a given value of x
    public double evaluate(double x) {
        Stack<Double> stack = new Stack<>();

        for (String token : postfix) {
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token)); // Push numbers to stack
            } else if (token.equals("x")) {
                stack.push(x); // Push the value of x
            } else if (isOperator(token)) {
                // Pop two operands and apply the operator
                double b = stack.pop();
                double a = stack.pop();
                switch (token) {
                    case "+" -> stack.push(a + b);
                    case "-" -> stack.push(a - b);
                    case "*" -> stack.push(a * b);
                    case "/" -> stack.push(a / b);
                    case "^" -> stack.push(Math.pow(a, b));
                }
            } else if (isFunction(token)) {
                // Pop one operand and apply the function
                double a = stack.pop();
                switch (token) {
                    case "sin" -> stack.push(Math.sin(a));
                    case "cos" -> stack.push(Math.cos(a));
                }
            }
        }

        return stack.pop();
    }

    // Helper to check if the token is a number
    private boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Helper to check if the token is an operator
    private boolean isOperator(String token) {
        return precedence.containsKey(token);
    }

    // Helper to check if the token is a function
    private boolean isFunction(String token) {
        return token.equals("sin") || token.equals("cos");
    }

    public static void main(String[] args) {
        FunctionEvaluator fe = new FunctionEvaluator("sin(x)");
        System.out.println(fe.evaluate(Math.PI/2));  // Evaluate for x = 2
    }
}
