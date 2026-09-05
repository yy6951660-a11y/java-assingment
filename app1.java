import java.util.Scanner;

public class studentMarks {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 5; i++) {

            System.out.println("\nStudent " + i);

            System.out.print("Enter marks in Subject 1: ");
            double mark1 = sc.nextDouble();

            System.out.print("Enter marks in Subject 2: ");
            double mark2 = sc.nextDouble();

            System.out.print("Enter marks in Subject 3: ");
            double mark3 = sc.nextDouble();

            double total = mark1 + mark2 + mark3;
            double average = total / 3;

            char grade;

            if (average >= 90) {
                grade = 'A';
            } 
            else if (average >= 75) {
                grade = 'B';
            } 
            else if (average >= 60) {
                grade = 'C';
            } 
            else {
                grade = 'D';
            }

            System.out.println("Total   = " + total);
            System.out.println("Average = " + average);
            System.out.println("Grade   = " + grade);
        }

        sc.close();
    }
}
