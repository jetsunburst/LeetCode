import java.util.*;

class JobSchedulingDeadlines {
    public static int optimalFreelancing(Map<String, Integer>[] jobs) {
        // Sort jobs in descending order of payment
        Arrays.sort(jobs, (a, b) -> b.get("payment") - a.get("payment"));

        boolean[] days = new boolean[7]; // Track occupied days
        int maxProfit = 0;

        for (Map<String, Integer> job : jobs) {
            int deadline = job.get("deadline");
            int payment = job.get("payment");

            // Assign job to the latest available day within the deadline
            for (int d = Math.min(deadline, 7) - 1; d >= 0; d--) {
                if (!days[d]) {  // If day is free, take the job
                    days[d] = true;
                    maxProfit += payment;
                    break;
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Map<String, Integer>[] jobs = new Map[]{
            Map.of("deadline", 1, "payment", 1),
            Map.of("deadline", 2, "payment", 1),
            Map.of("deadline", 2, "payment", 2)
        };

        System.out.println(optimalFreelancing(jobs)); // Output: 3
    }
}
