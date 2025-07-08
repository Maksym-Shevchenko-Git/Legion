package lesson8;

import java.util.ArrayList;
import java.util.Scanner;

public class Lesson_8 {
    public static void main(String[] args) {
        Scanner mScanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = 0;

        try {
            num = mScanner.nextInt();
            mScanner.close();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Incorrect input. Try again.");
            mScanner.close();
            return;
        }

        System.out.println(getDay(num));
    }

    public static String getDay(Integer dayNumber) {
        ArrayList<String> daysList = new ArrayList<>();
        daysList.add("Sunday");
        daysList.add("Monday");
        daysList.add("Tuesday");
        daysList.add("Wednesday");
        daysList.add("Thursday");
        daysList.add("Friday");
        daysList.add("Saturday");
        if (dayNumber == null) {
            throw new NullPointerException();
        } else if (dayNumber < 1) {
            return "The number should be equal or larger than 1";
        } else if (dayNumber > 7) {
            return "The number should be equal or smaller than 7";
        } else {
            return daysList.get(dayNumber - 1);
        }
    }
}