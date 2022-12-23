package problem.baekjoon.MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No4195 {
    static class Node {
        int count;
        String parent;

        public Node(int count, String parent) {
            this.count = count;
            this.parent = parent;
        }
    }

    static Map<String, Node> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            map = new HashMap<>();

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name1 = st.nextToken();
                String name2 = st.nextToken();
                Node parent;

                if (map.containsKey(name1)) {
                    if (map.containsKey(name2)) {
                        parent = union(name1, name2);
                    } else {
                        parent = find(name1);
                        parent.count++;
                        map.put(name2, parent);
                    }
                } else if (map.containsKey(name2)) {
                    parent = find(name2);
                    parent.count++;
                    map.put(name1, parent);
                } else {
                    parent = new Node(2, name1);
                    map.put(name1, parent);
                    map.put(name2, parent);
                }
                result.append(parent.count).append('\n');
            }

        }

        System.out.print(result);
    }

    private static Node union(String name1, String name2) {
        Node parent1 = find(name1);
        Node parent2 = find(name2);
        if (!parent1.parent.equals(parent2.parent)) {
            parent1.count += parent2.count;
            parent2.parent = parent1.parent;
        }

        return parent1;
    }

    private static Node find(String name) {
        Node node = map.get(name);
        if (node.parent.equals(name)) {
            return node;
        }

        Node parent = find(node.parent);
        map.put(name, parent);
        return parent;
    }

}