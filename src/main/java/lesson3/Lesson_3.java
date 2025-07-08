package lesson3;

/* Task 1
public class Lesson_3 {

    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++)
            if (i % 2 == 0 && i % 3 == 0) System.out.println("The number " + i + " is divisible by two and three");
            else if (i % 2 == 0) System.out.println("The number " + i + " is even");
            else if (i % 3 == 0) System.out.println("The number " + i + " is divisible by three");
            else System.out.println("The number " + i + " is odd");
    }
}
*/

/*
import java.util.Scanner;

public class Lesson_3 {

    public static void main(String[] args) {
        Scanner mScanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1 = mScanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = mScanner.nextInt();
        mScanner.close();

        System.out.println(calculateResult(num1, num2));

    }

    ;

    static int calculateResult(int num1, int num2) {
        int result = 0;

        for (int i = num1; i <= num2; ++i) {
            result += i;
        }

        return result;
    }
}
*/


/* Task 3
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lesson_3 {

    public static void main(String[] args) {

        Scanner mScanner = new Scanner(System.in);
        int num1 = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter the height of the pyramid: ");
            try {
                num1 = mScanner.nextInt();
                if (num1 <= 0) {
                    System.out.println("The height must be a positive integer. Please try again.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException m) {
                System.out.println("Invalid input. Please enter a whole number for the height.");
                mScanner.next();
            }
        }
        mScanner.close();

        int arLenght = num1;
        String[] mArray = new String[arLenght];

        for (int i = arLenght; i > 0; i--) {
            String stars = "";
            for (int b = i; b > 0; b--) {
                stars += "*";
            }
            mArray[i - 1] = stars;
            System.out.println(mArray[i - 1]);
        }

        System.out.println("");
        for (int q = 0; q < mArray.length; q++){
            System.out.println(mArray[q]);
        }
    }
}

*/

