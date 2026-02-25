
    import java.util.Scanner;

public class Currency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Currency Converter");
        System.out.println("1. USD to INR");
        System.out.println("2. INR to USD");
        System.out.println("3. EUR to USD");
        System.out.println("4. USD to EUR");
        System.out.println("5. Exit");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter amount in USD: ");
                double usdAmount = scanner.nextDouble();
                double inrAmount = usdToInr(usdAmount);
                System.out.printf("%.2f USD is equal to %.2f INR%n", usdAmount, inrAmount);
                break;
            case 2:
                System.out.print("Enter amount in INR: ");
                double inrAmount2 = scanner.nextDouble();
                double usdAmount2 = inrToUsd(inrAmount2);
                System.out.printf("%.2f INR is equal to %.2f USD%n", inrAmount2, usdAmount2);
                break;
            case 3:
                System.out.print("Enter amount in EUR: ");
                double eurAmount = scanner.nextDouble();
                double usdAmount3 = eurToUsd(eurAmount);
                System.out.printf("%.2f EUR is equal to %.2f USD%n", eurAmount, usdAmount3);
                break;
            case 4:
                System.out.print("Enter amount in USD: ");
                double usdAmount4 = scanner.nextDouble();
                double eurAmount2 = usdToEur(usdAmount4);
                System.out.printf("%.2f USD is equal to %.2f EUR%n", usdAmount4, eurAmount2);
                break;
            case 5:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private static double usdToInr(double usdAmount) {
        return usdAmount * 74.83; // 1 USD = 74.83 INR (approximate exchange rate)
    }

    private static double inrToUsd(double inrAmount) {
        return inrAmount / 74.83; // 1 INR = 1/74.83 USD (approximate exchange rate)
    }

    private static double eurToUsd(double eurAmount) {
        return eurAmount * 1.12; // 1 EUR = 1.12 USD (approximate exchange rate)
    }

    private static double usdToEur(double usdAmount) {
        return usdAmount / 1.12; // 1 USD = 1/1.12 EUR (approximate exchange rate)
    }
}

