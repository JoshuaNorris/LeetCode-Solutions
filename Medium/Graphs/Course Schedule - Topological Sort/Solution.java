// https://leetcode.com/problems/course-schedule/


import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] in_degrees = new int[numCourses];
        int[] removed = new int[numCourses];
        Queue<Integer> in_degree_0 = new LinkedList<>();
        Map<Integer, Queue<Integer>> adjacency_list = new HashMap<>();
        for (int x = 0; x < numCourses; x++) {
            Queue<Integer> children = new LinkedList<>();
            adjacency_list.put(x, children);
        }



        // STEP 1 FILL DATA STRUCTURES
        for (int x = 0; x < prerequisites.length; x++) {
            int parent = prerequisites[x][1];
            int child = prerequisites[x][0];
            in_degrees[child]++;
            adjacency_list = addElementToAdjacencyList(parent, child, adjacency_list);
        }

        for (int x = 0; x < numCourses; x++) {
            if (in_degrees[x] == 0) {
                in_degree_0.offer(x);
                removed[x] = 1;
            }
        }

        // STEP 2 TOPOLOGICAL SORT
        while (!in_degree_0.isEmpty()) {
            int current_node = in_degree_0.poll();
            Queue<Integer> current_children = adjacency_list.get(current_node);
            while (!current_children.isEmpty()) {
                int child = current_children.poll();
                in_degrees[child] --;
                if (in_degrees[child] == 0) {
                    in_degree_0.offer(child);
                    removed[child] = 1;
                }
            }
        }

        // STEP 3 CHECK TO SEE IF ANY NODE HAS NOT BEEN REMOVED
        
        for (int x = 0; x < numCourses; x++) {
            if (removed[x]==0) {
                return false;
            }
        }
        
        return true;
    }

    private Map<Integer, Queue<Integer>> addElementToAdjacencyList (int parent, int child, Map<Integer, Queue<Integer>> adjacency_list) {
        Queue<Integer> children = adjacency_list.get(parent);
        children.offer(child);
        adjacency_list.put(parent, children);
        return adjacency_list;
    }

    private static void printArray(int[] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " ");
        }
    }
}