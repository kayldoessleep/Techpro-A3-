import java.util.Scanner;

public class Main {
    public static void THIRDQSEATWORK1(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How many grades (1 to 5): ");
        int count = input.nextInt();

        double total = 0;

        for (int i = 1; i <= count; i++) {
            System.out.print("Enter grade " + i + ": ");
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
}
