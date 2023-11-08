package legacy.forth;

import java.util.*;

enum Token {NUM, OP, USRDEFOP, PUNCT, ERR}

record Entry(Token token, String lexeme) {
}

public class ForthEvaluator {
    List<List<String>> usrOpDefinition = new ArrayList<>();

    public List<Integer> evaluateProgram(List<String> expression) {
        List<String> exprInUppCase = new ArrayList<>();
        expression.forEach(expr -> exprInUppCase.add(expr.toUpperCase()));

        //find user defined/redefined ops
        exprInUppCase.stream().filter(line -> line.trim().matches("^:.*;$")).forEach(def -> {
            String[] arr = def.split("\\s");
            List<String> opDefinition = new ArrayList<>();
            opDefinition.add(arr[1]);
            opDefinition.add(String.join(" ", Arrays.copyOfRange(arr, 2, arr.length - 1)));
            usrOpDefinition.add(opDefinition);
        });

        //reversal of the list is necessary as a user operator may be defined recursively
        Collections.reverse(usrOpDefinition);

        String expandedExprInUppCase = preprocess(expression.get(expression.size() - 1));
        Deque<Entry> exprToEvalDeque = new ArrayDeque<>();

        Arrays.stream(expandedExprInUppCase.split(" ")).forEach(lexeme -> exprToEvalDeque.addLast(new Entry(getToken(lexeme), lexeme)));

        //to store results of the evaluated expression
        Deque<Integer> resultDeque = new ArrayDeque<>();

        while (!exprToEvalDeque.isEmpty()) {
            evaluateNextSubExpr(exprToEvalDeque, resultDeque);
        }
        return resultDeque.stream().toList();
    }

    // expands all the redefined/user defined operators in the expression
    private String preprocess(String inputExpr) {

        //check if there is a user operator without definition
        Arrays.stream(inputExpr.split(" ")).filter(lexeme -> getToken(lexeme) == Token.USRDEFOP).forEach(lex -> {
            if (usrOpDefinition.stream().noneMatch(op -> lex.equalsIgnoreCase(op.get(0))))
                throw new IllegalArgumentException(String.format("No definition available for operator \"%s\"", lex.toLowerCase()));
        });

        String expandedExpr = inputExpr.toUpperCase();

        //see if user is defining any token other than operators
        for (List<String> definition : usrOpDefinition) {
            if (!(getToken(definition.get(0)) == Token.OP || getToken(definition.get(0)) == Token.USRDEFOP)) {
                if (getToken(definition.get(0)) == Token.NUM)
                    throw new IllegalArgumentException("Cannot redefine numbers");
                else throw new IllegalArgumentException("Wrong definition");
            }

            expandedExpr = expandedExpr.replace(definition.get(0), definition.get(1));

        }
        return expandedExpr;
    }

    private Token getToken(String lexeme) {
        lexeme = lexeme.toUpperCase();
        if (lexeme.matches("\\d+")) return Token.NUM;
        for (String s : Arrays.asList("[\\+\\-*/]", "DUP", "DROP", "OVER", "SWAP")) {
            if (lexeme.matches(s)) return Token.OP;
        }
        if (lexeme.matches("[A-Z|\\-]+")) return Token.USRDEFOP;
        if (lexeme.matches("\\p{P}")) return Token.PUNCT;
        return Token.ERR;
    }

    /*unevaluatedExprDeque contains unevaluated expression and resultDeque contains results of the expression 
     evaluated so far.Result of the next subexpression will also be pushed on the resultDeque*/
    private void evaluateNextSubExpr(Deque<Entry> unevaluatedExprDeque, Deque<Integer> resultDeque) {
        Entry entry = unevaluatedExprDeque.removeFirst();
        switch (entry.token()) {
            case NUM -> resultDeque.addLast(Integer.parseInt(entry.lexeme()));
            case OP -> {
                switch (entry.lexeme()) {
                    case "DROP" -> evaluateDrop(resultDeque);
                    case "DUP" -> evaluateDup(resultDeque);
                    case "OVER" -> evaluateOver(resultDeque);
                    case "SWAP" -> evaluateSwap(resultDeque);
                    case "+", "-", "*", "/" -> evaluateArithmeticOp(entry.lexeme(), resultDeque);
                }
            }
            default -> throw new IllegalStateException("Unexpected lexeme: " + entry.lexeme());
        }
    }

    private void evaluateSwap(Deque<Integer> resultDeque) {
        int operand1;
        int operand2;
        try {
            operand1 = resultDeque.removeLast();
            operand2 = resultDeque.removeLast();
        } catch (Exception exception) {
            throw new IllegalArgumentException("Swapping requires that the stack contain at least 2 values");
        }

        resultDeque.addLast(operand1);
        resultDeque.addLast(operand2);
    }

    private void evaluateOver(Deque<Integer> resultDeque) {
        int operand1;
        int operand2;
        try {
            operand1 = resultDeque.removeLast();
            operand2 = resultDeque.removeLast();
        } catch (Exception exception) {
            throw new IllegalArgumentException("Overing requires that the stack contain at least 2 values");
        }
        resultDeque.addLast(operand2);
        resultDeque.addLast(operand1);
        resultDeque.addLast(operand2);
    }

    private void evaluateDrop(Deque<Integer> resultDeque) {
        try {
            resultDeque.removeLast();
        } catch (Exception exception) {
            throw new IllegalArgumentException("Dropping requires that the stack contain at least 1 value");
        }
    }

    private void evaluateDup(Deque<Integer> resultDeque) {
        int operand;
        try {
            operand = resultDeque.removeLast();
        } catch (Exception exception) {
            throw new IllegalArgumentException("Duplicating requires that the stack contain at least 1 value");
        }
        resultDeque.addLast(operand);
        resultDeque.addLast(operand);
    }

    private void evaluateArithmeticOp(String arithmeticOp, Deque<Integer> resultDeque) {
        int operand1 = 0;
        int operand2 = 0;
        try {
            operand1 = resultDeque.removeLast();
            operand2 = resultDeque.removeLast();
        } catch (Exception exception) {
            switch (arithmeticOp) {
                case "+" ->
                        throw new IllegalArgumentException("Addition requires that the stack contain at least 2 values");
                case "-" ->
                        throw new IllegalArgumentException("Subtraction requires that the stack contain at least 2 values");
                case "*" ->
                        throw new IllegalArgumentException("Multiplication requires that the stack contain at least 2 values");
                case "/" ->
                        throw new IllegalArgumentException("Division requires that the stack contain at least 2 values");
            }
        }
        if (arithmeticOp.equals("/") && operand1 == 0)
            throw new IllegalArgumentException("Division by 0 is not allowed");
        int result;
        result = switch (arithmeticOp) {
            case "+" -> operand2 + operand1;
            case "-" -> operand2 - operand1;
            case "*" -> operand2 * operand1;
            default -> operand2 / operand1;
        };
        resultDeque.addLast(result);
    }
}
