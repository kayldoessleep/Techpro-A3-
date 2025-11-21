import java.util.Scanner;

public class THIRDQSEATWORK1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int count;
        do {
            System.out.print("How many grades (1 to 5): ");
            while (!input.hasNextInt()) {
                System.out.print("Please enter an integer between 1 and 5: ");
                input.next();
            }
            count = input.nextInt();
        } while (count < 1 || count > 5);

        double total = 0;

        for (int i = 1; i <= count; i++) {
            System.out.print("Enter grade " + i + ": ");
            while (!input.hasNextDouble()) {
                System.out.print("Please enter a numeric grade: ");
                input.next();
            }
            double grade = input.nextDouble();
            total += grade;
        }

        double average = total / count;
        System.out.println("Average: " + average);

        char marka;
        if (average >= 90) {
            marka = 'A';
        } else if (average >= 80) {
            marka = 'B';
        } else if (average >= 70) {
            marka = 'C';
        } else if (average >= 60) {
            marka = 'D';
        } else {
            marka = 'F';
        }

        System.out.println("Letter grade: " + marka);
        input.close();
    }
}