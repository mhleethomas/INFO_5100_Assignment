public class WeightedGrades {

    // Attributes for total points, earned points, and percentage weight
    private double totalPoints;
    private double earnedPoints;
    private double percentage;

    // Constructor
    public WeightedGrades(double totalPoints, double earnedPoints, double percentage) {
        this.totalPoints = totalPoints;
        this.earnedPoints = earnedPoints;
        this.percentage = percentage;
    }

    // Method to calculate the weighted grade
    public double calculateWeightedGrade() {
        return (earnedPoints / totalPoints) * percentage;
    }
}
