package lesson4;

/* Task1
import java.util.Scanner;

public class Lesson_4 {
    public static void main(String[] args) {
        Scanner mScanner = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String str1 = mScanner.nextLine();

        System.out.print("Enter the second string: ");
        String str2 = mScanner.nextLine();
        mScanner.close();

        System.out.println(compareStrings(str1, str2));
    }

    public static String compareStrings(String str1, String str2) {
        String msg = "";
        if (str1.isEmpty() || str2.isEmpty()) {
            msg = "Can not compare Strings.";
        } else if (str1.equals(str2)) {
            msg = "The Strings are the same.";
        } else if (str1.contains(str2)) {
            msg = str2 + " is part of " + str1;
        } else if (str2.contains(str1)) {
            msg = str1 + " is part of " + str2;
        } else msg = "The strings are different.";
        return msg;
    }
}
*/

/* Task2
import java.util.Scanner;

public class Lesson_4 {
    public void main() {
        Scanner mScanner = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String text = mScanner.nextLine();

        mScanner.close();
        if (text.isEmpty()) {
            System.out.println("The String is empty!");
        } else
            System.out.println(isPalindrome(text));
    }

    private boolean isPalindrome(String text) {
        return text.equals(new StringBuffer(text).reverse().toString());
    }
}
*/