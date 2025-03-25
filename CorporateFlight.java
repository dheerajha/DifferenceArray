class CorporateFlight {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // Edge case: no bookings
        if (bookings == null || bookings.length == 0)
            return new int[n];

        // Step 1: Create a result array to track seat changes
        int[] res = new int[n]; // logn-> sort
        // vishal janaki ,ranjith , -> train arrival , sliding window , two sum
        // Step 2: Apply the difference array technique
        for (int[] booking : bookings) {
            int start = booking[0] - 1; // Convert to 0-based index
            int end = booking[1]; // end is inclusive
            int seats = booking[2];

            res[start] += seats; // Add seats at start
            if (end < n)
                res[end] -= seats; // Remove seats after end
        }

        // Step 3: Convert difference array into the final seat count
        for (int i = 1; i < n; i++) {
            res[i] += res[i - 1];
        }

        return res;
    }
}
