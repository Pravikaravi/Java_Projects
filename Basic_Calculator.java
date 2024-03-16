import java.util.Scanner;

public class Basic_Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Basic Calculator!");
        
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        System.out.print("Select the operator (+, -, /, *, ^, %): ");
        char operator = scanner.next().charAt(0);
        
        double result;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Cannot divide by zero!");
                    return;
                }
                break;
            case '*':
                result = num1 * num2;
                break;
            case '^':
                result = Math.pow(num1, num2);
                break;
            case '%':
                result = num1 % num2;
                break;
            default:
                System.out.println("Error: Invalid operator!");
                return;
        }

        System.out.println("Result: " + result);

        scanner.close();
    }
}
