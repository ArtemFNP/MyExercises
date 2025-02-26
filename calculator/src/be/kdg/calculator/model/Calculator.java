package be.kdg.calculator.model;

public class Calculator {
    private Operand operand1;
    private Operator operator;
    private Operand operand2;

    public Calculator() {
        clear();
    }

    public void handleInput(OperandCharacter operandCharacter) throws CalculatorException {
        if (operator == null) {
            // Add this to the first operand.
            if (operand1 == null) {
                operand1 = new Operand();
            }
            operand1.add(operandCharacter);
        }
        else {
            // Add this to the second operand.
            if (operand2 == null) {
                operand2 = new Operand();
            }
            operand2.add(operandCharacter);
        }
    }

    public void handleInput(Operator operator) throws CalculatorException {
        if (operand1 != null && operand1.isValid()) {
            this.operator = operator;
        }
        else {
            throw new CalculatorException("Can't insert operator.");
        }
    }

    public void calculate() throws CalculatorException {
        if (operand2 == null || !operand2.isValid()) {
            throw new CalculatorException("Can't perform calculation.");
        }
        double result = switch (operator) {
            case PLUS -> operand1.getDoubleValue() + operand2.getDoubleValue();
            case MINUS -> operand1.getDoubleValue() - operand2.getDoubleValue();
            case MULTIPLY -> operand1.getDoubleValue() * operand2.getDoubleValue();
            case DIVIDE -> operand1.getDoubleValue() / operand2.getDoubleValue();
        };

        clear();
        operand1 = new Operand(result);
    }

    public void clear() {
        operand1 = null;
        operator = null;
        operand2 = null;
    }

    public String getDisplay() {
        StringBuilder sb = new StringBuilder();
        if (operand1 != null) {
            sb.append(operand1);
            if (operator != null) {
                sb.append(' ');
                sb.append(operator.getChar());
                if (operand2 != null) {
                    sb.append(' ');
                    sb.append(operand2);
                }
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return getDisplay();
    }

    public String getDisplayText() {
        return getDisplay();
    }
}
