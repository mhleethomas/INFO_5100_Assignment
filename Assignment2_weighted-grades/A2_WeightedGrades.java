import java.util.Scanner;

public class A2_WeightedGrades{
    // Create a scanner instance for user input
    Scanner scanner = new Scanner(System.in);

    // Method to calculate and display the weighted grade
    public void doWeightedGrades ()
    {
        // Get point total from the user
        System.out.println("Please enter the total points for the assignment:");
        float totalPoints = scanner.nextFloat();
        scanner.nextLine();  // Clear the newline character

        // Get earned points from the user (should be <= point total)
        System.out.println("Please enter the points earned (should be <= the total points):");
        float earnedPoints = scanner.nextFloat();
        scanner.nextLine();  // Clear the newline character

        // Get assignment percentage from the user
        System.out.println("Please enter the assignment's weight as a percentage of overall grade (for example, enter 35 for 35%):");
        float assignmentPercentage = scanner.nextFloat();
        scanner.nextLine();  // Clear the newline character
        scanner.close();  // Close the scanner to avoid resource leaks

        // Calculate the total weighted grade
        float totalWeightedGrade = earnedPoints / totalPoints * assignmentPercentage;
        
        // Output the calculated total weighted grade
        System.out.println("Your total weighted grade for this assignment is: " + totalWeightedGrade + " points");
    }
}