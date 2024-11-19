public class Main {
    public static void main(String[] args) {
        A3_WeightedGrades weightedGrades = new A3_WeightedGrades();
        weightedGrades.enterGradesAndPercentages();
        System.out.println("Total Weighted Grade: " + weightedGrades.getTotalWeightedGrade());
    }
}
