public class DifferenceArray {
    // Build the difference array
    public static int[] buildDifferenceArray(int[] arr) {
        int n = arr.length;
        int[] diff = new int[n + 1]; // One extra space for easier range updates

        diff[0] = arr[0];
        for (int i = 1; i < n; i++) {
            diff[i] = arr[i] - arr[i - 1]; // Store differences between consecutive elements
        }

        return diff;
    }

    // Update a range from index l to r by val
    public static void updateRange(int[] diff, int l, int r, int val) {
        diff[l] += val; // Increment starting index
        if (r + 1 < diff.length) {
            diff[r + 1] -= val; // Decrement the element right after the range
        }
    }

    // Reconstruct the final array from the difference array
    public static int[] finalArray(int[] diff) {
        int n = diff.length - 1; // Length of the original array
        int[] res = new int[n];

        res[0] = diff[0];
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] + diff[i]; // Prefix sum reconstruction
        }

        return res;
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        int[] arr = { 10, 5, 20, 40 };

        // Build the difference array from the original array
        int[] diff = buildDifferenceArray(arr);

        // Perform range updates
        updateRange(diff, 0, 1, 10);
        updateRange(diff, 1, 3, 20);
        updateRange(diff, 2, 2, 30);

        // Rebuild the final updated array
        int[] res = finalArray(diff);

        // Print the resulting array
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
