package refactoringmaster;

public class HumanWeightCalculator {
    private double Weight; //Weight Human
    private double Height; // Height Human

    public HumanWeightCalculator (double weight, double height) {
        Weight = weight;
        Height = height;
    }

    private double getWeight() {
        return Weight;
    }

    private void setWeight(double weight) {
       this.Weight = weight;
    }

    private double getHeight() {
        return Height;
    }
//Still error with "this", because-of no checks in that code.

    private void setHeight(double height) {
        this.Height = height;
    }

    private static void CalculationResult (double resultOfCalculation, double height, double weight ) {
        resultOfCalculation = ( weight / (height * height));

        if (resultOfCalculation >= 18.5 && resultOfCalculation <= 25) {
            System.out.println("Normis pisun");
        }
        else if (resultOfCalculation >= 25 && resultOfCalculation <= 30) {
            System.out.println("Warning ya ebanyti!");
        }
        else if (resultOfCalculation >= 30) {
            System.out.println("Fat ass go run!");
        }
        else {
            System.out.println("Deficitna kurwa bober");
        }

    }
}
