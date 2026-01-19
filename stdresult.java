package task3;

import java.util.Scanner;
public class stdresult 
{
    private static final int SUBJECT_COUNT = 5;

    private static double calculatePercentage(int totalMarks) 
    {
        return (double) totalMarks / SUBJECT_COUNT;
    }

    private static char determineGrade(double percentage) 
    {
        if (percentage >= 90) 
        {
            return 'A';
        } 
        else if (percentage >= 75) 
        {
            return 'B';
        } 
        else if (percentage >= 60) 
        {
            return 'C';
        } 
        else if (percentage >= 40) 
        {
            return 'D';
        } 
        else 
        {
            return 'F';
        }
    }

    private static void displayGrade(char grade) 
    {
        switch (grade) 
        {
            case 'A':
                System.out.println("Grade: A (Excellent)");
                break;
            case 'B':
                System.out.println("Grade: B (Very Good)");
                break;
            case 'C':
                System.out.println("Grade: C (Good)");
                break;
            case 'D':
                System.out.println("Grade: D (Pass)");
                break;
            case 'F':
                System.out.println("Grade: F (Fail)");
                break;  
            default:
                System.out.println("Grade: Invalid");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) 
        {
            int totalMarks = 0;
            System.out.println("\nEnter marks for " + SUBJECT_COUNT + " subjects:");
            for (int subject = 1; subject <= SUBJECT_COUNT; subject++) 
            {
                System.out.print("Subject " + subject + ": ");
                int marks = scanner.nextInt();
                if (marks < 0 || marks > 100) 
                {
                    System.out.println("Marks must be between 0 and 100. Re-enter.");
                    subject--;          // retry same subject
                    continue;
                }
                totalMarks += marks;
            }
            double percentage = calculatePercentage(totalMarks);
            char grade = determineGrade(percentage);
            System.out.println("\nSTUDENT RESULT");
            System.out.println("Total Marks     : " + totalMarks);
            System.out.printf("Percentage      : %.2f%%\n", percentage);
            displayGrade(grade);
            System.out.print("\nAdd another student? (yes/no): ");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("no")) 
            {
                break;  // exit loop
            }
        }
        scanner.close();
        System.out.println("\nProgram terminated successfully.");
    }
}
