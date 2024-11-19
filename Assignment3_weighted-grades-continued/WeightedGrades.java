import java.util.Scanner;

import Lab_six.WeightedGrades;

public class WeightedGrades {
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
            return; // Exit the method if there's an error
        }

        System.out.println("==========");
        scanner.close();
    }

    private double[] parseInputToDoubleArray(String input) {
        // Split by comma and/or space
        String[] stringValues = input.split(",\\s*"); // Regex to split by comma and optional whitespace
        double[] doubleValues = new double[stringValues.length];
        for (int i = 0; i < stringValues.length; i++) {
            String trimmedValue = stringValues[i].trim(); // Trim whitespace
            if (!trimmedValue.isEmpty()) { // Check if the trimmed value is not empty
                try {
                    doubleValues[i] = Double.parseDouble(trimmedValue); // Parse each value
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid number format for input: " + trimmedValue);
                    return new double[0]; // Return an empty array to signal an error
                }
            } else {
                System.out.println("Error: Empty input found. Please provide valid numbers.");
                return new double[0]; // Return an empty array to signal an error
            }
        }
        return doubleValues;
    }

    public void calculateWeightedGrade() {
        for (int i = 0; i < totalPoints.length; i++) {
            // Calculate the weighted score as: (actual score / total points) * weight
            totalWeightedGrade += (actualPoints[i] / totalPoints[i]) * percentages[i];
        }

        System.out.println("Overall weighted grade: " + totalWeightedGrade);

        // Determine letter grade
        char letterGrade;
        if (totalWeightedGrade >= 90) {
            letterGrade = 'A';
        } else if (totalWeightedGrade >= 80) {
            letterGrade = 'B';
        } else if (totalWeightedGrade >= 70) {
            letterGrade = 'C';
        } else if (totalWeightedGrade >= 60) {
            letterGrade = 'D';
        } else {
            letterGrade = 'F';
        }
        System.out.println("Final letter grade: " + letterGrade);
        System.out.println("==========");
    }

    public static void main(String[] args) {
        WeightedGrades grades = new WeightedGrades();
        grades.enterGradesAndPercentages();
        grades.calculateWeightedGrade();
    }
}
