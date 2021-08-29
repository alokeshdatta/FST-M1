package activities;

import java.util.*;

public class Activity2 {
    public static void main(String[] args) {
        int[] arr = {10, 77, 10, 54, -11, 10};
        System.out.println("Original Array: " + Arrays.toString(arr));
        int Num1 = 10;
        int Sum = 30;

        System.out.println("Result: " + result(arr, Num1, Sum));
    }

    public static boolean result(int[] numbers, int Num1, int Sum) {
        int temp_sum = 0;
        for (int number : numbers) {
            if (number == Num1) {
                temp_sum += Num1;
            }

            if (temp_sum > Sum) {
                break;
            }
        }

        return temp_sum == Sum;
    }
}