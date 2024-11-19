import java.util.Scanner;

public class A3_WeightedGrades {
    private double[] totalPoints;
    private double[] actualPoints;
    private double[] percentages;
    private double totalWeightedGrade = 0;

    public void enterGradesAndPercentages() {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for total points, actual points, and percentages with examples
        System.out.println("==========");
        System.out.print("Enter total points for assignments (e.g., 100, 100): ");
        String totalPointsInput = scanner.nextLine();
        System.out.print("Enter actual points scored (e.g., 90, 80): ");
        String actualPointsInput = scanner.nextLine();
        System.out.print("Enter percentage weights (e.g., 50, 50): ");
        String percentagesInput = scanner.nextLine();

        // Split input strings and parse to arrays
        totalPoints = parseInputToDoubleArray(totalPointsInput);
        actualPoints = parseInputToDoubleArray(actualPointsInput);
        percentages = parseInputToDoubleArray(percentagesInput);

        // Validate the number of inputs
        if (totalPoints.length != actualPoints.length || actualPoints.length != percentages.length) {
            System.out.println("Error: The number of total points, actual points, and percentages must match. Please try again.");
            scanner.close();
            return;
        }

        // Calculate the total weighted grade
        calculateTotalWeightedGrade();
        scanner.close();
    }

    private double[] parseInputToDoubleArray(String input) {
        String[] tokens = input.split(",");
        double[] result = new double[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            result[i] = Double.parseDouble(tokens[i].trim());
        }
        return result;
    }

    private void calculateTotalWeightedGrade() {
        for (int i = 0; i < totalPoints.length; i++) {
            totalWeightedGrade += (actualPoints[i] / totalPoints[i]) * percentages[i];
        }
    }

    public double getTotalWeightedGrade() {
        return totalWeightedGrade;
    }
}
