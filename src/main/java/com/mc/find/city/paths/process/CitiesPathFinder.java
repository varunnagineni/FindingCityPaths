package com.mc.find.city.paths.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CitiesPathFinder {

    private static final Logger log = LoggerFactory.getLogger(CitiesPathFinder.class);

    private static String  START;
    private static String  END;
    private static boolean flag = false;
    private final Map<String, LinkedHashSet<String>> map = new HashMap<>();

    private void addEdge(String node1, String node2) {
        LinkedHashSet<String> adjacent = map.computeIfAbsent(node1, k -> new LinkedHashSet<>());
        adjacent.add(node2);
    }

    private LinkedList<String> adjacentNodes(String last) {
        LinkedHashSet<String> adjacent = map.get(last);
        if (adjacent == null) {
            return new LinkedList<>();
        }
        return new LinkedList<>(adjacent);
    }

    private void addTwoWayVertex(String node1, String node2) {
        addEdge(node1, node2);
        addEdge(node2, node1);
    }

    public String isPathAvailable(String origin, String destination, List<String> rawData) {

        LinkedList<String> visited = new LinkedList<>();

        try {
            rawData.forEach(data -> {
                String[] str = data.split(",");
                addTwoWayVertex(str[0].trim().toUpperCase(), str[1].trim().toUpperCase());
            });

            START = origin.toUpperCase();
            END = destination.toUpperCase();

            visited.add(START);
            if(this.breadthFirst(visited)) {
                flag = false;
                return "YES";
            } else
                return "NO";
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new ArrayIndexOutOfBoundsException(ex.getMessage());
        }
    }

    private boolean breadthFirst(LinkedList<String> visited) {
        LinkedList<String> nodes = adjacentNodes(visited.getLast());
        for (String node : nodes) {
            if (visited.contains(node)) {
                continue;
            }
            if (node.equals(END)) {
                visited.add(node);
                log.info("Yes there exists a path between " + START
                        + " and " + END);
                flag = true;
                visited.removeLast();
                break;
            }
        }
        for (String node : nodes) {
            if (visited.contains(node) || node.equals(END)) {
                continue;
            }
            visited.addLast(node);
            breadthFirst(visited);
            visited.removeLast();
        }
        return flag;
    }
}
