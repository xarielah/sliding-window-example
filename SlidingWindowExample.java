class SlidingWindowExample {
    // Didn't want to create some fancy testing cases,
    // just to test this on the driver function.
    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 4, 6, 99, 6, 1, 4, 555 };
        findSubarray(arr, 555); // OK
        findSubarray(arr, 13); // OK
        findSubarray(arr, 105); // OK
        findSubarray(arr, 53421); // BAD
        findSubarray(arr, 52); // BAD

    }

    public static void findSubarray(int[] arr, int target) {
        // Edge case if the array is empty
        if (arr.length == 0) {
            System.out.println("No subarrays found for sum " + target);
            return;
        }

        // Initialize vars
        int sum = 0, left = 0, right = 0;

        // The reason that we are doing this is to also consider
        // the last number, inside the while loop we will limit it not going futher the
        // array boundries.
        while (left <= right) {
            if (left >= arr.length || right >= arr.length) {
                System.out.println("No subarray found for sum " + target);
                return;
            }

            // If during the slide we encounter our target within the array,
            // log a message and break the loop.
            if (arr[right] == target) {
                System.out.println("Subarray from index " + right + " to " + right + " with sum " + target);
                return;
                // As long as the sum is less than target
            } else if (sum < target) {
                // Add the current number to the total sum,
                // and increment the index by one.
                sum += arr[right++];

                // Else if sum is greater than target
            } else if (sum > target) {

                // We subtract the sum with the left index's value,
                // and increment the left index by one.
                sum -= arr[left++];

                // Else, meaning that sum is equal to target, we do this
            } else {
                System.out.println("Subarray from index " + left + " to " + (right - 1) + " with sum " + target);
                return;
            }
        }
    }
}