import java.util.Scanner;
import java.lang.Math;
//task 2
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1 = 0.0;
        double num2 = 0.0;
        char operator = ' ';
        double result = 0.0;
        boolean validOperation = true;

        
        while (true) {
            System.out.print("Enter the first number: ");
            if (scanner.hasNextDouble()) {
                num1 = scanner.nextDouble();
                scanner.nextLine();
                break;
            } else {
                System.out.println("❌ Error: Please enter a valid number (e.g., 5, 3.14)");
                scanner.nextLine();
            }
        }

        
        while (true) {
            System.out.print("Enter an operator (+, -, *, /, ^): ");
            String opInput = scanner.nextLine().trim();
            if (opInput.length() == 1) {
                operator = opInput.charAt(0);
                if ("+-*/^".contains(String.valueOf(operator))) {
                    break;
                } else {
                    System.out.println("❌ Error: Operator must be +, -, *, /, or ^");
                }
            } else {
                System.out.println("❌ Error: Enter only ONE character for the operator");
            }
        }

        // Safe Second Number Input
        while (true) {
            System.out.print("Enter the second number: ");
            if (scanner.hasNextDouble()) {
                num2 = scanner.nextDouble();
                scanner.nextLine();
                break;
            } else {
                System.out.println("❌ Error: Please enter a valid number (e.g., 5, 3.14)");
                scanner.nextLine();
            }
        }

        // Robust Operation Logic (Traditional Switch Syntax)
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (Math.abs(num2) < 1e-9) {
                    System.out.println("❌ Error: Cannot divide by zero or a value very close to zero");
                    validOperation = false;
                } else {
                    result = num1 / num2;
                }
                break;
            case '^':
                if (num1 < 0 && num2 % 1 != 0) {
                    System.out.println("❌ Error: Negative numbers cannot have fractional exponents (e.g., (-4)^0.5 is invalid)");
                    validOperation = false;
                } else {
                    result = Math.pow(num1, num2);
                    if (Double.isNaN(result) || Double.isInfinite(result)) {
                        System.out.println("❌ Error: Calculation result is invalid (too large or mathematically impossible)");
                        validOperation = false;
                    }
                }
                break;
        }

        // Clean Result Output
        if (validOperation) {
            if (result == Math.floor(result)) {
                System.out.printf("✅ Result: %.0f%n", result);
            } else {
                System.out.printf("✅ Result: %.4f%n", result);
            }
        }

        scanner.close();
    }
}
