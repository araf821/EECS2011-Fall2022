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
        A1Stack s = new A1Stack(); // The stack to hold all the elements before 1 in the arr.
        int result = 1; // The number of elements that can be outputted in sorted order.
        int indexOf1 = 0;
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 1) {
                // If the value at current index isn't 1, add it to the stack.
                s.push(arr[i]);
            } else {
                // Else, record the index at which 1 is located and break the loop.
                indexOf1 = i;
                break;
            }
        }

//         If the 1 was in the last index, then we can return all the elements in sorted order.
        if (s.size() == 0)
            return arr.length; // returns the complete number of elements in the array

        // This loop will start incrementing our result.
        while(true) {

            // This loop checks if the next value appears in the array after index of 1.
            for (int i = indexOf1 + 1; i < arr.length; i++) {
                if (arr[i] == (result + 1)) {
                    result++;
                    found = true;
                    break;
                }
            }

            // Now, if we haven't already found the next value in the array...
            if (!found && s.size() > 0) { // if found is false
                if (s.pop() == (result + 1)) {
                    // increment result if the first out of the stack is the value we're looking for
                    result++;
                } else {
                    break;
                }
            } else if (!found && s.size() == 0) {
                break;
            }

            found = false; // reset for the next iteration
        } // while loop ends here

        return result;
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
        System.out.println(solve(arr4)); // Output should be 5

        int[] arr5 = {7, 5, 2, 6, 3, 4, 1};
        System.out.println(solve(arr5)); // Output should be 1

        int[] arr6 = {4, 5, 1, 2, 3, 6, 7, 8};
        System.out.println(solve(arr6)); // Output should be 3

        int[] arr7 = {};
        System.out.println(solve(arr7)); // Output should be 0
    }
}
