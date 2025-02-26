package be.kdg.calculator.model;

public class Operand {
    private StringBuilder value = new StringBuilder();

    public void add(OperandCharacter character) throws CalculatorException {
        if (character == OperandCharacter.DECIMAL_SEPARATOR && value.indexOf(",") != -1) {
            throw new CalculatorException("Duplicate decimal separator not allowed.");
        }
        value.append(character.getChar());
    }

    public boolean isValid() {
        if (value.length() == 0) return false;
        String normalizedValue = value.toString().replace(',', '.');
        try {
            Double.parseDouble(normalizedValue);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public double getDoubleValue() throws CalculatorException {
        if (!isValid()) {
            throw new CalculatorException("Invalid operand value: " + value);
        }
        String normalizedValue = value.toString().replace(',', '.');
        return Double.parseDouble(normalizedValue);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public Operand() {
    }

    public Operand(double value) {
        this.value = new StringBuilder(String.valueOf(value).replace('.', ','));
    }
}