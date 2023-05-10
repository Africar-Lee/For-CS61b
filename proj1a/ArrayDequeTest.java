import java.awt.*;

public class ArrayDequeTest {
	/* Utility method for printing out empty checks. */
	public static boolean checkEmpty(boolean expected, boolean actual) {
		if(expected != actual) {
			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	public static boolean checkSize(int expected, int actual) {
		if(expected != actual) {
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	public static void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}


	public static void addIsEmptySizeTest() {
		System.out.println("Running add/isEmpty/Size test.");
		System.out.println("Make sure to uncomment the lines below (and delete this print statement");
		ArrayDeque<String> ad1 = new ArrayDeque<>();

		boolean passed = checkEmpty(true, ad1.isEmpty());

		ad1.addFirst("front");

		passed = checkSize(1, ad1.size()) && passed;
		passed = checkEmpty(false, ad1.isEmpty()) && passed;

		ad1.addLast("middle");
		passed = checkSize(2, ad1.size()) && passed;

		System.out.println("Printing out deque: ");
		ad1.printDeque();

		printTestStatus(passed);
	}

    public static void addRemoveTest() {
        System.out.println("Running add/remove test.");

        System.out.println("Make sure to uncomment the lins below (and delete this print statement). ");
        ArrayDeque<Integer> ad2 = new ArrayDeque<>();

        boolean passed = checkEmpty(true, ad2.isEmpty());

        ad2.addFirst(10);
        passed = checkEmpty(false, ad2.isEmpty()) && passed;

        ad2.removeFirst();
        passed = checkEmpty(true, ad2.isEmpty()) && passed;

        ad2.addFirst(1);
        ad2.addLast(2);
        ad2.addLast(3);
        ad2.removeFirst();
        System.out.println("Print out deque: ");
        ad2.printDeque();

        printTestStatus(passed);
    }

    public static void main(String[] args) {
        System.out.println("Running test.\n");
        addIsEmptySizeTest();
        addRemoveTest();
    }
}
