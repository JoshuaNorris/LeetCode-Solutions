import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<Node> nodes_not_finalized = createPriorityQueue(n, k);
        int[] paths = createPaths(n, k);
        boolean[] visited = new boolean[n + 1];
        Map<Integer, ArrayList<Node>> adjacency_list = createAdjacencyList(n + 1, times);
        

        // making starting_point our first element
        Node starting_point = new Node(k, 0);
        visited[k] = true;

        boolean flag = true;
        while (flag) {
            ArrayList<Node> children = adjacency_list.get(starting_point.node_id);
            for (Node child : children) {
                int new_path_weight = starting_point.weight + child.weight;
                if (new_path_weight < paths[child.node_id]) {
                    paths[child.node_id] = new_path_weight;
                    child.weight = new_path_weight;
                    nodes_not_finalized.offer(child);
                }
            }
            if (nodes_not_finalized.isEmpty()) {
                break;
            }
            while (true) {
                starting_point = nodes_not_finalized.poll();
                if (visited[starting_point.node_id] != true) {
                    visited[starting_point.node_id] = true;
                    break;
                } else if (nodes_not_finalized.isEmpty()) { 
                    flag = false;
                    break;
                }
            }

        }

        int max = 0;
        for (int x = 1; x <= n; x ++) {
            max = (paths[x] > max) ? paths[x] : max;
            if (paths[x] == Integer.MAX_VALUE) {
                max = -1;
                break;
            }
        }
        return max;

    }

    
    private static int[] createPaths(int n, int k) {
        int[] paths = new int[n + 1];
        for (int x = 0; x < n+1; x++) {
            paths[x] = Integer.MAX_VALUE;
        }
        paths[0] = 0;
        paths[k] = 0;
        return paths;
    }

    private static PriorityQueue<Node> createPriorityQueue(int n, int k) {
        PriorityQueue<Node> nodes_not_finalized = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.weight, e2.weight));
        return nodes_not_finalized;
    }

    private Map<Integer, ArrayList<Node>> addElementToAdjacencyList (int parent, Node child, Map<Integer, ArrayList<Node>> adjacency_list) {
        ArrayList<Node> children = adjacency_list.get(parent);
        children.add(child);
        adjacency_list.put(parent, children);
        return adjacency_list;
    }


    private Map<Integer, ArrayList<Node>> createAdjacencyList(int n, int[][]times) {
        Map<Integer, ArrayList<Node>> adjacency_list = new HashMap<>();
        // Filling adjacency list with empty array lists
        for (int x = 1; x <= n; x++) {
            ArrayList<Node> children = new ArrayList<>();
            adjacency_list.put(x, children);
        }

        // adding all items to adjacency list
        for (int x = 0; x < times.length; x++) {
            int parent = times[x][0];
            Node child = new Node(times[x][1], times[x][2]);
            adjacency_list = addElementToAdjacencyList(parent, child, adjacency_list);
        }
        return adjacency_list;
    }

    private static void printArray(int[] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " ");
        }
    }
    
}

class Node {
    public int node_id;
    public int weight;

    public Node(int node_id, int weight) {
        this.node_id = node_id;
        this.weight = weight;
    }

    public void incrementWeight(int parent_weight) {
        this.weight += parent_weight;
    }

    public void thisIsStartingPoint() {
        this.weight = 0;
    }
    @Override
    public String toString() {
        return "Node [node_id=" + node_id + ", weight=" + weight + "]";
    }
}