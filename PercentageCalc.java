import java.util.*;
public class PercentageCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many subjects are you enrolled in? ");
        int numberOfSubjects = scanner.nextInt();
        System.out.println("Please enter your marks for each subject (maximum 100 points each):");
        int accumulatedMarks = 0;
        for (int subject = 1; subject <= numberOfSubjects; subject++) {
            System.out.print("Marks for subject " + subject + ": ");
            int marks = scanner.nextInt();
            accumulatedMarks += marks;
        }
        double averageScore = (double) accumulatedMarks / numberOfSubjects;
        char finalGrade;
        if (averageScore >= 90) {
            finalGrade = 'A';
        } else if (averageScore >= 80) {
            finalGrade = 'B';
        } else if (averageScore >= 70) {
            finalGrade = 'C';
        } else if (averageScore >= 60) {
            finalGrade = 'D';
        } else {
            finalGrade = 'F';
        }
        System.out.println("\nSummary:");
        System.out.println("Total Marks Achieved: " + accumulatedMarks);
        System.out.println("Average Score: " + averageScore + "%");
        System.out.println("Final Grade: " + finalGrade);
        scanner.close();
    }
}


