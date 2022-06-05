package task2_7;

import util.graph.Graph;

import java.util.*;

public class Task7 {
    public static void findBetween(Graph graph, LinkedList<Integer> visited, int from, int to) {
        Iterable<Integer> nodes = graph.adjacencies(visited.getLast());
        for (Integer node : nodes) {
            if (visited.contains(node)) {
                continue;
            }
            if (node.equals(to)) {
                visited.add(node);
                System.out.println(visited);
                visited.removeLast();
                break;
            }
        }
        for (Integer node : nodes) {
            if (visited.contains(node) || node.equals(to)) {
                continue;
            }
            visited.addLast(node);
            findBetween(graph, visited, from, to);
            visited.removeLast();
        }
    }
}
