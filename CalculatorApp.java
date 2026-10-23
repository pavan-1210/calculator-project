import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculatorService calc = new CalculatorService();
        boolean running = true;

        System.out.println("=== Java Console Calculator ===");
        
        while (running) {
            System.out.println("\nSelect operation: (+, -, *, /, exit)");
            String op = scanner.next();

            if (op.equalsIgnoreCase("exit")) {
                running = false;
                continue;
            }

            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            try {
                double result = switch (op) {
                    case "+" -> calc.add(num1, num2);
                    case "-" -> calc.subtract(num1, num2);
                    case "*" -> calc.multiply(num1, num2);
                    case "/" -> calc.divide(num1, num2);
                    default -> throw new IllegalArgumentException("Invalid operator");
                };
                System.out.printf("Result: %.2f%n", result);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("Calculator closed.");
        scanner.close();
    }
}
