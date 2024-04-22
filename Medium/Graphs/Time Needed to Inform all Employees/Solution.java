// https://leetcode.com/problems/time-needed-to-inform-all-employees/description/

import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int[] amount_of_time = new int[n];
        Queue<Integer> manager_queue = new LinkedList<>();
        Map<Integer, Queue<Integer>> manager_to_subordinates = new HashMap<>();
        for (int x = 0; x < n; x++) {
            Queue<Integer> these_subordinates = manager_to_subordinates.get(manager[x]);
            if (these_subordinates == null) {
                Queue<Integer> array = new LinkedList<>();
                array.offer(x);
                manager_to_subordinates.put(manager[x], array);
            } else {
                these_subordinates.offer(x);
                manager_to_subordinates.put(manager[x], these_subordinates);
            }
        }

        while (true) {
            Queue<Integer> these_subordinates = manager_to_subordinates.get(headID);
            while (these_subordinates != null && !these_subordinates.isEmpty()) {
                Integer this_employee = these_subordinates.poll();
                if (amount_of_time[this_employee] == 0) {
                    amount_of_time[this_employee] = Integer.MAX_VALUE;
                    manager_queue.offer(this_employee);
                }
                if (informTime[headID] < amount_of_time[this_employee]) {
                    amount_of_time[this_employee] = informTime[headID];
                    informTime[this_employee] = informTime[this_employee] + informTime[headID];
                }
            }
            if (manager_queue.isEmpty()) {
                break;
            } else {
                headID = manager_queue.poll();
            }

        }


        int max_time = 0;
        for (int x = 0; x < n; x++) {
            max_time = (amount_of_time[x] > max_time) ? amount_of_time[x] : max_time;
        }
        return max_time;
        
    }
}