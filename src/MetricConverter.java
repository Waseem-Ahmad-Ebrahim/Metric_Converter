import java.util.InputMismatchException;
import java.util.Scanner;

public class MetricConverter {

    /**
     * Main method to run the Metric Converter program.
     * Displays conversion options and performs conversions based on user input.
     * Allows the user to quit the program or choose different conversions until they decide to quit.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printMenu();

        boolean continueConversion = true;

        while (continueConversion) {
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 0 -> {
                    System.out.println("Exiting the Metric Converter. Goodbye!");
                    continueConversion = false;
                }
                case 1 -> performFeetToMetersConversion(scanner);
                case 2 -> performPoundsToKilogramsConversion(scanner);
                case 3 -> performFahrenheitToCelsiusConversion(scanner);
                default -> System.out.println("Invalid choice. Please enter a number between 0 and 3.");
            }
        }
        scanner.close();
    }

    /**
     * Displays the welcome message and menu options for the Metric Converter program.
     */
    public static void printMenu() {
        System.out.println("****************************************************************");
        System.out.println("Welcome to the Metric Converter!");
        System.out.println("****************************************************************");
        System.out.println("Available conversions:");
        System.out.println("1. Feet to Meters");
        System.out.println("2. Pounds to Kilograms");
        System.out.println("3. Fahrenheit to Celsius");
    }

    /**
     * Prompts the user to enter a conversion choice (1-3) or 0 to quit.
     * Handles InputMismatchException if the user enters a non-integer value.
     * @param scanner Scanner object to read user input
     * @return User's choice of conversion (0 to quit, 1-3 for specific conversions)
     */
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

    /**
     * Performs the Feet to Meters conversion based on user input.
     * @param scanner Scanner object to read user input
     */
    public static void performFeetToMetersConversion(Scanner scanner) {
        String fromUnit = "feet";
        String toUnit = "meters";
        System.out.print("Enter length in feet: ");

        double inputValue = getDoubleInput(scanner);

        double result = feetToMeters(inputValue);
        printConversion(inputValue, fromUnit, result, toUnit);
    }

    /**
     * Performs the Pounds to Kilograms conversion based on user input.
     * @param scanner Scanner object to read user input
     */
    public static void performPoundsToKilogramsConversion(Scanner scanner) {
        String fromUnit = "pounds";
        String toUnit = "kilograms";
        System.out.print("Enter weight in pounds: ");

        double inputValue = getDoubleInput(scanner);

        double result = poundsToKilograms(inputValue);
        printConversion(inputValue, fromUnit, result, toUnit);
    }

    /**
     * Performs the Fahrenheit to Celsius conversion based on user input.
     * @param scanner Scanner object to read user input
     */
    public static void performFahrenheitToCelsiusConversion(Scanner scanner) {
        String fromUnit = "Fahrenheit";
        String toUnit = "Celsius";
        System.out.print("Enter temperature in Fahrenheit: ");

        double inputValue = getDoubleInput(scanner);

        double result = fahrenheitToCelsius(inputValue);
        printConversion(inputValue, fromUnit, result, toUnit);
    }

    /**
     * Converts feet to meters.
     * @param feet Length in feet to convert
     * @return Equivalent length in meters
     */
    public static double feetToMeters(double feet) {
        return feet * 0.305;
    }

    /**
     * Converts pounds to kilograms.
     * @param pounds Weight in pounds to convert
     * @return Equivalent weight in kilograms
     */
    public static double poundsToKilograms(double pounds) {
        return pounds * 0.454;
    }

    /**
     * Converts Fahrenheit to Celsius.
     * @param fahrenheit Temperature in Fahrenheit to convert
     * @return Equivalent temperature in Celsius
     */
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    /**
     * Prompts the user to enter a double value and handles InputMismatchException.
     * @param scanner Scanner object to read user input
     * @return Valid double value entered by the user
     */
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

    /**
     * Prints the result of a conversion in a formatted string.
     * @param inputValue Original value entered by the user
     * @param fromUnit Unit of the original value
     * @param result Converted value
     * @param toUnit Unit of the converted value
     */
    public static void printConversion(double inputValue, String fromUnit, double result, String toUnit) {
        System.out.printf("%.2f %s is equal to %.2f %s.%n", inputValue, fromUnit, result, toUnit);
    }
}
