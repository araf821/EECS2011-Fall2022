/**
 * EECS 2011 A, Fall 2022.
 * Assignment 1, Question 2 starter code.
 * Please read carefully the instructions in the assignment handout
 * and the starter code.
 */

import java.util.ArrayList;
// Do NOT add any import

/**
 * A last-in, first-out (LIFO) stack of integers
 * DO NOT MODIFY THIS CLASS.
 * DO NOT ADD ANY OTHER CLASS.
 */
class A1Stack {

    private ArrayList<Integer> data;

    public A1Stack() {
        data = new ArrayList<>();
    }

    public void push(int x) {
        this.data.add((x));
    }

    public int pop() {
        return this.data.remove(this.data.size() - 1);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    public int peek() {
        return this.data.get(this.data.size() - 1);
    }

    public int size() {
        return this.data.size();
    }
}

public class A1Q2 {

    /**
     * The function that you need to implement.
     * Read the assignment handout for the specification.
     */
    public static int solve(int[] arr) {
        // TODO: implement this function
        A1Stack s = new A1Stack();
        int value = 1; // The number of elements that can be outputted in sorted order.
        int indexOf1 = 0; // Keeps track of what the index of 1 is.

        if (arr.length == 0)
            return  0;

        for (int i = 0; i < arr.length; i++) {
            // Add all the values before index of 1 to the stack.
            if (arr[i] != value)
                s.push(arr[i]);
            else {
                // Once we've arrived at value 1, record the index for later use and stop the loop
                indexOf1 = i;
                break;
            }
        }

        int totalSize = arr.length + s.size(); // The # of elements left after 1 that still need sorting
        for (int i = indexOf1 + 1; i < totalSize; i++) {
            // Only check for the arr[i] value if index at i exists in the array
            if (i < arr.length && arr[i] == value + 1) {
                value++;

            // Only check for the s.pop() value if the stack isn't empty
            } else if (!s.isEmpty() && s.pop() == value + 1) {
                value++;
                i--; // We may still need to check the current value of arr[i] after this iteration

            // If arr[i] doesn't contain the next value and neither does the stack,
            // then we add the current arr[i] to the stack, if arr[i] exists
            } else if (i < arr.length) {
                s.push(arr[i]);
                totalSize++;

            // If all of the above fails, then we are done here.
            } else {
                break;
            }
        } // End of the for loop

            return value;
        }

    /**
     * This main function contains a couple of test cases that can be used to verify
     * that your code compiles and runs. Note that these test cases are NOT complete,
     * and you need to test your code thoroughly with more cases.
     */
    public static void main(String[] args) {

        int[] arr1 = {5, 4, 3, 1, 2};
        System.out.println(solve(arr1)); // Output should be 5

        int[] arr2 = {4, 5, 2, 1, 3};
        System.out.println(solve(arr2)); // Output should be 3

        int[] arr3 = {1, 2, 3, 5, 4, 6, 8, 7, 9};
        System.out.println(solve(arr3)); // Output should be 9

        int[] arr4 = {4, 1, 2, 5, 3};
        System.out.println(solve(arr4)); // Output should be 3

        int[] arr5 = {7, 5, 2, 6, 3, 4, 1};
        System.out.println(solve(arr5)); // Output should be 1

        int[] arr6 = {4, 5, 1, 2, 3, 6, 7, 8};
        System.out.println(solve(arr6)); // Output should be 3

        int[] arr7 = {};
        System.out.println(solve(arr7)); // Output should be 0

        int[] arr8 = {1, 2, 5, 6, 4, 3};
        System.out.println(solve(arr8)); // Output should be 4

        int[] arr9 = {6, 5, 4, 3, 2, 1};
        System.out.println(solve(arr9)); // Output should be 6
    }
}
