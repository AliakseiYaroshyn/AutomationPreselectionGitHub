package by.epam.automationpreselection.task1.samplecalculator;

import java.util.Scanner;
import java.math.BigDecimal;

import static java.lang.System.*;

public class SampleCalculator {
    private static Scanner scanner = new Scanner(in);

    public static void main(String[] args) {
        double numberOne = getDouble();
        char operation = getOperation();
        double numberTwo = getDouble();
        if (isDivisorZero(numberTwo,operation)) {
            out.println("Division by zero is prohibited");
        } else {
            out.println("Operation result: " + calculate(numberOne, numberTwo,operation));
        }
    }

    private static BigDecimal calculate(double numberOneDouble, double numberTwoDouble, char operation) {
        BigDecimal calculateResult;
        BigDecimal numberOne = BigDecimal.valueOf(numberOneDouble);
        BigDecimal numberTwo = BigDecimal.valueOf(numberTwoDouble);
        switch (operation) {
            case '+':
                calculateResult = numberOne.add(numberTwo) ;
                break;
            case '-':
                calculateResult = numberOne.subtract(numberTwo);
                break;
            case '*':
                calculateResult = numberOne.multiply(numberTwo);
                break;
            case '/':
                calculateResult = numberOne.divide(numberTwo,8,BigDecimal.ROUND_HALF_UP);
                break;
            default:
                out.print("Operation is not recognized, please re-enter operation value (+,-,*,/): ");
                calculateResult = calculate(numberOneDouble, numberTwoDouble, getOperation());
        }
        return calculateResult;
    }

    private static boolean isDivisorZero(double divisor, char operation) {
          return (divisor == 0 && operation == '/');
        }

    private static double getDouble() {
        out.print("Enter the number: ");
        double number;
        if (scanner.hasNextDouble()) {
            number = scanner.nextDouble();
        } else {
            out.print("Incorrect number value. ");
            scanner.next();
            number = getDouble();
        }
        return number;
    }

    /**
     * @return
     */
    private static char getOperation() {
        out.print("Enter the operation (+,-,*,/): ");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            out.print("Incorrect operation value entered. ");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }
}