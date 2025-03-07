package refactoringmaster;

public class BMICalculator {
    private double weight;
    private double height;
    private double resultOfCalculation;

    public BMICalculator (double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    private double getWeight() {
        return weight;
    }

    private void setWeight(double weight) {
        if (weight <= 0) {
            System.out.println("Weight cannot be negative");
        } else if (weight == 0) {
            System.out.println("Weight cannot be zero");
        } else {
            this.weight = weight;
        }
    }

    private double getHeight() {
        return height;
    }

    private void setHeight(double height) {
        if (height <= 0) {
            System.out.println("Weight cannot be negative");
        } else if (height == 0) {
            System.out.println("Weight cannot be zero");
        } else {
            this.height = height;
        }
    }

   public double getBMI () {
        return weight / (height * height);
   }


    public String getResultOfCalculation () {
        double BMI = getBMI();
     if (BMI >= 18.5 && BMI <= 25) {
         return "Normal";
     } else if (BMI >= 25 && BMI <= 30) {
         return "Overweight";
     } else if (BMI >= 30) {
         return "Obese";
     }
        else return "Underweight";
    }
}
