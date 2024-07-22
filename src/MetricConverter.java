import java.util.InputMismatchException;
import java.util.Scanner;

public class MetricConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("****************************************************************");
        System.out.println("Welcome to the Metric Converter!");
        System.out.println("****************************************************************");
        System.out.println("Available conversions:");
        System.out.println("1. Feet to Meters");
        System.out.println("2. Pounds to Kilograms");
        System.out.println("3. Fahrenheit to Celsius");

        boolean continueConversion = true;

        while (continueConversion) {
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 0:
                    System.out.println("Exiting the Metric Converter. Goodbye!");
                    continueConversion = false;
                    break;
                case 1:
                    performFeetToMetersConversion(scanner);
                    break;
                case 2:
                    performPoundsToKilogramsConversion(scanner);
                    break;
                case 3:
                    performFahrenheitToCelsiusConversion(scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 3.");
                    break;
            }
        }
        scanner.close();
    }

    public static int getUserChoice(Scanner scanner) {
        int choice = -1;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Please enter the number of the conversion you want to perform (1-3), or enter 0 to quit: ");
                choice = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }

        return choice;
    }

    public static void performFeetToMetersConversion(Scanner scanner) {
        String fromUnit = "feet";
        String toUnit = "meters";
        System.out.print("Enter length in feet: ");

        double inputValue = getDoubleInput(scanner);

        double result = feetToMeters(inputValue);
        printConversion(inputValue, fromUnit, result, toUnit);
    }

    public static void performPoundsToKilogramsConversion(Scanner scanner) {
        String fromUnit = "pounds";
        String toUnit = "kilograms";
        System.out.print("Enter weight in pounds: ");

        double inputValue = getDoubleInput(scanner);

        double result = poundsToKilograms(inputValue);
        printConversion(inputValue, fromUnit, result, toUnit);
    }

    public static void performFahrenheitToCelsiusConversion(Scanner scanner) {
        String fromUnit = "Fahrenheit";
        String toUnit = "Celsius";
        System.out.print("Enter temperature in Fahrenheit: ");

        double inputValue = getDoubleInput(scanner);

        double result = fahrenheitToCelsius(inputValue);
        printConversion(inputValue, fromUnit, result, toUnit);
    }

    public static double feetToMeters(double feet) {
        return feet * 0.3048;
    }

    public static double poundsToKilograms(double pounds) {
        return pounds * 0.45359237;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double getDoubleInput(Scanner scanner) {
        double inputValue = 0.0;
        boolean validInput = false;

        while (!validInput) {
            try {
                inputValue = scanner.nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }

        return inputValue;
    }

    public static void printConversion(double inputValue, String fromUnit, double result, String toUnit) {
        System.out.printf("%.2f %s is equal to %.2f %s.%n", inputValue, fromUnit, result, toUnit);
    }
}
