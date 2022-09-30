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
        int result = 1;
        int i = 0;
        A1Stack s = new A1Stack();
//5, 4, 3, 1, 2
        for(i = 0; i < arr.length; i++) {
            if (arr[i] == 1) break; // Break the loop once we've arrived at 1.
            s.push(arr[i]); // If the element isn't a 1, then push it into the stack.
        }

        // Return the total num of elements if no elements were added to the stack.
        if (s.isEmpty()) {
            return arr.length;
        }

        // Else...
        int indexOf1 = i;
        for (i += 1; i < arr.length; i++) {
            // Loop through the array to check if the containing values in the array
            // include the next value we're looking for, initially looking for a 2.
            for (int j = indexOf1 + 1; j < arr.length; j++) {
                if (arr[j] == result + 1) {
                    result++;
                    break;
                }
            }
            if (s.pop() == result + 1) {
                result++;
            }
        }

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
        System.out.println(solve(arr6)); // Output should be 8
    }
}
