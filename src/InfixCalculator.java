public class InfixCalculator {

    /**
     * Evaluate takes in a String expression and returns the mathematical value
     * The expression needs to be separated with spaces
     * e.g. ( ( 12 * 5 ) / 6 ) will work
     * while ((12*5) /6) will not work
     * @param expression is the String expression of the sum
     * @return double result
     */
    public static double evaluate(String expression) {
        GenericStack<String> operators = new GenericStack<String>();
        GenericStack<Double> operands = new GenericStack<Double>();

        //Split the expression into its constituent parts
        //using <space> as a delimiter
        String[] parts = expression.split(" ");

        for(String currPart:parts) {
            switch (currPart) {
                case ("("):
                    break;
                case ("+"):
                case ("-"):
                case ("*"):
                case ("/"):
                    operators.push(currPart);
                    break;
                case (")"):
                    double rightOperand = operands.pop();
                    double leftOperand = operands.pop();
                    double result = 0;
                    String operator = operators.pop();
                    switch (operator) {
                        case ("+") -> result = leftOperand + rightOperand;
                        case ("-") -> result = leftOperand - rightOperand;
                        case ("*") -> result = leftOperand * rightOperand;
                        case ("/") -> result = leftOperand / rightOperand;
                    }
                    operands.push(result);
                    break;
                default:
                    operands.push(Double.parseDouble(currPart));
                    break;

            }
        }
        double result = operands.pop();
        System.out.println(result);
        return result;
    }
}
