package lesson2;


/*Task 1
import java.util.Scanner;

public class Lesson2Main {

    public static void main(String[] args) {
        Scanner mScanner = new Scanner(System.in);
        String userName = "";
        while (userName.isEmpty()) {
            System.out.print("Enter your name, please: ");
            userName = mScanner.nextLine();
            if (userName.isEmpty()) {
                System.out.println("You did not enter a name. Please try again.");
            }
        }
        System.out.println("Hello " + System.lineSeparator() + userName);
        mScanner.close();
    }
}
*/



// Task 2
/*
public class Lesson_3 {

    public static void main(String[] args) {
        double amont = -5 + 8 * 6;
        System.out.println("Result of -5 + 8 * 6 = " + amont);

        amont = 20 + (-3 * 5) / 8.0;
        System.out.println("Result of 20 + (-3*5) / 8 = " + amont);
    }
}
*/


/* Task 3
import java.util.Locale;

public class Lesson2Main {

    public static void main(String[] args) {
        double num1 = Double.parseDouble(String.format(Locale.US, "%.1f", Math.random()));
        double num2 = Double.parseDouble(String.format(Locale.US, "%.1f", Math.random()));
        double num3 = Double.parseDouble(String.format(Locale.US, "%.1f", Math.random()));
        double num4 = Double.parseDouble(String.format(Locale.US, "%.1f", Math.random()));
        double num5 = Double.parseDouble(String.format(Locale.US, "%.1f", Math.random()));

        double result = num1 * num2 * num3 * num4 * num5;

        System.out.println("number " + num1 + " * number " + num2 + " * number " + num3 + " * number " + num4 + " * number " + num5 + " equals " + result);
    }
}
*/