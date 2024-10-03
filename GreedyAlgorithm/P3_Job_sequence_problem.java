package GreedyAlgorithm;
import java.io.IOException;
import java.util.*;

class Job {
   int id, profit, deadline;
   Job(int x, int y, int z) {
      this.id = x;
      this.deadline = y;
      this.profit = z;
   }
}

class solve {
   int[] JobScheduling(Job arr[], int n) {
      // Step 1: Sort jobs by profit in descending order
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));

        // Step 2: Find the maximum deadline to determine the size of the result array
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].deadline > maxDeadline) maxDeadline = arr[i].deadline;
        }

        // Step 3: Create a result array to track available slots
        // Initialize result array with -1 indicating free slots
        int[] result = new int[maxDeadline + 1];
        for (int i = 1; i <= maxDeadline; i++) {
            result[i] = -1; // All slots initially free
        }

        // Variables to track the number of jobs scheduled and the total profit
        int jobCount = 0;
        int totalProfit = 0;

        // Step 4: Iterate over each job and try to schedule it
        for (int i = 0; i < n; i++) {
            // Check for a free slot from the job's deadline moving backwards
            for (int j = arr[i].deadline; j > 0; j--) {
                // If a free slot is found, schedule the job
                if (result[j] == -1) {
                    result[j] = i; // Assign job to this slot
                    jobCount++; // Increment the job count
                    totalProfit += arr[i].profit; // Add profit
                    break; // Job scheduled, move to the next job
                }
            }
        }

        // Step 5: Return the result as an array containing the number of jobs and total profit
        int[] ans = new int[2];
        ans[0] = jobCount; // Number of jobs scheduled
        ans[1] = totalProfit; // Total profit earned
        return ans;
   }
}
class Main {
   public static void main(String[] args) throws IOException {

      //size of array
      Job[] arr = new Job[4];
      arr[0] = new Job(1, 4, 20);
      arr[1] = new Job(2, 1, 10);
      arr[2] = new Job(3, 2, 40);
      arr[3] = new Job(4, 2, 30);

      solve ob = new solve();

      //function call
      int[] res = ob.JobScheduling(arr, 4);
      System.out.println(res[0] + " " + res[1]);

   }
}