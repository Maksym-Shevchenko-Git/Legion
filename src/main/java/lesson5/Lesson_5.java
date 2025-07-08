package lesson5;

/* Task 1
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lesson_5 {

    public static void main(String[] args) {
        ArrayList<String> daysOfWeek = new ArrayList<>(Arrays.asList("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"));

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

        if ((num <= 0) || (num > daysOfWeek.size())) {
            System.out.println("Incorrect input. Try again.");
        } else
            System.out.println(getDay(daysOfWeek, num));
    }

    private static String getDay(ArrayList<String> daysOfWeek, int num) {
        return daysOfWeek.get(num - 1);
    }
}
*/

/* Task 2
import java.util.HashMap;
import java.util.Scanner;

public class Lesson_5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Toy ID: ");
        int id = 0;

        try {
            id = scanner.nextInt();
            scanner.close();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Incorrect input. Try again.");
            scanner.close();
            return;
        }
        System.out.println(getToyById(id, createDataBase()));
    }

    public static HashMap createDataBase() {
        HashMap db = new HashMap();
        db.put(12, "Batmobile");
        db.put(45, "Light Saber");
        db.put(6, "Wonder Woman");
        db.put(201, "Hello Kitty Bag");
        db.put(56, "Junior QA Analyst Doll");

        return db;
    }

    public static String getToyById(int id, HashMap db) {
        try {
            return db.get(id).toString();
        } catch (Exception e) {
            return "No such Toy";
        }
    }
}
*/

/* Task 3
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lesson_5 {

    public static void main(String[] args) {
        displayNames(createAL());
    }

    private static void displayNames(ArrayList<String> al) {
        List<String> names = new ArrayList<>();
        for (String i : al) {
            if (!names.contains(i)) {
                names.add(i);
            }
        }
        for (String i : names) {
            System.out.println(i);
        }
    }

    private static ArrayList<String> createAL() {
        ArrayList<String> ar = new ArrayList<>(Arrays.asList("Steve", "Tim", "Lucy", "Steve", "Pat", "Angela", "Tom", "Tim", "Anna", "Lucy"));
        return ar;
    }
}
*/




